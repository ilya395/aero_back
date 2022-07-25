<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Товар, услуга</title>
</head>
<body>
<h2>Информация о товаре</h2>
<h4>ID: ${product.id}</h4>
<h4>Наименование: ${product.name}</h4>
<h4>Материал: ${product.material}</h4>
<h4>Размер: ${product.size} см</h4>
<h4>Цвет: ${product.color}</h4>
<h4>Закупочная цена: ${product.purchasePrice} руб.</h4>
<h4>Остатки на складе: ${product.leftovers} штук</h4>
<h2>Редактирование товара</h2>
<form method="post" action="/products/${product.id}/update">
    <label>ID:
        <input type=text name="id" value=${product.id}>
    </label>
    <label>Наименование:
        <input type=text name="name" value=${product.name}>
    </label>
    <label>Материал:
        <input type=text name="material" value=${product.material}>
    </label>
    <label>Размер:
        <input type=text name="size" value=${product.size}>
    </label>
    <label>Цвет:
        <input type=text name="color" value=${product.color}>
    </label>
    <input type="submit" value="Редактировать">
</form>
<form method="post" action="/products/${product.id}/delete">
    <input type="submit" value="Удалить">
</form>
<h2>Добавить партию</h2>
<form method="post" action="/products/${product.id}/addBalance">
    <label>Количество, шт.:
        <input name="number" placeholder="Например, 15"> шт.
    </label>
    <label>Стоимость поставки указанного кол-ва товаров, руб.:
        <input name="totalPrice" placeholder="Например, 6599.05"> руб.
    </label>
    <label>Наценка, % от закупочной цены:
        <input name="margin" placeholder="Например, 90"> %
    </label>
    <input type="submit" value="Добавить">
</form>
<table>
    <tr>
        <th>Номер поставки (ID)</th>
        <th>Количество при закупке, шт.</th>
        <th>Стоимость поставки</th>
        <th>Наценка</th>
        <th>Цена продажи</th>
        <th>Закупочная цена</th>
    </tr>
    <#list product.balances as balance>
        <td>${balance.id}</td>
        <td>${balance.number}</td>
        <td>${balance.totalPrice}</td>
        <td>${balance.margin}</td>
        <td>${balance.sellingPrice}</td>
        <td>${balance.purchasePrice}</td>
    </#list>
</table>
</body>
</html>