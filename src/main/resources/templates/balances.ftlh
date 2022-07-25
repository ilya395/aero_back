<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Поступления товаров (партии закупок)</title>
</head>
<body>
<h4>Информация о товаре: ${balances.product.name}, ${balances.product.color}, ${balances.product.size}</h4>
<h2>Добавить партию</h2>
<form method="post" action="/balances/add">
    <label>Количество, шт.:
        <input name="number" placeholder="Например, 15">
    </label>
    <label>Стоимость поставки указанного кол-ва товаров, руб.:
        <input name="totalPrice" placeholder="Например, 6599.05">
    </label>
    <label>Наценка, % от закупочной цены:
        <input name="margin" placeholder="Например, 90">
    </label>
    <input type="submit" value="Добавить">
</form>
<table>
    <tr>
        <th>ID товара</th>
        <th>Количество, шт.</th>
        <th>Стоимость поставки, руб.</th>
        <th>Цена закупочная за 1 шт., руб.</th>
        <th>Цена продажи за 1 шт., руб.</th>
        <th>Величина наценки, % от закупочной цены</th>
        <th>Действия</th>
    </tr>
    <#list balances as balance>
        <tr>
            <td>${balance.id}</td>
            <td>${balance.number}</td>
            <td>${balance.totalPrice}</td>
            <td>${balance.purchasePrice}</td>
            <td>${balance.sellingPrice}</td>
            <td>${balance.margin}</td>
            <td>
                <form method="post" action="/balances/${balance.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
                <a href="/products/${product.id}/balances/${balance.id}">Перейти</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>