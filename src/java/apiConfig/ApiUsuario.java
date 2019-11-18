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
import usuarios.Usuario;
import usuariosDAO.UsuarioDAO;

/**
 * REST Web Service
 *
 * @author user
 */
@Path("api-usuario")
public class ApiUsuario {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Api
     */
    public ApiUsuario() {
    }

    /**
     * Retrieves representation of an instance of produtos.Api
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        Gson gson = new Gson();
        String listUserLogado = "";
        UsuarioDAO userDao =  new UsuarioDAO();
        ArrayList<Usuario> usuarios = userDao.listUserLogado();
        listUserLogado = usuarios.stream().map((usuario) -> gson.toJson(usuario)).reduce(listUserLogado, String::concat);
        return "[" + listUserLogado.replace("}{", "},{") + "]";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("get-users")
    public String getUsuarios() {
        Gson gson = new Gson();
        String listUserLogado = "";
        UsuarioDAO userDao =  new UsuarioDAO();
        ArrayList<Usuario> usuarios = userDao.listUsers();
        listUserLogado = usuarios.stream().map((usuario) -> gson.toJson(usuario)).reduce(listUserLogado, String::concat);
        return "[" + listUserLogado.replace("}{", "},{") + "]";
    }
    /**
     * PUT method for updating or creating an instance of Api
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("adicionar-usuario")
    public void adicionarUsuario(String contentUsuario) {
        Gson gson = new Gson();
        UsuarioDAO userDao = new UsuarioDAO();
        Usuario usuario = (Usuario) gson.fromJson(contentUsuario, Usuario.class);
        userDao.inserirUsuario(usuario);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUsuario(String contentUsuario) {
        Gson gson = new Gson();
        UsuarioDAO userDao = new UsuarioDAO();
        Usuario usuario = (Usuario) gson.fromJson(contentUsuario, Usuario.class);
        userDao.updateUsuario(usuario);
    }
}
