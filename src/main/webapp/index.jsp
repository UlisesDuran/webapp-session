<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HTTP Sessions</title>
    <style>
        a{
            color: ${cookie.color.getValue() == null? "black": cookie.color.getValue()};
        }
        h3{
            color: ${cookie.color.getValue() == null? "black": cookie.color.getValue()};
        }
    </style>
</head>
<body>
<h3>Cabeceras HTTP!</h3>
<ul>
    <li><a href="/webapp-session//productos.html">Mostrar productos</a></li>
    <li><a href="/webapp-session/login.html">Login</a></li>
    <li><a href="/webapp-session/logout">Cerrar sesión</a></li>
</ul>

<form action="/webapp-session/cambiar-color" method="get">
    <div>
        <label for="color">Cambiar color de los links</label>
        <div>
            <select name="color" id="color">
                <option value="blue">Azul</option>
                <option value="red">Rojo</option>
                <option value="green">Verde</option>
                <option value="aqua">Aqua</option>
                <option value="BlueViolet">Violeta</option>
                <option value="Gray">Gris</option>
                <option value="Cyan">Cyan</option>
            </select>
        </div>
    </div>
    <div>
        <input type="submit" value="Cambiar">
    </div>
</form>

</body>
</html>
