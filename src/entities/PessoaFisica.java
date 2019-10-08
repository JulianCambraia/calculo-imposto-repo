package entities;

public class PessoaFisica extends Pessoa {

	private Double gastosSaude;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public Double calcularImposto() {
		Double imposto = 0.00;
		if (getRendaAnual() < 20000.00) {
			imposto = getRendaAnual() * 0.15;
		} else if (getRendaAnual() >= 20000.00) {
			imposto = getRendaAnual() * 0.25;
		}

		return calcularGastosSaude(imposto);
	}

	private Double calcularGastosSaude(Double valor) {
		Double impostoDevido = 0.00;
		if (gastosSaude > 0) {
			impostoDevido = valor - (gastosSaude * 0.50);
		}

		return impostoDevido;
	}

}
