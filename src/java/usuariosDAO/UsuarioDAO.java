package usuariosDAO;

import conexaoBanco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import usuarios.Usuario;

/**
 *
 * @author user
 */
public class UsuarioDAO {

    private Connection con = null;

    public UsuarioDAO() {
        this.con = Conexao.getConnection();
    }

    public boolean inserirUsuario(Usuario usuario) {
        boolean retorno = false;
        String sql = "INSERT INTO usuarios (nm_usuario, user_senha, user_setor, user_cpf)"
                + " VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, usuario.getNmUsuario());
            pst.setString(2,usuario.getUserSenha());
            pst.setString(3, usuario.getDsUserSetor());
            pst.setString(4, usuario.getUserCpf());
            if(pst.executeUpdate() > 0){
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con);
        }
        return retorno;
    }
    
    
    public boolean updateUsuario(Usuario usuario){
        boolean retorno = false;
        String sql = "UPDATE usuarios SET USER_LOGADO = ? WHERE ID_USUARIO = ?";
        try{
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, "S");
             pst.setString(2, String.valueOf(usuario.getIdUser()));
             if(pst.executeUpdate() > 0){
                 retorno = true;
             }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            Conexao.closeConnection(con);
        }
       return retorno;
    }   
    
   public ArrayList<Usuario> listUserLogado(){
        String sql = "SELECT * FROM usuarios WHERE USER_LOGADO = 'S'";
        ArrayList<Usuario> listUsuario = new ArrayList<>();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs =  pst.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setNmUsuario(rs.getString("nm_usuario"));
                usuario.setUserSenha(rs.getString("user_senha"));
                usuario.setUserCpf(rs.getString("user_cpf"));
                usuario.setIdUser(Integer.parseInt(rs.getString("id_usuario")));
                usuario.setDsUserSetor(rs.getString("user_setor"));
                listUsuario.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con);
        }
        return listUsuario;
    }
   
   public ArrayList<Usuario> listUsers(){
        String sql = "SELECT ID_USUARIO, NM_USUARIO, USER_SENHA,  USER_SETOR FROM usuarios";
        ArrayList<Usuario> listUsuario = new ArrayList<>();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs =  pst.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUser(Integer.parseInt(rs.getString("id_usuario")));
                usuario.setNmUsuario(rs.getString("nm_usuario"));
                usuario.setUserSenha(rs.getString("user_senha"));
                usuario.setDsUserSetor(rs.getString("user_setor"));
                listUsuario.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con);
        }
        return listUsuario;
    }
}
