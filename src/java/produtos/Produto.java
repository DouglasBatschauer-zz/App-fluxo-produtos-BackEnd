
package produtos;

/**
 *
 * @author user
 */
public class Produto {
    private int idProduto;
    private String nmProduto;
    private String descricaoProduto;
    private String nmResponsSolicitacao;
    private float precoProduto;
    private String dsStatus;
    private String dsSetor;
    private String dsObsReprov;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDsSetor() {
        return dsSetor;
    }

    public void setDsSetor(String dsSetor) {
        this.dsSetor = dsSetor;
    }

    public String getDsObsReprov() {
        return dsObsReprov;
    }

    public void setDsObsReprov(String dsObsReprov) {
        this.dsObsReprov = dsObsReprov;
    }

    public String getNmProduto() {
        return nmProduto;
    }

    public void setNmProduto(String nmProduto) {
        this.nmProduto = nmProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getNmResponsSolicitacao() {
        return nmResponsSolicitacao;
    }

    public void setNmResponsSolicitacao(String nmResponsSolicitacao) {
        this.nmResponsSolicitacao = nmResponsSolicitacao;
    }

    public float getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(float precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getDsStatus() {
        return dsStatus;
    }

    public void setDsStatus(String dsStatus) {
        this.dsStatus = dsStatus;
    }
    
}
