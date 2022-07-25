<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Меню администратора</title>
</head>
<body>
</form>
<form method="get" action="/lk">
    <input type="submit" value="Личный кабинет">
</form>
<form method="get" action="/index">
    <input type="submit" value="К товарам">
</form>
<h3>Выберите раздел</h3>
<form method="get" action="/admin/users">
    <input type="submit" value="Редактировать пользователей">
</form>
<form method="get" action="/admin/orders">
    <input type="submit" value="Редактировать заказы">
</form>
<form method="get" action="/admin/products">
    <input type="submit" value="Редактировать товары">
</form>
<form method="get" action="/admin/categories">
    <input type="submit" value="Редактировать категории">
</form>
</body>
