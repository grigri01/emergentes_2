package com.emergentes.dao;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.emergentes.modelo.Producto;

public class ProductosDAOimpl extends ConexionDB implements ProductosDAO {

    @Override
    public void insert(Producto producto) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO libros ( titulo, autor, categoria,disponible) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = this.con.prepareStatement(sql);
            
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, producto.getCantidad());        
            ps.setFloat(3, producto.getPrecio());
            ps.setString(4, producto.getCategoria());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Producto producto) throws Exception {

        try {
            this.conectar();
            String sql = "UPDATE productos SET descripción = ?, cantidad = ?, precio = ?, categorias = ? WHERE id = ?";

            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, producto.getCantidad());
            ps.setFloat(3, producto.getPrecio());

            ps.setString(4, producto.getCategoria());
            ps.setInt(5, producto.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM productos WHERE id = ?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
    @Override
    public Producto getById(int id) throws Exception {
        Producto pro = new Producto();
        try {
            this.conectar();
            String sql = "SELECT * FROM productos WHERE id = ?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pro.setId(rs.getInt("id"));
                pro.setDescripcion(rs.getString("descripción"));
                pro.setCantidad(rs.getInt("cantidad"));
                pro.setPrecio(rs.getFloat("precio"));
                pro.setCategoria(rs.getString("categorias"));

            }

        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return pro;
    }

    @Override
    public List<Producto> getAll() throws Exception {
        ArrayList<Producto> lista = new ArrayList<Producto>();
        try {

            this.conectar();
            String sql = "SELECT * FROM productos";
            PreparedStatement ps = this.con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto pro = new Producto();

                pro.setId(rs.getInt("id"));
                pro.setDescripcion(rs.getString("descripción"));
                pro.setCantidad(rs.getInt("cantidad"));
                pro.setPrecio(rs.getFloat("precio"));
                pro.setCategoria(rs.getString("categorias"));



                lista.add(pro);

            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
}


       




