package desafio.banco.pessoa;

public class Cliente implements Pessoa {
	
	private enum tipoCliente {FISICA, JURIDICA};
	private String cpf = new String();
	private String nome = new String();
	private String senhaAcesso = new String();
	private tipoCliente tipo;
	
	@Override
	public void adicionaCPF(String cpf) {
		
		if(cpf.isEmpty()) {
			throw new RuntimeException("CPF vazio!");
		}
		
		if(cpf.length() == 11) {
			setTipo(tipoCliente.FISICA);
		} else if (cpf.length() == 14) {
			setTipo(tipoCliente.JURIDICA);
		} else {
			throw new RuntimeException("Tamanho de CPF inválido para pessoa Fisica ou Juridica!");
		}
		
		if(getCpf().isEmpty()) {
			setCpf(cpf);
			System.out.println("CPF adicionado com sucesso!");
		} else {
			System.out.println("Já existe um CPF cadastrado!");
		}
		
	}
	
	@Override
	public void adicionaNome(String nome) {
		
		if(nome.isEmpty()) {
			throw new RuntimeException("Nome inválido");
		}
		
		setNome(nome);
		System.out.println("\nNome cadastrado com sucesso!");
	}
	
	@Override
	public void adicionaSenha(String senha) {
		
		if(senha.isEmpty()) {
			throw new RuntimeException("Senha inválida!");
		}
		
		if(!getSenhaAcesso().isEmpty()) {
			throw new RuntimeException("Já existe uma senha cadastrada!");
		}
		
		setSenhaAcesso(senha);
		System.out.println("Senha cadastrada com sucesso!");
		
	}
	
	public void criarCliente(String nome, String cpf, String senha) {
		adicionaNome(nome);
		adicionaCPF(cpf);
		adicionaSenha(senha);
	}
	
	@Override
	public String toString() {
		return "Nome = " + getNome() + "\nCPF  = " + getCpf() + "\nTipo = " + getTipo();
	}

	private void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	private void setTipo(tipoCliente tipo) {
		this.tipo = tipo;
	}
	
	private tipoCliente getTipo() {
		return tipo;
	}
	
	private void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	private String getSenhaAcesso() {
		return senhaAcesso;
	}
	
	private void setSenhaAcesso(String senhaAcesso) {
		this.senhaAcesso = senhaAcesso;
	}
	
}
