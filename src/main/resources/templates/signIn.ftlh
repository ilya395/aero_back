<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h3>Вход</h3>
<form method="post" action="/signIn">
    <label>email
        <input type=email name="email" placeholder="Введите email...">
    </label>
    <label>Пароль
        <input type=password name="password" placeholder="Введите пароль...">
    </label>
    <input type="submit" value="Вход">
</form>
<div style="position: absolute; right: 0; top: 0">
    <form method="get" action="/signUp">
        <input type="submit" value="Зарегистрироваться">
    </form>
</div>

</body>
</html>
