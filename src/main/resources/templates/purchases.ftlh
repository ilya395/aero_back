<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Планировщик закупок</title>
</head>
<body>
<h3>В данном разделе находятся товары, которые необходимо закупить для выполнения заказов, а также товары, которые заканчиваются</h3>
<table>
    <tr>
        <th>ID товара</th>
        <th>Наименование</th>
        <th>Материал</th>
        <th>Размер, см</th>
        <th>Цвет</th>
        <th>Цена закупочная за 1 шт., руб.</th>
        <th>Цена продажи за 1 шт., руб.</th>
        <th>Наценка, % от закупочной цены</th>
        <th>Общее количество на складе, шт.</th>
        <th>Количество свободные для заказа, шт.</th>
        <th>Количество забронированных, шт.</th>
        <th>Действия</th>
    </tr>
<#--    todo purchases -->
    <#list products as purchase>
        <tr>
            <td>${purchase.id}</td>
            <td>${purchase.name}</td>
            <td>${purchase.material}</td>
            <td>${purchase.size}</td>
            <td>${purchase.color}</td>
            <td>${purchase.purchasePrice}</td>
            <td>${purchase.sellingPrice}</td>
            <td>${purchase.margin}</td>
            <td>${purchase.totalNumber}</td>
            <td>${purchase.leftovers}</td>
            <td>${purchase.booked}</td>
        </tr>
    </#list>
</table>
</body>
</html>