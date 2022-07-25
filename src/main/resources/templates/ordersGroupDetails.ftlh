<!doctype html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Подробности заказа</title>
    <style type="text/css">
        TABLE {
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
        }
        TD, TH {
            border: 1px solid black; /* Параметры рамки */
        }
        TH {
            background: #b0e0e6; /* Цвет фона */
        }
    </style>
</head>
<body>
<form method="get" action="/admin">
    <input type="submit" value="Страница администратора">
</form>
<form method="get" action="/admin/orders">
    <input type="submit" value="Все заказы">
</form>
<form method="get" action="/lk">
    <input type="submit" value="Личный кабинет">
</form>
<form method="get" action="/index">
    <input type="submit" value="К товарам">
</form>

<h3>Заказ</h3>
<table>
    <tr>
        <th>Id</th>
        <th>Дата</th>
        <th>Id заказчика</th>
        <th>Способ оплаты</th>
        <th>адрес доставки</th>
        <th>Статус заказа</th>
        <th>Стоимость</th>
    </tr>
    <tr>
        <td align="center">${ordersGroup.id}</td>
        <td align="center">${ordersGroup.date}</td>
        <td align="center">${ordersGroup.user.id}</td>
        <td align="center">${ordersGroup.paymentMethod}</td>
        <td align="center">${ordersGroup.address}</td>
        <td align="center">${ordersGroup.status}</td>
        <td align="center">${ordersGroup.totalPrice}</td>
    </tr>
</table>

<h3>Товары</h3>
<table>
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Количество</th>
    </tr>
    <#list orders as order>
    <tr>
        <td align="center">${order.product.id}</td>
        <td align="center">${order.product.name}</td>
        <td align="center">${order.count}</td>
        </#list>
</table>
</body>
</html>
