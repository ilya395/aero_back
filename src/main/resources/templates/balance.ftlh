<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Информация о поступлении товара</title>
</head>
<body>
<h2>Информация о поступлении</h2>
<h4>Поступление товара №${balances.id}</h4>
<h4>Наименование: ${balances.product.name}, ${balances.product.color}, ${balances.product.size}</h4>
<h4>Количество: ${balances.number} шт.</h4>
<h4>Закупочная цена за 1 шт.: ${balances.totalPrice} руб.</h4>
<h4>Наценка: ${balances.margin} %</h4>
<h4>Общая стоимость закупки: ${balances.purchasePrice} руб.</h4>
<h4>Стоимость: ${balances.sellingPrice} руб.</h4>
</body>
</html>