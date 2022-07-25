<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Клиенты</title>
</head>
<body>
<h2>Добавление нового клиента</h2>
<form method="post" action="/clients/add">
    <label>
        <input name="name" placeholder="Имя клиента">
    </label>
    <label>
        <input name="phone" placeholder="Телефон">
    </label>
    <label>
        <input name="address" placeholder="Адрес">
    </label>
    <label>
        <input name="email" placeholder="e-mail">
    </label>
    <p>
        <label for="status">Выберите статус клиента:</label>
        <select id="status" name="status">
            <option value="active">Ативный</option>
            <option value="passive">Неактивный</option>
            <option value="archive">В архиве</option>
        </select>
    </p>
    <input type="submit" value="Добавить">
</form>
<table>
    <tr>
        <th>ID клиента</th>
        <th>Имя</th>
        <th>Телефон</th>
        <th>Адрес</th>
        <th>E-mail</th>
        <th>Статус</th>
        <th>Действия</th>
    </tr>
    <#list clients as client>
        <tr>
            <td>${client.id}</td>
            <td>${client.name}</td>
            <td>${client.phone}</td>
            <td>${client.address}</td>
            <td>${client.email}</td>
            <td>${client.status}</td>
            <td>
                <form method="post" action="/clients/${client.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
                <a href="/clients/${client.id}">Перейти</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>