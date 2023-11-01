<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
             body {
                font-family: Century Gothic;
                line-height: 1.5;
            }
        </style>
    </head>
    <body>
        <h1>Nuevo registro</h1>
        <form action="Inicio" method="post">
            <input type="hidden" name="id" value="${producto.id}"/>
            <table>
                <tr>
                    <td>Descripcion</td>
                    <td><input type="text" name="descripcion" value="${producto.descripcion}" /></td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="number" step="0.01"  name="cantidad" value="${producto.cantidad}" /></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="text" name="precio" value="${producto.precio}" /></td>
                </tr>
                <tr>
                    <td>Categoria</td>
                    <td><input type="text" name="categoria" value="${producto.categoria}" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" /></td>
                </tr>
            </table>

        </form>
    </body>
</html>
