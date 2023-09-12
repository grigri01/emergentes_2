<%-- 
    Document   : editar
    Created on : 10 sep 2023, 18:18:02
    Author     : ALEX
--%>

<%@page import="com.emergentes.model.Tarea"%>
<%
    Tarea registro = (Tarea) request.getAttribute("objeto_tarea");

    String check1 = null;

    if ((check1 = request.getParameter("check")) != null) {
        check1 = request.getParameter("check");
        if (check1.equals("true")) {
            
            registro.setCheck(true);

        } else {
            registro.setCheck(false);

        }

    }


%>
<!DOCTYPE html>
<html>
    <head>
        <title>REGISTRO Y EDICION</title>
        <style>
            table {
                width: 80%;
                margin: 20px auto;
                border-collapse: collapse;
            }

            th, td {
                border: 1px solid #ccc;
                padding: 8px;
            }

            th {
                background-color: greenyellow;
            }

            .container {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>REGISTRO DE TAREAS</h2>
            <form action="Servlet" method="post">
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Tarea</th>
                        <th>Completado</th>
                    </tr>
                    <tr>
                        <td><input type="number" name="id" value="<%= registro.getId()%>" readonly></td>
                        <td><input type="text" name="tarea" value="<%= registro.getTarea()%>"></td>
                        <td><input type="checkbox" name="completado" <% if (registro.getId() == 0){ %> value="false" disabled <%} else {%> value="true" checked <% }%> > </td>
                    </tr>
                </table>
                <input type="submit" value="Registrar">
            </form>
        </div>
    </body>
</html>














