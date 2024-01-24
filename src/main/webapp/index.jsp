<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HTTP Sessions</title>
    <style>
        a, h3, h4{
            color: ${cookie.color.getValue() == null? "black": cookie.color.getValue()};
        }
    </style>
</head>
<body>
<h3>HTTP Sessions</h3>
<h4><p>Hola <%=session.getAttribute("nombre") != null? session.getAttribute("nombre"): "anónimo"%>, bienvenido a la session.</p></h4>
<ul>
    <li><a href="${pageContext.request.contextPath}/productos.html">Mostrar productos</a></li>
    <li><a href="${pageContext.request.contextPath}/login.html">Login</a></li>
    <li><a href="${pageContext.request.contextPath}/logout">Cerrar sesión</a></li>
</ul>

<div>
    <form action="${pageContext.request.contextPath}/guardar-nombre" method="post">
        <div>
            <label for="nombre">Ingresa tu nombre</label>
            <div>
                <input type="text" id="nombre" name="nombre">
            </div>
            <div>
                <input type="submit" value="Enviar">
            </div>
        </div>
    </form>
</div>
<br>
<div>
    <form action="${pageContext.request.contextPath}/cambiar-color" method="get">
        <div>
            <label for="color">Cambiar color el texto</label>
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
</div>
</body>
</html>
