/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.dao;

import com.emergentes.modelo.Categoria;
import com.emergentes.modelo.Producto;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CategoriaDAOimpl extends ConexionDB implements CategoriaDAO {

    @Override
    public void insert(Categoria categoria) throws Exception {
           try {
            this.conectar();
            String sql = "INSERT INTO categorias ( categoria) VALUES (?)";
            PreparedStatement ps = this.con.prepareStatement(sql);
            
            ps.setString(1, categoria.getCategoria());
           
            
            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Categoria categoria) throws Exception {
      try {
            this.conectar();
            String sql = "UPDATE categorias SET categorias = ? WHERE id = ?";

            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, categoria.getCategoria());
          
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
            String sql = "DELETE FROM categorias WHERE id = ?";
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
    public Categoria getById(int id) throws Exception {
        Categoria pro = new Categoria();
        try {
            this.conectar();
            String sql = "SELECT * FROM categorias WHERE id = ?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pro.setId(rs.getInt("id"));
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
    public List<Categoria> getAll() throws Exception {
       ArrayList<Categoria> lista = new ArrayList<Categoria>();
        try {

            this.conectar();
            String sql = "SELECT * FROM categorias";
            PreparedStatement ps = this.con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categoria pro = new Categoria();

                pro.setId(rs.getInt("id"));
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
