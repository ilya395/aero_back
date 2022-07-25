<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Товары на складе</title>
</head>
<body>
<h3>Товары на складе</h3>
<table>
    <tr>
        <th>ID товара</th>
        <th>Наименование товара</th>
        <th>Цвет</th>
        <th>Размер</th>
        <th>Материал</th>
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
            <td>${balance.product.name}</td>
            <td>${balance.product.color}</td>
            <td>${balance.product.size}</td>
            <td>${balance.product.material}</td>
            <td>${balance.number}</td>
            <td>${balance.totalPrice}</td>
            <td>${balance.purchasePrice}</td>
            <td>${balance.sellingPrice}</td>
            <td>${balance.margin}</td>
            <td>
                <form method="post" action="/balances/${balance.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
                <a href="/balances/${balance.id}">Перейти</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>