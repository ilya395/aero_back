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
            border: 1px solid #000000; /* Параметры рамки */
        }
        TH {
            background: #169612; /* Цвет фона */
        }
    </style>
</head>
<body>
<form method="get" action="/admin">
    <input type="submit" value="Страница администратора">
</form>
<form method="get" action="/lk">
    <input type="submit" value="Личный кабинет">
</form>
<form method="get" action="/index">
    <input type="submit" value="К товарам">
</form>

<h2>Вcе заказы</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Описание</th>
        <th>Цена</th>
        <th>Количество</th>
        <th>Категория</th>
        <th>Новая категория</th>
    </tr>
    <#list products as product>
        <tr>
            <form method="post" action="/admin/products/${product.id}/editProduct">
                <td align="center">${product.id}</td>
                <td align="center"><input type=textarea
                                          style="width:200px"
                                          name="name" value="${product.name}"></td>
                <td align="center"><input type=textarea
                                          style="width:300px"
                                          name="description" value="${product.description}"></td>
                <td align="center"><input type=text name="price" value="${product.price}"></td>
                <td align="center"><input type=text name="count" value="${product.count}"></td>
                <td align="center">${product.category.name}</td>
                <td>
                    <select size="1" name="category" id="category">
                        <option selected value="1">все товары</option>
                        <#list categories as category>
                            <option value="${category.id}">${category.name}</option>
                        </#list>
                    </select>
                </td>
                <td><input type="submit" value="Изменить..."></td>
            </form>
        </tr>
    </#list>
    <tr>
        <form method="post" action="/admin/products/addProduct">
            <td align="center">...</td>
            <td align="center"><input type=textarea
                                      style="width:200px"
                                      name="name" value="Введите название"></td>
            <td align="center"><input type=textarea
                                      style="width:300px"
                                      name="description" value="Введите описание"></td>
            <td align="center"><input type=text name="price" value="Введите цену"></td>
            <td align="center"><input type=text name="count" value="Введите количество"></td>
            <td align="center">...</td>
            <td>
                <select size="1" name="category" id="category">
                    <option selected value="1">все товары</option>
                    <#list categories as category>
                        <option value="${category.id}">${category.name}</option>
                    </#list>
                </select>
            </td>
            <td><input type="submit" value="Создать..."></td>
        </form>
    </tr>
</table>
</body>
</html>
