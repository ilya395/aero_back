<!doctype html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Пользователи</title>
    <style type="text/css">
        TABLE {
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
        }
        TD, TH {
            border: 1px solid black; /* Параметры рамки */
        }
        TH {
            background: #57d03c; /* Цвет фона */
        }
    </style>
</head>
<body>
</form>
<form method="get" action="/admin">
    <input type="submit" value="Страница администратора">
</form>
<form method="get" action="/lk">
    <input type="submit" value="Личный кабинет">
</form>
<form method="get" action="/index">
    <input type="submit" value="К товарам">
</form>
<h2>Пользователи</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Email</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Роль</th>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.email}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.role}</td>
            <td>
                <form method="post" action="/admin/users/${user.id}/makeadmin">
                    <input type="submit" value="Сделать админом">
                </form>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>
