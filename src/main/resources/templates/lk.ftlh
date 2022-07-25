<!doctype html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Заказы</title>
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
<form method="get" action="/cart">
    <input type="submit" value="Перейти в корзину">
</form>
<form method="get" action="/index">
    <input type="submit" value="К товарам">
</form>
<h2>Личные данные</h2>
<form method="post" action="/lk">
    <label>Имя
        <input type=text name="firstName" value=${user.firstName}>
    </label>
    <label>Фамилия
        <input type=text name="lastName" value=${user.lastName}>
    </label>
    <input type="submit" value="Изменить">
</form>
<h2>Ваши заказы</h2>
<table>
    <tr>
        <th>Дата</th>
        <th>Стоимость</th>
        <th>Способ оплаты</th>
        <th>Статус заказа</th>
    </tr>
    <#list ordersGroups as ordersGroup>
        <tr>
            <td align="center">${ordersGroup.date}</td>
            <td align="center">${ordersGroup.totalPrice}</td>
            <td align="center">${ordersGroup.paymentMethod}</td>
            <td align="center">${ordersGroup.status.toString()}</td>
        </tr>
    </#list>
</table>
</body>
</html>
