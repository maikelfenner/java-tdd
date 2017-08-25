package salario;

public class QuinzeOuVinteCincoPorCento extends RegraDeCalculo {

	@Override
	protected int limite() {
		return 2500;
	}

	@Override
	protected double porcentagemAcimaDoLimite() {
		return 0.75;
	}

	@Override
	protected double porcentagemBase() {
		return .85;
	}
}
