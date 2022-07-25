<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Вход</title>
</head>
<body>
<h2>Введите логин и пароль</h2>
<form method="post" action="/signIn">
    <label> Логин:
        <input type="email" name="login" placeholder="Ваш e-mail">
    </label>
    <label> Пароль:
        <input type="password" name="password" placeholder="Ваш пароль">
    </label>
        <input type="submit" value="Войти">
</form>
</body>
</html>