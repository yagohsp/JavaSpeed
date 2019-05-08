package br.com.javaspeed.classes;

public final class Funcionario extends Pessoa {

    public String dataContratacao;
    private String usuario, senha, perfil;

    public Funcionario(){
        
    }
    
    public Funcionario(String usuario, String senha, String nome, String cpf, String endereco, String telefone, String dataContratacao, String perfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataContratacao = dataContratacao;
        this.setUsuario(usuario);
        this.setSenha(senha);
        this.setPerfil(perfil);
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
   
}
