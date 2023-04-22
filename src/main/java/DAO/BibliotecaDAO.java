/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.Biblioteca;
import MODEL.Cliente;
import MODEL.Livros;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Desenvolvimento
 */
public class BibliotecaDAO {
    File arquivoUsuario = new File("C:/Users/Desenvolvimento/Documents/dadosUsuarios.txt");
     File arquivoExemplares = new File("C:/Users/Desenvolvimento/Documents/dadosExemplares.txt");
     File arquivoEmprestimos = new File("C:/Users/Desenvolvimento/Documents/dadosEmprestimos.txt");
  
    private File exemplares_File;

    private List<Cliente> usuarios;
    private List<Livros> exemplares;
    
    private boolean jOptionA;
    
    
public void salvarLivro(Livros livros) throws Exception{
    try{
        if(!arquivoUsuario.exists()){
            arquivoUsuario.createNewFile();
        }
        
        FileWriter fw = new FileWriter(arquivoExemplares, true);
        
         fw.append(livros.numeroIdentificacao);
        fw.append("\n");
        fw.append(livros.titulo);
        fw.append("\n");
        fw.append(livros.autor);
        fw.append("\n");
        fw.append(livros.anoPublicacao);
        fw.append("\n");
        
      fw.flush();
      fw.close();
       JOptionPane.showMessageDialog(null, "O Livro: " + livros.getTitulo()+ " foi inserido com sucesso em seu BD");
            
    }
   catch(Exception e){
     JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro ao inserir o Livro: " + e);  
}
}

 List<Livros> listLivros = new ArrayList<>();
public List<Livros> lerArquivo()throws Exception{
    try {
       
       
        FileReader ler;
        BufferedReader bufferDados;
        String dados = "";
        String linha;
        ler = new FileReader("C:/Users/Desenvolvimento/Documents/dadosExemplares.txt");
        bufferDados = new BufferedReader(ler);
        while ((linha = bufferDados.readLine()) != null) {
        dados += linha;
        }
        
        
        Scanner scanner = new Scanner(new FileReader("C:/Users/Desenvolvimento/Documents/dadosExemplares.txt"));
	
	while(scanner.hasNext())
	{
                Livros livros = new Livros();
		String Id = scanner.nextLine();
                String Titulo = scanner.nextLine();
		String Autor = scanner.nextLine();
                String AnoPublicacao = scanner.nextLine();
	
                livros.setNumeroIdentificacao(Id);
                livros.setTitulo(Titulo);
		livros.setAutor(Autor);
                livros.setAnoPublicacao(AnoPublicacao);
               
                  listLivros.add(livros);
	}
       
        
        bufferDados.close();
        
        return listLivros;
   
        
    } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro ao ler o arquivo: " + e);
    }
   return  null;
}
     

public void salvarUsuario(Cliente cliente) throws Exception{
    try{
        if(!arquivoUsuario.exists()){
            arquivoUsuario.createNewFile();
        }
        
        FileWriter fw = new FileWriter(arquivoUsuario, true);
        
        fw.append(cliente.numeroIdentificacaoCliente);
        fw.append("\n");
        fw.append(cliente.nome);
        fw.append("\n");
        fw.append(cliente.telefone);
        fw.append("\n");
  
        
      fw.flush();
      fw.close();
      
      JOptionPane.showMessageDialog(null, "O Usúario: " + cliente.getNome()+ " foi inserido com sucesso em seu BD");
            
    }
   catch(Exception e){
        JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro ao inserir o Usúario: " + e);
}
}



public List<Cliente> lerUsuarios()throws Exception{
    try {
         List<Cliente> listCliente = new ArrayList<>();
         FileReader ler;
        BufferedReader bufferDados;
        String dados = "";
        String linha;
        ler = new FileReader("C:/Users/Desenvolvimento/Documents/dadosUsuarios.txt");
        bufferDados = new BufferedReader(ler);
        while ((linha = bufferDados.readLine()) != null) {
        dados += linha;
        }
        
        
        Scanner scanner = new Scanner(new FileReader("C:/Users/Desenvolvimento/Documents/dadosUsuarios.txt"));
	
	while(scanner.hasNext())
	{
                Cliente cliente = new Cliente();
                
                String id = scanner.nextLine();
		String nome = scanner.nextLine();
		String telefone = scanner.nextLine();
                
                cliente.setNumeroIdentificacaoCliente(id);
                cliente.setNome(nome);
		cliente.setTelefone(telefone);
                
                  listCliente.add(cliente);
	}
       
        JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro ao ler o arquivo: " + listCliente);
        bufferDados.close();
        
        return listCliente;
   
    } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro ao ler o arquivo: " + e);
    }
        return null;
}


public static Livros buscaExemplarPorNome(String nomeExemplar)throws Exception{
    try{
     FileReader ler;
        BufferedReader bufferDados;
        String dados = "";
        String linha;
        ler = new FileReader("C:/Users/Desenvolvimento/Documents/dadosExemplares.txt");
        bufferDados = new BufferedReader(ler);
//        while ((linha = bufferDados.readLine()) != null) {;
//        dados += linha;
//        }
        while ((dados = bufferDados.readLine()) != null) {  
                if(!dados.trim().equals(nomeExemplar.trim())) { 
                       Livros livros = new Livros();
                       livros.setTitulo(dados);
                    }  
                
                }  
                               
  //      JOptionPane.showMessageDialog(null, "Não foi Possível localizar ");
        bufferDados.close();
        
    
}catch(Exception e){
        JOptionPane.showMessageDialog(null, "O livro solicitado não foi localizado" + e);
}
    return null;
}


public List<Livros> lerDadosEmprestimo()throws Exception{
    try {
        
        List<Cliente> listCliente = new ArrayList<>();
         FileReader ler;
        BufferedReader bufferDados;
        String dados = "";
        String linha;
        ler = new FileReader("C:/Users/Desenvolvimento/Documents/dadosEmprestimos.txt");
        bufferDados = new BufferedReader(ler);
        while ((linha = bufferDados.readLine()) != null) {
        dados += linha;
        }
        
        
        Scanner scanner = new Scanner(new FileReader("C:/Users/Desenvolvimento/Documents/dadosEmprestimos.txt"));
	
	while(scanner.hasNext())
	{
                Livros livros = new Livros();
              
		String idEmprestimo = scanner.nextLine();
		String idCliente = scanner.nextLine();
                String nome = scanner.nextLine();
                String IdLivro = scanner.nextLine();
                String titulo = scanner.nextLine();
                String diasEmprestado = scanner.nextLine();
            
               livros.setId(idEmprestimo);
		livros.setNumeroIdentificacaoCliente(idCliente);
                livros.setNome(nome);
                livros.setNumeroIdentificacao(IdLivro);
                livros.setTitulo(titulo);
                livros.setDiasEmprestado((diasEmprestado));
                  listLivros.add(livros);
	}
       
        bufferDados.close();
        
        return listLivros;
   
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "O arquivo solicitado não foi localizado" + e);
    }
        return null;
}

public void cadastrarEmprestimo(Cliente cliente, Livros livros, Biblioteca biblioteca )throws Exception{
    try {
         if(!arquivoEmprestimos.exists()){
            arquivoEmprestimos.createNewFile();
        }
        
        FileWriter fw = new FileWriter(arquivoEmprestimos, true);
        
        fw.append(biblioteca.id);
        fw.append("\n");
        fw.append( cliente.getNumeroIdentificacaoCliente());
        fw.append("\n");
        fw.append(cliente.nome);
        fw.append("\n");
        fw.append( livros.numeroIdentificacao);
        fw.append("\n");
        fw.append(livros.titulo);
        fw.append("\n");
        fw.append( biblioteca.diasEmprestar);
        fw.append("\n");
        
  
        
      fw.flush();
      fw.close();
      
      JOptionPane.showMessageDialog(null, "O Empréstimo foi inserido com sucesso em seu BD");
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro ao inserir os dados" + e);
    }
}
  
public static int buscarEmprestimos(String idUsuario)throws Exception{
    try{
     FileReader ler;
       List<Cliente> listCliente = new ArrayList<>();
        BufferedReader bufferDados;
        String dados = "";
        String linha;
        ler = new FileReader("C:/Users/Desenvolvimento/Documents/dadosExemplares.txt");
        bufferDados = new BufferedReader(ler);
//        while ((linha = bufferDados.readLine()) != null) {;
//        dados += linha;
//        }
        while ((dados = bufferDados.readLine()) != null) {  
                if(!dados.trim().equals(idUsuario.trim())) { 
                       Cliente cliente = new Cliente();
                       cliente.setNumeroIdentificacaoCliente(dados);
                       
                     listCliente.add(cliente);
                    }  
                
            
        }
        bufferDados.close();
           return listCliente.size();
    
}catch(Exception e){
        JOptionPane.showMessageDialog(null, "O Cliente solicitado não foi localizado" + e);
}
        return 0;
}

     
}