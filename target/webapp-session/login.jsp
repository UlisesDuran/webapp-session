<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario Login</title>
</head>
<body>
<h3><p>Hola <%=session.getAttribute("nombre") != null? session.getAttribute("nombre"): "anónimo"%>, bienvenido de vuelta</p></h3>
<h1>Iniciar sesión</h1>
<form action="/webapp-session/login" method="post">
    <div>
        <label for="username">Username</label>
        <div>
            <input type="text" name="username" id="username">
        </div>
    </div>
    <div>
        <label for="password">Password</label>
        <div>
            <input type="password" name="password" id="password">
        </div>
    </div>
    <div>
        <div>
            <input type="submit" value="Enviar">
        </div>
    </div>
    <div>
        <p><a href=index.jsp>Volver</a></p>
    </div>

</form>
</body>
</html>