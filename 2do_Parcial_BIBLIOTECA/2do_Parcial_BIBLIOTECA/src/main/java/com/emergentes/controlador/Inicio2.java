
package com.emergentes.controlador;
import com.emergentes.dao.CategoriaDAO;
import com.emergentes.dao.CategoriaDAOimpl;
import com.emergentes.dao.ProductosDAO;
import com.emergentes.dao.ProductosDAOimpl;
import com.emergentes.modelo.Categoria;
import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio2", urlPatterns = {"/Inicio2"})
public class Inicio2 extends HttpServlet {
 
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id;
            Categoria avi = new Categoria();
            CategoriaDAO dao = new CategoriaDAOimpl();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("categoria", avi);
                    request.getRequestDispatcher("frmcategoria.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    avi = dao.getById(id);

                    request.setAttribute("categoria", avi);
                    request.getRequestDispatcher("frmcategoria.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Inicio");
                    break;
                case "view":
                    List<Categoria> lista = dao.getAll();
                    request.setAttribute("categoria", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("ERROR:" + ex.getMessage());
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 CategoriaDAO dao = new CategoriaDAOimpl();

        int id = Integer.parseInt(request.getParameter("id"));
        String categoria = request.getParameter("categoria");

        Categoria pro = new Categoria();
        pro.setId(id);
     
        pro.setCategoria(categoria);
        
      
        try {
            if (id == 0) {

                dao.insert(pro);

            } else {
                dao.update(pro);
            }

        } catch (Exception ex) {
            System.out.println("ERROR al guardar datos...");
        }

        response.sendRedirect("Inicio2");
    }

   

}
