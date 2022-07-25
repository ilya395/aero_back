<!doctype html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Корзина</title>
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
<form method="get" action="/index">
    <input type="submit" value="К товарам">
</form>
<form method="get" action="/lk">
    <input type="submit" value="Личный кабинет">
</form>

<h1>Товары в корзине</h1>

<table>
    <tr>
        <th>Название</th>
        <th>Описание</th>
        <th>Цена</th>
        <th>Количество</th>
    </tr>
    <#list orders as order>
        <tr>
            <td align="center">${order.product.name}</td>
            <td align="center">${order.product.description}</td>
            <td align="center">${order.product.price}</td>
            <td align="center">${order.count}</td>
            <td>
                <form method="post" action="/cart/${order.id}/increaseCount">
                    <input type="submit" value="+">
                </form>
            </td>
            <td>
                <form method="post" action="/cart/${order.id}/decreaseCount">
                    <input type="submit" value="-">
                </form>
            </td>
            <td>
                <form method="post" action="/cart/${order.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
            </td>
        </tr>
    </#list>
</table>
<h3>Сумма заказа: ${totalprice}</h3>
<form method="post" action="cart/checkout">
    <table>
        <tr>
            <th>Оформление заказа</th>
        </tr>
        <tr>
            <td>
                <label>Адрес доставки
                    <input type=text name="address" placeholder="Введите адрес...">
                </label>
            </td>
        </tr>
        <tr>
            <td>
                Метод оплаты
                <p><input type="radio" name="paymentMethod" value="cash">наличные<Br>
                    <input type="radio" name="paymentMethod" value="creditCard">банковская карта</p>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Оформить заказ">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
