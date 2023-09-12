/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.model.Tarea;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ALEX
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcion = request.getParameter("opcion");

        Tarea objeto_tarea = new Tarea();

        HttpSession sesion = request.getSession();

        ArrayList<Tarea> lista_tarea;
        lista_tarea = (ArrayList<Tarea>) sesion.getAttribute("lista_tarea");

        int id, posicion;

        switch (opcion) {
            case "nuevo":

                request.setAttribute("objeto_tarea", objeto_tarea);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;

            case "editar":
                
                String check = request.getParameter("check");
                id = Integer.parseInt(request.getParameter("id"));
                posicion = buscarIndice(request, id);

                objeto_tarea = lista_tarea.get(posicion);
                request.setAttribute("objeto_tarea", objeto_tarea);
                request.getRequestDispatcher("editar.jsp?check="+check+"").forward(request, response);
                break;

            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                posicion = buscarIndice(request, id);
                if (posicion >= 0) {
                    lista_tarea.remove(posicion);
                }
                request.setAttribute("lista_tarea", lista_tarea);
                response.sendRedirect("index.jsp");
                break;
            default:

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        

        HttpSession sesion = request.getSession();
        ArrayList<Tarea> lista_tarea = (ArrayList<Tarea>) sesion.getAttribute("lista_tarea");

        Tarea objeto_tarea = new Tarea();
        objeto_tarea.setId(id);
        objeto_tarea.setTarea(request.getParameter("tarea"));

        objeto_tarea.setCheck(Boolean.parseBoolean(request.getParameter("completado")));
        
        if (id == 0) {

            objeto_tarea.setCheck(Boolean.parseBoolean(request.getParameter("completado")));
            int idNew = obtenerId(request);
            objeto_tarea.setId(idNew);
            lista_tarea.add(objeto_tarea);

        } else {

            objeto_tarea.setCheck(Boolean.parseBoolean(request.getParameter("completado")));
            int posicion = buscarIndice(request, id);
            
            lista_tarea.set(posicion, objeto_tarea);

        }

        request.setAttribute("lista_tarea", lista_tarea);
        response.sendRedirect("index.jsp");

    }

    public int buscarIndice(HttpServletRequest request, int id) {

        HttpSession sesion = request.getSession();
        ArrayList<Tarea> lista_tarea = (ArrayList<Tarea>) sesion.getAttribute("lista_tarea");

        int posicion = -1;

        if (lista_tarea != null) {
            for (Tarea elemento : lista_tarea) {
                ++posicion;
                if (elemento.getId() == id) {
                    break;
                }
            }
        }

        return posicion;
    }

    public int obtenerId(HttpServletRequest request) {
        HttpSession sesion = request.getSession();
        ArrayList<Tarea> lista_tarea = (ArrayList<Tarea>) sesion.getAttribute("lista_tarea");

        int idNew = 0;
        for (Tarea elemento : lista_tarea) {
            idNew = elemento.getId();

        }
        return idNew + 1;

    }
}
