package br.com.javaspeed.classes;

public class Moto {
    public String tipo, modelo, imagem;
    public int ano, cilindros;
    public float cilindrada, capCombustivel, precoDia;
    public Cliente proprietario;
    
    public Moto(String tipo, String modelo, int ano, int cilindros, float cilindrada, float capCombustivel, float precoDia, String imagem, Cliente proprietario){
        this.tipo = tipo;
        this.modelo = modelo;
        this.ano = ano;
        this.cilindros = cilindros;
        this.cilindrada = cilindrada;
        this.capCombustivel = capCombustivel;
        this.precoDia = precoDia;
        this.imagem = imagem;
        this.proprietario = proprietario;
    }
}
