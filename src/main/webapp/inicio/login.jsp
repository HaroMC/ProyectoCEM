<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Ingreso al sistema </title>
    </head>
    <body>
        <h1> Gestión de programas de intercambio </h1>
        <br />
        <form action="Autenticar" method="post">
            <table>
                <tr>
                    <td> Nombre de usuario </td>
                    <td> <input type="text" name="nombreUsuario" required="true" /> </td>
                </tr>
                <tr>
                    <td> Contraseña </td>
                    <td> <input type="password" name="contrasena" required="true" /> </td>
                </tr>
                <tr>
                    <td colspan="2"> <input type="submit" value="Ingresar" /> </td>
                </tr>
            </table>
        </form>
    </body>
</html>
