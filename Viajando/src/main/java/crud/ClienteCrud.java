/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;


import dao.ClienteDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Cliente;


public class ClienteCrud {
    
    public static void main(String[]args){
        ClienteDao clientDao = new ClienteDao();
        Scanner input = new Scanner(System.in);
                
        int opcao = 0;
        int posicao = 0;
        int id = 0;        
        String nome = "";
        
        List <Cliente> cliente = new ArrayList<Cliente>();
        
        do {
            System.out.println("---CRUD CLIENTES---");
            System.out.println("1- Cadastro de Cliente ");
            System.out.println("2- Consulta de Cliente ");
            System.out.println("3- Delete de Cliente ");
            System.out.println("4-Atualizar Cliente ");
            System.out.println("0- Sair ");
            
            opcao = input.nextInt();
            
            switch (opcao){
                case 1:
                    System.out.println("***Cadastrar Cliente***");
                    System.out.println("Digite o nome: ");
                    nome = input.nextLine();
                    nome = input.nextLine();
                    
                    Cliente client = new Cliente();
                    client.setNome(nome);
                    clientDao.save(client);
                    System.out.println("\n**Cadastrado**\n");
                    break;
                case 2:
                    for(Cliente a : clientDao.getCliente()){
                        System.out.println("Id: " + a.getID_Cliente() + "Nome: " + a.getNome());
                    }
                    System.out.println("**Consulta Finalizada**");
                    break;
                case 3:
                    System.out.println("Passe o ID para exclusão: ");
                    posicao = input.nextInt();
                    clientDao.deleteById(posicao);
                    System.out.println("*Cliente excluido com sucesso*");
                    break;
                case 4:
                    System.out.println("Digite o ID do Cliente: ");
                    id = input.nextInt();
                    System.out.println("Digite o novo nome do Cliente: ");
                    nome = input.nextLine();
                    nome = input.nextLine();
                    
                    Cliente client1 = new Cliente(id,nome);
                    clientDao.update(client1);
                    break;
                            
                default:
                    System.out.println(0 != opcao ? "\n Opção e inválida,tente novamente.\n":"");
                    break;
            }
        }while(opcao != 0);
            input.close();
            System.out.println("*Finalizado*");
        
        
        
        }
        
                
    }

