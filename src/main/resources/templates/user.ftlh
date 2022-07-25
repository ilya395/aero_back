<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Данные сотрудника</title>
</head>
<body>
<h1>Информация о сотруднике</h1>
<h4>ID: ${user.id}</h4>
<h4>${user.name}</h4>
<h4>Должность: ${user.role}</h4>
<h4>Телефон: ${user.phone}</h4>
<h4>E-mail: ${user.email}</h4>
<h2>Редактирование информации о сотруднике</h2>
<form method="post" action="/users/${user.id}/update">
    <label>
        <input name="name" placeholder="Имя" value="${user.name}">
    </label>
    <label>
        <input name="phone" placeholder="Телефон" value="${user.phone}">
    </label>
    <label>
        <input name="email" placeholder="e-mail" value="${user.email}">
    </label>
    <p>
        <label for="role">Выберите роль:</label>
        <select id="role" name="role">
            <option value="ADMIN">Администратор</option>
            <option value="MANAGER">Менеджер</option>
            <option value="OWNER">Владелец</option>
        </select>
    </p>
    <input type="submit" value="Сохранить изменения">
</form>
</body>
</html>