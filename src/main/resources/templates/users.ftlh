<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Сотрудники</title>
</head>
<body>
<h2>Добавление нового сотрудника</h2>
<form method="post" action="/users/add">
    <label>
        <input name="name" placeholder="Имя">
    </label>
    <label>
        <input name="phone" placeholder="Телефон">
    </label>
    <label>
        <input name="email" placeholder="e-mail">
    </label>
    <p>
        <label for="role">Выберите роль:</label>
        <select id="role" name="role">
            <option value="ADMIN">Администратор</option>
            <option value="MANAGER">Менеджер</option>
            <option value="OWNER">Владелец</option>
        </select>
    </p>
    <input type="submit" value="Добавить">
</form>
<table>
    <tr>
        <th>ID сотрудника</th>
        <th>Имя</th>
        <th>Телефон</th>
        <th>E-mail</th>
        <th>Роль</th>
        <th>Действия</th>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.phone}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
            <td>
                <form method="post" action="/users/${user.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
                <a href="/users/${user.id}">Перейти</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>