<%-- 
    Document   : index
    Created on : 10 sep 2023, 17:43:07
    Author     : Kevin
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.model.Tarea"%>
<%
    
    
    if (session.getAttribute("lista_tarea") == null) {
        ArrayList<Tarea> lista_auxiliar = new ArrayList<Tarea>();
        
        Tarea t1 = new Tarea(1,"Reunion de estudiantes dela la carrera de sistemas",true);
        Tarea t2 = new Tarea(2,"Resolución de ejerccios de sistemas informaticos",true);
        Tarea t3 = new Tarea(3,"Defensa de exposiscion",false);
        
        lista_auxiliar.add(t1);
        lista_auxiliar.add(t2);
        lista_auxiliar.add(t3);
        
        session.setAttribute("lista_tarea", lista_auxiliar);

    }
    ArrayList<Tarea> lista_completa = (ArrayList<Tarea>) session.getAttribute("lista_tarea");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Tareas</title>

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
                background-color: green;
            }

            .container {
                text-align: center;


            }
        </style>
        
    </head>
    <body>

        <div class="container">
            <h2>GESTOR DE TAREAS</h2>
            <h2>Nombre : GRISEL LAZARO PARISACA</h2>
            <a href="Servlet?opcion=nuevo"><button>NUEVA TAREA</button></a>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tarea</th>
                        <th>Completado</th>
                        <th>Opciones</th>

                    </tr>
                </thead>

                <tbody>
                    <%
                        if (lista_completa != null) {
                            for (Tarea item : lista_completa) {
                    %>
                    <tr>
                        <td><%=item.getId()%></td>
                        <td><%=item.getTarea()%></td>
                        <td><input type="checkbox" name="check" <% if(item.isCheck() == true ){%>  value="true" checked <%} else { %> value="false"  <%}%> >  </td>           
                        
                        <td>
                            <a href="Servlet?opcion=editar&id=<%= item.getId()%>&check=<%= item.isCheck()%>"><button>EDITAR</button></a>
                            <a href="Servlet?opcion=eliminar&id=<%= item.getId()%>" onclick="return(confirm('ESTA SEGURO DE ELIMINAR LA TAREA ?'))"><button>ELIMINAR</button></a>
                        </td>

                    </tr>
                    <%
                            }
                        }
                    %>



                </tbody>
            </table>
        </div>
    </body>
</html>
