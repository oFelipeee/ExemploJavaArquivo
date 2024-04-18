package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Produto;
import models.Usuarios;

public class GerenciadorDeProdutos {

		private static final String NOME_ARQUIVO = "Produtos.txt";
		
//		Verificar a existencia do nosso banco e criar nosso arquivo nao existente
		public void verficarECria(String nomeArquivo) {
//			File => arquivo
			File arquivo = new File(nomeArquivo);
			
//			Verificar se o arquivo existe
			if(arquivo.exists()) {
				System.out.println("Banco funcionando!");

			}else {
				try {
//					Criar o novo arquivo
					arquivo.createNewFile();
					System.out.println("Produto criado com sucesso!");
				}catch(IOException e){
					System.out.println("Ocorreu um erro ao criar o Produto:" + e.getMessage());
					
				}
			}
		
		
		
		
	}
		
		
		public void criarProduto(Produto produtos) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
				bw.write(produtos.toString());
				bw.newLine();
				System.out.println("Produto criado com sucesso!");
			}catch(IOException e){
				System.out.println("Ocorreu um erro ao criar o produto" + e.getMessage());
				
			}
			
			
		}
		
	
		public List<Produto> lerProduto() {
			List<Produto> usuarios = new ArrayList<Produto>();
//			Buffed, File, Reader
//			FileReader = Ler o arquivo
			
			
			try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
				String linha;
//				Perccorrer as linhas enquanto seja diferente de vazio
				while((linha = br.readLine()) !=null){
					String[] partes = linha.split(";");// Dividir em tres partes
//					Adicionar usuarios a lista 
					usuarios.add(new Produto(Integer.parseInt(partes [0]), partes[1], partes[2]));
				}
			}catch(IOException e) {
				System.out.println("Ocorrreu um erro ao ler o arquivo:" + e.getMessage());
			}
			return usuarios; 	
		}
		
		
		public void deletarProduto(int id) {
			List<Produto> produto = lerProduto();
			
			if(produto.removeIf(Produto  -> ((models.Produto) produto).getId() == id)) {
//				Reescrevendo arquivos com novos usuarios e alterações
				reescreverArquivo(produto);
				System.out.println("Usuario deletado com sucesso!");
		}else {
			System.out.println("Usuario não encontrado");
		}
		}


		private void reescreverArquivo(List<Produto> produto) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
				for(Produto produtos : produto) {
					bw.write(produto.toString());
					bw.newLine();
				}
				
			}catch(IOException e) {
				System.out.println("Ocorreu um erro ao reescrever o produto" + e.getMessage());
		}
			
		}
		
		public void listarProduto() {
			List<Produto> produtos = lerProduto();
//			nenhum usuario
			if(produtos.isEmpty()) {
				System.out.println("Nenhum produto cadastrado");
			}else {
				System.out.println("Lista de produtos");
				for(Produto produto : produtos) {
					System.out.print("ID:" + produto.getId() + "Nome:" + "" + produto.getName());
					
				}
			}
		}
				
				
				
				
				
				
				public void editarUsuario(int id, String novoNome, int novaQuantidade){
					List<Produto> produtos = lerProduto();
					boolean encontrado = false;
					for(Produto produto : produtos) {
						if(produto.getId() ==id) {
							produto.setName(novoNome);
							produto.setQuantidade(novaQuantidade);
							encontrado = true;
							break;
						}
					}
					if(encontrado) {
						reescreverArquivo(lerProduto());
						System.out.println("Produto editado com sucesso!");
					}else {
						System.out.println("Produto não encontrado");
					}
				}

				
				public void listarProdutoEspecifico(int id) {
					List<Produto> produto = lerProduto();
					for(Produto produtos : produto) {
						if(((Produto) produto).getId() ==id) {
							System.out.println("ID" + ((Produto) produto).getId() + ",Nome:" + ((Usuarios) produto).getNome() + ",Senha:" + ((Usuarios) produto).getSenha());
							
						}
					}
			}
			}
			
				
			
		
		
	
		

	
