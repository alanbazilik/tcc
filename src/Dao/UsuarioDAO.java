/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.UsuarioMODEL;
import View.Tela_principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author Codinhoto
 */
public class UsuarioDAO {

    Connection con;
    PreparedStatement pgsql;
    Statement st;
 
    public void cadastrarUsuario(UsuarioMODEL gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
        con = cb.conectaPostgre();
        
        String sql = "insert into Usuario "
                + "(nome_user,senha_user) "
                + "values(?,?)";
        
        try {
            pgsql = con.prepareStatement(sql);
            pgsql.setString(1, gs.getNome_usuario());
            pgsql.setString(2, gs.getSenha_usuario());
            
            pgsql.executeUpdate();
            
            JOptionPane.showMessageDialog
                        (null, "Usuário Cadastrado!");
  
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
    }
    public boolean loginUsuario(UsuarioMODEL gs)
    {
        ConexaoDAO cb = new ConexaoDAO();
         con = cb.conectaPostgre();
         
        boolean status;
        ResultSet rs;
        String sql = "select * from Usuario"
                + " where nome_user = ?"
                + "and senha_user = ?";
        
        try {
            pgsql = con.prepareStatement(sql);
             pgsql.setString(1, gs.getNome_usuario());
               pgsql.setString(2, gs.getSenha_usuario());
            rs = pgsql.executeQuery();
            if(rs.next()){
  JOptionPane.showMessageDialog(null,"login correto","correto", JOptionPane.INFORMATION_MESSAGE);
    JOptionPane.showMessageDialog(null,"seja bem vindo: " + gs.getNome_usuario());
                
      Tela_principal objtel = new Tela_principal();
      objtel.setVisible(true);
      
  
      
               return status = true;
            }
            else{
  JOptionPane.showMessageDialog(null,"login incorreto","incorreto", JOptionPane.ERROR_MESSAGE);
  Tela_principal objtel = new Tela_principal();
      objtel.setVisible(false);
             return status = false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
               return status = false;
        }
      
           
         
    
}
         
}