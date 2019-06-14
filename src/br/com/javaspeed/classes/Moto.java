package br.com.javaspeed.classes;

public class Moto {
    public String tipo, modelo, imagem;
    public int ano, cilindros;
    public float cilindrada, capCombustivel, precoDia;
    public Cliente proprietario;
    private int tempoAluguel;
    
    public Moto(String tipo, String modelo, int ano, int cilindros, float cilindrada, float capCombustivel, float precoDia, String imagem, Cliente proprietario, int tempoAluguel){
        this.tipo = tipo;
        this.modelo = modelo;
        this.ano = ano;
        this.cilindros = cilindros;
        this.cilindrada = cilindrada;
        this.capCombustivel = capCombustivel;
        this.precoDia = precoDia;
        this.imagem = imagem;
        this.proprietario = proprietario;
        this.tempoAluguel = tempoAluguel;
    }
    
        
    public void alterarAluguel(){
        this.tempoAluguel = 0;
    }
    
    public void alterarAluguel(int tempo){
        this.tempoAluguel = tempo;
    }
    
    public int getAluguel(){
        return this.tempoAluguel;
    }
    
}
