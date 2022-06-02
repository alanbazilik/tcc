/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTR;

import Dao.UsuarioDAO;
import Model.UsuarioMODEL;
import View.Tela_principal;
import java.math.BigInteger;

/**
 *
 * @author Codinhoto
 */
public class UsuarioCTR {
    
    public void cadastrarUsuarioCTR(String usuario, String senha)
    {
        BigInteger senhacrip;
        
        UsuarioMODEL usuM = new UsuarioMODEL();
        usuM.setNome_usuario(usuario);
        senhacrip = usuM.CriptografarSenha(senha);
        usuM.setSenha_usuario(senhacrip.toString());
       
        
        UsuarioDAO usuD = new UsuarioDAO();
        usuD.cadastrarUsuario(usuM);
    }
    public boolean loginUsuarioCTR(String login_usuario,String senha){
    BigInteger senhacripto;
         UsuarioMODEL usuM = new UsuarioMODEL();
        usuM.setNome_usuario(login_usuario);
        senhacripto = usuM.CriptografarSenha(senha);
        usuM.setSenha_usuario(senhacripto.toString());
        UsuarioDAO usuD = new UsuarioDAO();
        return usuD.loginUsuario(usuM);
      
            
        
    }
    
}
