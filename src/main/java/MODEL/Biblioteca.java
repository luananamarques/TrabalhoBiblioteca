/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Desenvolvimento
 */
public class Biblioteca extends Cliente{
    public String id;
    public String diasEmprestado;
    public Livros livros;
    public Cliente cliente;
    public String limiteEmprestimo = "28";
    public String diasEmprestar = "14";

    public String getDiasEmprestado() {
        return diasEmprestado;
    }

    public void setDiasEmprestado(String diasEmprestado) {
        this.diasEmprestado = diasEmprestado;
    }

 

    public Livros getLivros() {
        return livros;
    }

    public void setLivros(Livros livros) {
        this.livros = livros;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    public void setLimiteEmprestimo(String limiteEmprestimo) {
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public String getDiasEmprestar() {
        return diasEmprestar;
    }

    public void setDiasEmprestar(String diasEmprestar) {
        this.diasEmprestar = diasEmprestar;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroIdentificacaoCliente() {
        return numeroIdentificacaoCliente;
    }

    public void setNumeroIdentificacaoCliente(String numeroIdentificacaoCliente) {
        this.numeroIdentificacaoCliente = numeroIdentificacaoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



   
}
