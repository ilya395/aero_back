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
        <th>Дата</th>
        <th>ID заказчика</th>
        <th>Имя заказчика</th>
        <th>Фамилия заказчика</th>
        <th>Товары</th>
        <th>Стоимость</th>
        <th>Метод оплаты</th>
        <th>Статус заказа</th>
        <th>Новый статус заказа</th>
    </tr>
    <#list ordersGroups as ordersGroup>
        <tr>
            <td align="center">${ordersGroup.id}</td>
            <td align="center">${ordersGroup.date}</td>
            <td align="center">${ordersGroup.user.id}</td>
            <td align="center">${ordersGroup.user.firstName}</td>
            <td align="center">${ordersGroup.user.lastName}</td>
            <td>
                <form method="get" action="/admin/orders/${ordersGroup.id}">
                    <input type="submit" value="смотреть состав заказа">
                </form>
            </td>
            <td align="center">${ordersGroup.totalPrice}</td>
            <td align="center">${ordersGroup.paymentMethod.getAlias()}</td>
            <td align="center">${ordersGroup.status.getAlias()}</td>
            <td align="center">
                <form method="post" action="/admin/orders/${ordersGroup.id}/changeStatus">
                    <select size="1" name="status" id="status">
                        <option value="" selected disabled hidden>Выберите статус</option>
                        <option value="processing">обрабатывается</option>
                        <option value="collecting">собирается</option>
                        <option value="shipping">доставляется</option>
                        <option value="shipped">доставлен</option>
                    </select>
                    <input type="submit" value="Изменить статус">
                </form>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>
