<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Producto"%>
<%
    List<Producto> productos = (List<Producto>)request.getAttribute("productos");
%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>

            body {
                font-family: Book Antiqua;
                line-height: 1.5;
            }
            #datos {
                width: 600px;
                margin: 50px auto;
                padding: 20px;

            }
            #datos1 {
                width: 400px;
                margin: 50px auto;
                border: 1px solid black;
                padding: 20px;
                line-height: 1;


            }
            #enviar {
                text-align: center;
                margin-top: 10px;
            }

            table {
                border-collapse: collapse;
                margin-bottom: 20px;
            }
            table td:first-child {
                text-align: right;
                padding-right: 10px;
            }
            .new-product {
                margin-bottom: 20px;
                padding-right: 300px;
            }
        </style>
    </head>
         <div id="datos1">
          
                
        </div>
        <center>
        <h1>Libros</h1>
        </center>
        
        <center>
        <div>
            
            <div class="new-product">
                <a href="Inicio?action=add">Nuevo producto</a>
            </div>

        
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th>Categoria</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
            
            <c:forEach var="item" items="${productos}">
            
            <tr>
                <td>${item.id}</td>
                <td>${item.descripcion}</td>
                <td>${item.cantidad}</td>
                <td>${item.precio}</td>
                <td>${item.categoria}</td>
                <td><a href="Inicio?action=edit&id=${item.id}">Editar</a></td>
                <td><a href="Inicio?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro de eliminar ???'))">Eliminar</a></td>
            </tr>
            </c:forEach>
        </table>
        </div>
    </center>
</html>
