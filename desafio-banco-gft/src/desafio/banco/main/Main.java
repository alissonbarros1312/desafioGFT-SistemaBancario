package desafio.banco.main;


import java.util.Scanner;

import desafio.banco.processa.ProcessamentoDados;

public class Main {

	public static void main(String[] args) {
		ProcessamentoDados acao = new ProcessamentoDados();
		Scanner sc = new Scanner(System.in);
		int count;
		
		while (true) {
			System.out.println("------- BEM-VINDO AO MENU DE ACESSO -------");
			System.out.println("");
			System.out.println("DIGITE O NUMERO DA OPCAO DESEJADA");
			System.out.println("1 - ACESSAR CONTA");
			System.out.println("2 - CRIAR UMA NOVA CONTA");
			System.out.println("0 - ENCERRAR APLICAÇÃO");
			
			count = sc.nextInt();
			if(count == 0) {
				System.out.println("Encerrando...");
				break;
			}
			
			switch (count) {
			case 1: {
				acao.acessarConta(sc);
				break;
			}
			
			case 2:{
				acao.criarNovaConta(sc);
				break;
			}
			
			default:
				throw new IllegalArgumentException("Valor Inválido: " + count);
			}
		}

	}

}
