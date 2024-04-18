package services;

import java.util.List;
import java.util.Scanner;

import models.Usuarios;
import utils.GerenciadorDeUsuarios;

public class HandleMenu {
	
	Scanner sc = new Scanner(System.in);
	
	
	GerenciadorDeUsuarios gs = new GerenciadorDeUsuarios();
	
	public HandleMenu() {
//		TODA VEZ QUE A CLASSE MENU, FOR INSTANCIADO, O NOSSO SERA VERIFICADO
		gs.verficarECria("Usuarios.txt");
		
	}
	
	
	public void criar() {
		System.out.println("Digite o nome:");
		String nome = sc.next();
		System.out.println("Digite a senha:");
		String senha = sc.next();
		
		int id = getNextId();
		
		
		Usuarios u = new Usuarios(id, nome, senha);
		gs.adicionarUsuario(u);
		
		
	}
	
	public void editar() {
		System.out.println("Digite o id do usuario:");
		int id = sc.nextInt();
		System.out.println("Digite o novo nome:");
		String nome = sc.next();
		System.out.print("Digite a nova senha");
		String senha = sc.next();
		
		gs.editarUsuario(id, nome, senha);
		
	}
	
	public void deletar() {
		System.out.println("Digite o ID do usuario a ser deletado");
		int id = sc.nextInt();
		gs.deletarUsuario(id);
		
		
	}
	
	public void listar() {
		gs.listarUsuarios();
	}
	
	public void listarEspecifico() {
		System.out.print("Digite o ID da busca");
		int id = sc.nextInt();
		
		gs.listarEspecifico(id);
	}
	
	public void login() {
		System.out.println("Qual o seu nome?");
		String nome = sc.next();
		System.out.print("Qual a sua senha?");
		String senha = sc.next();
		
		
	}
	
	private int getNextId() {
	 List<Usuarios> usuarios = gs.lerUsuarios();
	 int maxId = 0;
//	 For => Foreach
	 for(Usuarios usuario : usuarios) {
		 int id = usuario.getId();
		 if(id > maxId) {
//			 Método para descobrir o ultimo id
			 maxId = id;
			 
		 }
	 }
//	 Soma 1 + o ultimo
	 return maxId + 1;
 }
	
	

	
	

}
