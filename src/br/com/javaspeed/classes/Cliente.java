package br.com.javaspeed.classes;

public class Cliente extends Pessoa {

    public String dataCadastro, liga, patrocinador, motoPrefencial;

    public Cliente(String nome, String cpf, String endereco, String telefone, String dataCadastro, String liga, String patrocinador, String motoPreferencial) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
        this.liga = liga;
        this.patrocinador = patrocinador;
        this.motoPrefencial = motoPreferencial;
    }

    public Cliente(String nome, String cpf, String endereco, String telefone, String dataCadastro, String motoPreferencial) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
        this.motoPrefencial = motoPreferencial;
    }
    
        public void dados(){
        System.out.println("Nome: " + nome);
        System.out.println("Cpf: " + cpf);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
        System.out.println("Data de Contração: " + dataCadastro);
        System.out.println("Liga: " + liga);
        System.out.println("Patrocinador: " + patrocinador);
        System.out.println("Moto Prefencial: " + motoPrefencial);
    }
}