<!doctype html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Категории</title>
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

<h2>Категории</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Id ролителя</th>
        <th>новый ролитель</th>
    </tr>
    <tr>
        <td align="center">1</td>
        <td>Все товары</td>
        <td></td>
        <td></td>
    </tr>
    <#list categories as category>
        <tr>
            <form method="post" action="/admin/products/${category.id}/editCategory">
                <td align="center">${category.id}</td>
                <td align="center"><input name="name" value="${category.name}"></td>
                <td align="center">${category.parentId}</td>
                <td><p><#list parents as parent>
                            <input type = radio name = "parentId" value=${parent.id}>${parent.name}<Br>
                        </#list></p>
                </td>
                <td><input type="submit" value="Изменить..."></td>
            </form>
        </tr>
    </#list>
    <tr>
        <form method="post" action="/admin/categories/addCategory">
            <td>...</td>
            <td align="center"><input type=text name="name" value="Введите имя категории"></td>
            <td></td>
            <td><p><#list parents as parent>
                        <input type = radio name = "parentId" value=${parent.id}>${parent.name}<Br>
                    </#list></p>
            </td>
            <td><input type="submit" value="Создать..."></td>
        </form>
    </tr>
</table>
</body>
</html>
