package services;

import java.util.Scanner;

import models.Produto;

public class HandleMenuProdutos {
	Scanner sc = new Scanner(System.in);
	
	
	public void criarProduto() {
		System.out.println("Digite o nome do produto:");
		String nome = sc.next();
		System.out.println("Digite o codigo do produto:");
		String senha = sc.next();
		
		int id = getNextId();
		
		
		Produto p = new Produto(id, nome, quantidade, id);
		gs.criarProduto(p); 
		
		
	}
	

}
