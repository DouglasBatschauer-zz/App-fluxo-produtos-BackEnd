package produtosDAO;

import conexaoBanco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import produtos.Produto;

/**
 *
 * @author user
 */
public class ProdutosDAO {

    private Connection con = null;

    public ProdutosDAO() {
        this.con = Conexao.getConnection();
    }

    public boolean inserirProduto(Produto produto) {
        boolean retorno = false;
        String sql = "INSERT INTO produtos (nm_produto, ds_produto, preco_prod, nm_resp_solic, "
                + "ds_obs_reprov, ds_setor) VALUES (?, ?, ?, ?, ?,  ?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, produto.getNmProduto());
            pst.setString(2, produto.getDescricaoProduto());
            pst.setFloat(3, produto.getPrecoProduto());
            pst.setString(4, produto.getNmResponsSolicitacao());
            pst.setString(5, produto.getDsObsReprov());
            pst.setString(6, produto.getDsSetor());
            if(pst.executeUpdate() > 0){
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con);
        }
        return retorno;
    }
    public ArrayList<Produto> listarProdutos(){
        String sql = "SELECT * FROM PRODUTOS";
        ArrayList<Produto> listProduto = new ArrayList<>();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs =  pst.executeQuery();
            while(rs.next()){
                Produto produto = new Produto();
                produto.setIdProduto(Integer.parseInt(rs.getString("id_produto")));
                produto.setNmProduto(rs.getString("nm_produto"));
                produto.setDescricaoProduto(rs.getString("ds_produto"));
                produto.setPrecoProduto(verificaNuloAndParseFlaot(rs.getString("preco_prod")));
                produto.setDsStatus(rs.getString("ds_status"));
                produto.setNmResponsSolicitacao(rs.getString("nm_resp_solic"));
                produto.setDsObsReprov(rs.getString("ds_obs_reprov"));
                produto.setDsSetor(rs.getString("ds_setor"));
                listProduto.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con);
        }
        return listProduto;
    }
    
    public boolean updateProduto(Produto produto){
        boolean retorno = false;
        String sql = "UPDATE PRODUTOS SET DS_STATUS = ?, DS_OBS_REPROV = ? WHERE ID_PRODUTO = ?";
        try{
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, produto.getDsStatus());
             pst.setString(2, produto.getDsObsReprov());
             pst.setString(3, String.valueOf(produto.getIdProduto()));
             if(pst.executeUpdate() > 0){
                 retorno = true;
             }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            Conexao.closeConnection(con);
        }
       return retorno;
    }   
    
    public float verificaNuloAndParseFlaot(String precoProduto){
        return precoProduto == null || precoProduto.equals("") ? 0 : Float.parseFloat(precoProduto);
    }
    
}
