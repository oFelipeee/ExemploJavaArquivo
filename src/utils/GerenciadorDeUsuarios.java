package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Usuarios;

public class GerenciadorDeUsuarios {
	
	private static final String NOME_ARQUIVO = "usuarios.txt";
	
//	Verificar a existencia do nosso banco e criar nosso arquivo nao existente
	public void verficarECria(String nomeArquivo) {
//		File => arquivo
		File arquivo = new File(nomeArquivo);
		
//		Verificar se o arquivo existe
		if(arquivo.exists()) {
			System.out.println("Banco funcionando!");

		}else {
			try {
//				Criar o novo arquivo
				arquivo.createNewFile();
				System.out.println("Usuario criado com sucesso!");
			}catch(IOException e){
				System.out.println("Ocorreu um erro ao criar o Usuario:" + e.getMessage());
				
			}
		}
	}
	
	
	
	public void adicionarUsuario(Usuarios usuario){
//		Writer => Escrever
//		BufferedWriter, FileWriter => Inscritor de arquivos
//		BufferedWriter => tem uma escrita melhor
//		FileWriter => Escreve dentro do arquivo
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
			bw.write(usuario.toString());
			bw.newLine();
			System.out.println("Usuario adicionado com sucesso!");
		}catch(IOException e){
			System.out.println("Ocorreu um erro ao escrever o arquivo" + e.getMessage());
			
		}
		
		
	}
	
	
	public List<Usuarios> lerUsuarios() {
		List<Usuarios> usuarios = new ArrayList<Usuarios>();
//		Buffed, File, Reader
//		FileReader = Ler o arquivo
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
			String linha;
//			Perccorrer as linhas enquanto seja diferente de vazio
			while((linha = br.readLine()) !=null){
				String[] partes = linha.split(";");// Dividir em tres partes
//				Adicionar usuarios a lista 
				usuarios.add(new Usuarios(Integer.parseInt(partes [0]), partes[1], partes[2]));
			}
		}catch(IOException e) {
			System.out.println("Ocorrreu um erro ao ler o arquivo:" + e.getMessage());
		}
		return usuarios; 	
	}

	
	
	public void deletarUsuario(int id) {
		List<Usuarios> usuarios = lerUsuarios();
		
		if(usuarios.removeIf(usuario  -> usuario.getId() == id)) {
//			Reescrevendo arquivos com novos usuarios e alterações
			reescreverArquivo(usuarios);
			System.out.println("Usuario deletado com sucesso!");
	}else {
		System.out.println("Usuario não encontrado");
	}
	}
	
	public void reescreverArquivo(List<Usuarios> usuarios) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
			for(Usuarios usuario : usuarios) {
				bw.write(usuario.toString());
				bw.newLine();
			}
			
		}catch(IOException e) {
			System.out.println("Ocorreu um erro ao reescrever o arquivo" + e.getMessage());
	}
}
	
	
	public void listarUsuarios() {
		List<Usuarios> usuarios = lerUsuarios();
//		nenhum usuario
		if(usuarios.isEmpty()) {
			System.out.println("Nenhum usuario cadastrado");
		}else {
			System.out.println("Lista de usuarios");
			for(Usuarios usuario : usuarios) {
				System.out.print("ID:" + usuario.getId() + "Nome:" + "" + usuario.getNome() + ", Senha: " + usuario.getSenha());
				
			}
		}
	}
	
	
	public void editarUsuario(int id, String novoNome, String novaSenha){
		List<Usuarios> usuarios = lerUsuarios();
		boolean encontrado = false;
		for(Usuarios usuario : usuarios) {
			if(usuario.getId() ==id) {
				usuario.setNome(novoNome);
				usuario.setSenha(novaSenha);
				encontrado = true;
				break;
			}
		}
		
		if(encontrado) {
			reescreverArquivo(usuarios);
			System.out.println("Usuario editado com sucesso!");
		}else {
			System.out.println("Usuario não encontrado");
		}
	}

	
	public void listarEspecifico(int id) {
		List<Usuarios> usuarios = lerUsuarios();
		for(Usuarios usuario : usuarios) {
			if(usuario.getId() ==id) {
				System.out.println("ID" + usuario.getId() + ",Nome:" + usuario.getNome() + ",Senha:" + usuario.getSenha());
				
			}
		}
}
	
	
	
		
		
	}
		
		
			
		
	

