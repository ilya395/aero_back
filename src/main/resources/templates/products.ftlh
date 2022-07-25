<!doctype html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Товары</title>
    <style type="text/css">
        TABLE {
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
        }
        TD, TH {
            border: 1px solid black; /* Параметры рамки */
        }
        TH {
            background: #f17063; /* Цвет фона */
        }
    </style>
</head>
<body>
<form method="get" action="/cart">
    <input type="submit" value="Перейти в корзину">
</form>
<form method="get" action="/lk">
    <input type="submit" value="Личный кабинет">
</form>
<h1></h1>
<form method="get" action="/index">
    <input type="submit" value="Все товары">
</form>
<table>
    <#list categories as category>
        <tr>
            <form method="get" action="/productSortedByCategory/${category.id}">
                <#if category.secondaryPath == 0>
                    <td><input type="submit" value="${category.name}"></td>
                    <td></td>
                <#else>
                    <td></td>
                    <td><input type="submit" value="${category.name}"></td>
                </#if>
            </form>
        </tr>
    </#list>
</table>
<h3>Товары</h3>
<table>
    <tr>
        <th>Название</th>
        <th>Описание</th>
        <th>Цена</th>
        <th>В наличии, шт</th>
        <th>Положить в корзину, шт</th>
    </tr>
    <#list products as product>
        <tr>
            <td align="center">${product.name}</td>
            <td align="center">${product.description}</td>
            <td align="center">${product.price}</td>
            <td align="center">${product.count}</td>
            <td>
                <form method="post" action="/products/${product.id}/to_kart">
                    <input type="number" id="count" name="count" value="1" min="0" max="product.count">
                    <input type="submit" value="В корзину">
                </form>
            </td>
        </tr>
    </#list>
</table>
<div style="position: absolute; right: 0; top: 0">
    <form method="get" action="/signIn">
        <input type="submit" value="Войти">
    </form>
    <form method="get" action="/signUp">
        <input type="submit" value="Зарегистрироваться">
    </form>
</div>

</body>
</html>
