package salario;

public class Funcionario {

	private String nome;
	private Double salario;
	private Cargo cargo;
	
	public Funcionario(String nome, Double salario, Cargo cargo) {
		this.nome = nome;
		this.salario = salario;
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public Double getSalario() {
		return salario;
	}

	public Cargo getCargo() {
		return cargo;
	}
}
