package sistema;

import java.util.Scanner;

import services.HandleMenu;

public class Sistema {

	public static void main(String[] args) {
		
//		Criar scanner para capiturar dados.
		Scanner sc = new Scanner(System.in);
		HandleMenu hm = new HandleMenu();
		int opcao = 0;
		do {
//		/n usado para criar uma nova linha.
			System.out.println("1 - Criar Usuario \n2 - Editar usuario \n3 - Deletar usuario \n4 - Listar usuarios \n5 - Listar algum usuario específico  \n6 - Fazer Login\n9 - Sair");
			opcao = sc.nextInt();
			
			switch(opcao) {
			case 1:{
				hm.criar();
				break;
			}
			case 2:{
				hm.editar();
				break;
				
			}
			case 3:{
				hm.deletar();
				break;
			}
			case 4:{
				hm.listar();
				break;
			}
			case 5: {
				hm.listarEspecifico();
				break;
			}
			case 6:{
				
				break;
			}
			default:
				System.out.println("Opçao Invalida");
				break;
			}
		
		}while(opcao != 9);
		sc.close();
		

	}

}
