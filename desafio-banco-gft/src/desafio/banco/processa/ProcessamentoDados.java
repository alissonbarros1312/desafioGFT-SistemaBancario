package desafio.banco.processa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import desafio.banco.conta.Conta;
import desafio.banco.conta.ContaCorrente;
import desafio.banco.conta.ContaPoupanca;

public class ProcessamentoDados {
	List<Conta> contasP = new ArrayList<Conta>();
	List<Conta> contasC = new ArrayList<Conta>();

	public void criarNovaConta(Scanner sc) {
		System.out.println("Digite o tipo de Conta: " + "\n1- Conta-Poupanca" + "\n2- Conta-Corrente");
		int conta = sc.nextInt();

		if (conta == 1) {

			Conta novaConta = new ContaPoupanca();

			System.out.print("\nDigite o nome: ");
			String nome = sc.next();

			System.out.print("Digite o cpf: ");
			String cpf = sc.next();

			System.out.print("Digite a senha: ");
			String senha = sc.next();

			novaConta.getDadosCliente().criarCliente(nome, cpf, senha);
			System.out.println("Conta criada com Sucesso!");
			System.out.println("-------------------------");

			contasP.add(novaConta);

		} else if (conta == 2) {

			Conta novaConta = new ContaCorrente();

			System.out.print("\nDigite o nome: ");
			String nome = sc.next();

			System.out.print("Digite o cpf: ");
			String cpf = sc.next();

			System.out.print("Digite a senha: ");
			String senha = sc.next();
			
			novaConta.getDadosCliente().criarCliente(nome, cpf, senha);
			System.out.println("\nConta criada com Sucesso!");
			System.out.println("-------------------------");

			contasC.add(novaConta);
		}

	}

	public void acessarConta(Scanner sc) {
		System.out.println("Digite o tipo de Conta: \n" + "1 - Conta-Poupanca \n" + "2 - Conta-Corrente");
		int count = sc.nextInt();

		System.out.println("Digite o CPF do titular");
		String cpf = sc.next();

		if (count == 1) {
			for (Conta conta : contasP) {
				if (cpf.equalsIgnoreCase(conta.getDadosCliente().getCpf())) {
					processoDadosConta(sc, conta);

				}
			}
		} else if (count == 2) {
			for (Conta conta : contasC) {
				if (cpf.equalsIgnoreCase(conta.getDadosCliente().getCpf())) {
					processoDadosConta(sc, conta);
				}
			}
		}

	}

	public void processoDadosConta(Scanner sc, Conta conta) {

		System.out.println("--- BEM-VINDO " + conta.getDadosCliente().getNome() + " ---");

		while (true) {
			System.out.println("DIGITE UMA OPCAO\n" + "1 - SAQUE\n" + "2 - DEPOSITO\n" + "3 - EXTRATO\n"
					+ "4 - TRANSFERENCIA\n" + "0 - SAIR");
			int alt = sc.nextInt();
			double valor;

			switch (alt) {

			case 1:
				System.out.print("DIGITE O VALOR: ");
				valor = sc.nextDouble();
				conta.sacar(valor);
				break;

			case 2:
				System.out.print("DIGITE O VALOR: ");
				valor = sc.nextDouble();
				conta.depositar(valor);
				break;

			case 3:
				System.out.println(conta.extrato());
				break;

			case 4:
				System.out.print("DIGITE O VALOR: ");
				valor = sc.nextDouble();
				System.out.print("DIGITE O CPF DO DESTINATARIO: ");
				String pix = sc.next();
				
				if(conta.getTipo() == 1) {
					if(transferirPoupanca(pix, valor) == true) {
						 conta.sacar(valor);
						 System.out.println("TRANSFERENCIA COM SUCESSO!");
					 } else {
						 System.out.println("TRANSFERENCIA NAO CONCLUIDA");
					 }
				} else if(conta.getTipo() == 2) {
					if(transferirCorrente(pix, valor) == true) {
						 conta.sacar(valor);
						 System.out.println("TRANSFERENCIA COM SUCESSO!");
					 } else {
						 System.out.println("TRANSFERENCIA NAO CONCLUIDA");
					 }
				}
				 
				break;

			case 0:
				System.out.println("SAINDO...");
				break;
			default:
				throw new IllegalArgumentException("OPCAO INVÁLIDO: ");
			}
			
			if(alt == 0) {
				break;
			}

		}
	}

	public boolean transferirPoupanca(String pix, double valor) {
		boolean valida = false;
		
		for (Conta conta : contasP) {
			if (pix.equalsIgnoreCase(conta.getDadosCliente().getCpf())) {
				conta.depositar(valor);
				valida = true;
			}
		}
		return valida;
	}

	public boolean transferirCorrente(String pix, double valor) {
		boolean valida = false;
		for (Conta conta : contasC) {
			if (pix.equalsIgnoreCase(conta.getDadosCliente().getCpf())) {
				conta.depositar(valor);
				valida = true;
			}
		}
		return valida;
	}
}
