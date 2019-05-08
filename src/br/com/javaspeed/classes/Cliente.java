package br.com.javaspeed.classes;

public class Cliente extends Pessoa {

    public String dataCadastro, liga, patrocinador, motoPrefencial;
    private int tempoAluguel;

    public int getTempoAluguel() {
        return tempoAluguel;
    }

    public Cliente(String nome, String cpf, String endereco, String telefone, String dataCadastro, String liga, String patrocinador, String motoPreferencial, int tempoAluguel) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
        this.liga = liga;
        this.patrocinador = patrocinador;
        this.motoPrefencial = motoPreferencial;
        this.tempoAluguel = tempoAluguel;
    }

    public Cliente(String nome, String cpf, String endereco, String telefone, String dataCadastro, String motoPreferencial, int tempoAluguel) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
        this.motoPrefencial = motoPreferencial;
        this.tempoAluguel = tempoAluguel;
    }
    
    public void alterarAluguel(){
        this.tempoAluguel = 0;
    }
    
    public void alterarAluguel(int tempo){
        this.tempoAluguel = tempo;
    }
    
    
}
