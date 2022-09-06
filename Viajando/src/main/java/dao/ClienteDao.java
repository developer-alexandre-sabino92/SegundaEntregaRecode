/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClienteDao {

    public void save(Cliente client) {

        String sql = "INSERT INTO cliente(nome) VALUES(?)";

        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/viajando","root","jworg1914");

            pst = con.prepareStatement(sql);

            pst.setString(1, client.getNome());

            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    }
    
    public List<Cliente> getCliente(){
        String sql = "SELECT * FROM Cliente";
        
        List <Cliente> cliente = new ArrayList <Cliente>();
        
        Connection con = null;
        PreparedStatement pst = null;
        
        ResultSet rset = null;
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/viajando","root","jworg1914");
            
            pst = con.prepareStatement(sql);
            
            rset = pst.executeQuery();
            
            while (rset.next()) {
                Cliente client = new Cliente();
                client.setID_Cliente(rset.getInt("id_cliente"));
                client.setNome(rset.getString("nome"));
                cliente.add(client);
            }
            
        }catch (Exception e){
            
            e.printStackTrace();
            
        }finally {
            try {
                if(rset != null){
                    rset.close();
                }
                if (pst != null){
                    pst.close();
                }
                if (con != null){
                    con.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return cliente;
    }
    
    public void update (Cliente client) {
        String sql = "UPDATE Cliente SET nome = ? WHERE id_cliente = ? ";
        Connection con = null;
        PreparedStatement pst = null;
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/viajando","root","jworg1914");
            pst = con.prepareStatement(sql);
            pst.setString(1, client.getNome());
            pst.setInt(2, client.getID_Cliente());
            pst.execute();
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        } finally {
            try {
               
                if (pst != null){
                    pst.close();
                }
                if (con != null){
                    con.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void deleteById(int id){
        String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
        
        Connection con = null;
        PreparedStatement pst = null;
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/viajando","root","jworg1914");
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            pst.execute();
            
         
            
        } catch(Exception e) {
            
            e.printStackTrace();
            
            
        } finally {
            try {
               
                if (pst != null){
                    pst.close();
                }
                if (con != null){
                    con.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    

}
