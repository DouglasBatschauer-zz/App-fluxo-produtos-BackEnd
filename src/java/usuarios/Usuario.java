/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

/**
 *
 * @author user
 */
public class Usuario {
    private int idUser;
    private String nmUsuario;
    private String userSenha;
    private String userCpf;
    private String dsUserSetor;
    private String ieLogado;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getIeLogado() {
        return ieLogado;
    }

    public void setIeLogado(String ieLogado) {
        this.ieLogado = ieLogado;
    }
    

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getUserSenha() {
        return userSenha;
    }

    public void setUserSenha(String userSenha) {
        this.userSenha = userSenha;
    }

    public String getUserCpf() {
        return userCpf;
    }

    public void setUserCpf(String userCpf) {
        this.userCpf = userCpf;
    }

    public String getDsUserSetor() {
        return dsUserSetor;
    }

    public void setDsUserSetor(String dsUserSetor) {
        this.dsUserSetor = dsUserSetor;
    }
    
}
