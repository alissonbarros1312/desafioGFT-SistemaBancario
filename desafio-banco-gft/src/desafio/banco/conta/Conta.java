package desafio.banco.conta;

import desafio.banco.pessoa.Cliente;

public class Conta {
	
	public int tipo = 1;
	
	public int getTipo() {
		return tipo;
	}
	
	private static final int CONTA_PADRAO = 0001;
	private static int SEQUENCIAL = 1;
	
	private int numAgencia;
	private int numConta;
	private Cliente dadosCliente = new Cliente();
	private double saldo;
	
	public Conta() {
		this.numAgencia = SEQUENCIAL++;
		this.numConta = CONTA_PADRAO;
	}
	
	public Cliente getDadosCliente() {
		return dadosCliente;
	}
	
	public void setNumAgencia(int numAgencia) {
		this.numAgencia = numAgencia;
	}
	
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void sacar(double saque) {
		if(getSaldo() < saque) {
			throw new RuntimeException("Saldo Insulficiente!");
		} else {
			setSaldo(this.saldo-= saque);
			System.out.println("Saque efetuado com sucesso!");
		}
		
	}

	public void depositar(double deposito) {
		setSaldo(this.saldo+= deposito);
	}

	public void transferir(String pix, double valor) {
		// TODO Auto-generated method stub
		
	}
	
	public String extrato() {
		
		String str = "*** EXTRATO BANCARIO ***\n"
				   + "NOME: "+ getDadosCliente().getNome()+"\n"
				   + "AGENCIA: "+this.numAgencia+"\n"
				   + "CONTA: "+this.numConta+"\n"
				   + "SALDO: R$ "+ getSaldo()+"\n"
				   + "************************";
		
		return str;
	}

	@Override
	public String toString() {
		
		String str = "--- ACESSO A CONTA ---\n"
				   +getDadosCliente().toString()+"\n"
				   + "CONTA: "+this.numConta+"\n"
				   + "AGENCIA: "+ this.numAgencia+"\n"
				   + "----------------------";
		
		return str;
	}
	
	

}
