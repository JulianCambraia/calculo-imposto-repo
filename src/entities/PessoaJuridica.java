package entities;

public class PessoaJuridica extends Pessoa {

	private Integer numeroFuncionarios;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	@Override
	public Double calcularImposto() {
		Double impostoDevido = 0.00;

		impostoDevido = getRendaAnual() * 0.16;

		if (numeroFuncionarios > 10) {
			impostoDevido = getRendaAnual() * 0.14;
		}
		return impostoDevido;
	}

}
