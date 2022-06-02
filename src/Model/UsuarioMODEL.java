/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Codinhoto
 */
public class UsuarioMODEL {
    
    private int id_usuario;
    private String nome_usuario;
    private String senha_usuario;

    public BigInteger CriptografarSenha(String senha)
    {
        MessageDigest md5;
        BigInteger senhacripto = null;
        
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(senha.getBytes(), 0, senha.length());
            senhacripto = new BigInteger(1, md5.digest());
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioMODEL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return senhacripto;
    }
    
    
    
    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the nome_usuario
     */
    public String getNome_usuario() {
        return nome_usuario;
    }

    /**
     * @param nome_usuario the nome_usuario to set
     */
    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    /**
     * @return the senha_usuario
     */
    public String getSenha_usuario() {
        return senha_usuario;
    }

    /**
     * @param senha_usuario the senha_usuario to set
     */
    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }
    
    
}
