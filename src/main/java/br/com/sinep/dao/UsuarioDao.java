package br.com.sinep.dao;
import java.sql.*;

import br.com.sinep.bean.Usuario;
  
public class UsuarioDao {
	
     public static boolean login(String usuario, String senha) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = BancoDeDados.getConnection();
            ps = con.prepareStatement(
                    "select usuario, senha from userinfo where usuario = ? and senha = ? ");
            ps.setString(1, usuario);
            ps.setString(2, senha);
  
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                System.out.println(rs.getString("usuario"));
                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            return false;
        } finally {
            BancoDeDados.close(con);
        }
    }
     
    public boolean cadastrar(Usuario u){
    	Connection con = null;
        PreparedStatement ps = null;
        try{
        	con = BancoDeDados.getConnection();
        	ps = con.prepareStatement("insert into userinfo (nome, senha) values (?, ?)");
        	ps.setString(1, u.getNome());
        	ps.setString(2, u.getSenha());
        	return ps.execute();
        }catch(Exception ex){
        	System.out.println("Erro ao cadastrar() -->" + ex.getMessage());
        	return false;
        } finally {
			BancoDeDados.close(con);
		}
    	
    	
    }
}