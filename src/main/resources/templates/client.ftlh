<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Данные киента</title>
</head>
<body>
<h1>Информация о клиенте</h1>
<h4>ID: ${client.id}</h4>
<h4>${client.name}</h4>
<h4>Телефон: ${client.phone}</h4>
<h4>E-mail: ${client.email}</h4>
<h4>Адрес: ${client.address}</h4>
<h4>Статус клиента: ${client.status}</h4>
<h4>Редоктирование информации о клиенте</h4>
<form method="post" action="/clients/${client.id}/update">
    <label>
        <input name="name" placeholder="Имя" value="${client.name}">
    </label>
    <label>
        <input name="phone" placeholder="Телефон" value="${client.phone}">
    </label>
    <label>
        <input name="email" placeholder="e-mail" value="${client.email}">
    </label>
    <label>
        <input name="address" placeholder="Адрес" value="${client.address}">
    </label>
    <p>
        <label for="status">Выберите статус клиента:</label>
        <select id="status" name="status">
            <option value="active">Ативный</option>
            <option value="passive">Неактивный</option>
            <option value="archive">В архиве</option>
        </select>
    </p>
    <input type="submit" value="Сохранить изменения">
</form>
</body>
</html>