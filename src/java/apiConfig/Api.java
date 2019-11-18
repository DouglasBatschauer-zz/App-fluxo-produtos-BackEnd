/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiConfig;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import produtos.Produto;
import produtosDAO.ProdutosDAO;

/**
 * REST Web Service
 *
 * @author user
 */
@Path("api-produtos")
public class Api {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Api
     */
    public Api() {
    }

    /**
     * Retrieves representation of an instance of produtos.Api
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        String listaProdutos = "";
        Gson gson = new Gson();
        ProdutosDAO prodDao = new ProdutosDAO();
        ArrayList<Produto> produtos = prodDao.listarProdutos();
        listaProdutos = produtos.stream().map((produto) -> gson.toJson(produto)).reduce(listaProdutos, String::concat);
        //GSON nao traz o objeto em forma de vetor, essa alteracao foi necessária para nao ter problemas no recebimeno do api
        return "[" + listaProdutos.replace("}{", "},{") + "]";
    }

 
    /**
     * PUT method for updating or creating an instance of Api
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("adicionar-produto")
    public void adicionarProduto(String contetProduto) {
        Gson gson = new Gson();
        ProdutosDAO prodDao = new ProdutosDAO();
        Produto produto = (Produto) gson.fromJson(contetProduto, Produto.class);
        prodDao.inserirProduto(produto);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProduto(String contetProduto) {
        Gson gson = new Gson();
        ProdutosDAO prodDao = new ProdutosDAO();
        Produto produto = (Produto) gson.fromJson(contetProduto, Produto.class);
        prodDao.updateProduto(produto);
    }
}
