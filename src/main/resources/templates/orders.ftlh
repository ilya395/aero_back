<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Заказы</title>
</head>
<body>
<h2>Добавление нового заказа</h2>
<form method="post" action="/orders/add">
    <input type="submit" value="Добавить заказ">
</form>
<h1>Все заказы</h1>
<table>
    <tr>
        <th>Номер заказа</th>
        <th>Заказчик</th>
        <th>Адрес</th>
        <th>Дата</th>
        <th>Сумма, руб.</th>
        <th>Тип оплаты</th>
        <th>Оплаченная сумма, руб.</th>
        <th>Сумма, оставшаяся к оплате, руб.</th>
        <th>Статус заказа</th>
        <th>Действия</th>
    </tr>
    <#list orders as order>
        <tr>
            <td>${order.id}</td>
            <td>${order.client.name}</td>
            <td>${order.address}</td>
            <td>${order.date}</td>
            <td>${order.price}</td>
            <td>${order.paymentMethod}</td>
            <td>${order.payed}</td>
            <td>${order.toPaySum}</td>
            <td>${order.orderStatus}</td>
            <td>
                <form method="post" action="/orders/${order.id}/read">
                    <input type="submit" value="Перейти">
                </form>
                <form method="post" action="/orders/${order.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>