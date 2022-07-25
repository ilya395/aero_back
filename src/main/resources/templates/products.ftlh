<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Товары, услуги</title>
</head>
<body>
<h1>Добавление товара, услуги</h1>
<form method="post" action="/products/add">
    <label>Наименование:
        <input name="name" placeholder="Наименование">
    </label>
    <label>Материал:
        <input name="material" placeholder="Материал">
    </label>
    <label>Размер, см:
        <input name="size" placeholder="Размер, см">
    </label>
    <label>Цвет:
        <input name="color" placeholder="Цвет">
    </label>
    <input type="submit" value="Добавить">
</form>
<h1>Товары, услуги</h1>
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
    <#list products as product>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.material}</td>
            <td>${product.size}</td>
            <td>${product.color}</td>
            <td>${product.purchasePrice}</td>
            <td>${product.sellingPrice}</td>
            <td>${product.margin}</td>
            <td>${product.totalNumber}</td>
            <td>${product.leftovers}</td>
            <td>${product.booked}</td>
            <td>
                <form method="post" action="/products/${product.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
                <a href="/products/${product.id}">Перейти</a>
                <a href="/products/${product.id}/balances">Добавить поставку</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>