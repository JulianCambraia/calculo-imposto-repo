package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class CalculoImpostoRendaMainProgram {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		System.out.print("Entre com o número de contribuintes para calcular o imposto devido:");
		Integer pNumContrib = sc.nextInt();
		System.out.println();
		for (int i = 1; i <= pNumContrib; i++) {
			
			System.out.println("Dados do Contribuinte #" + i + ";");
			System.out.print("Individual ou Empresa (i/e)? ");
			char pTipoPessoa = sc.next().charAt(0);
			System.out.print("Nome:");
			String pNome = sc.next();
			System.out.print("Rendimento anual:");
			sc.nextLine();
			Double pRenda = sc.nextDouble();
			if (pTipoPessoa == 'i') {
				System.out.print("Gastos com saúde:");
				Double pGastosSaude = sc.nextDouble();
				pessoas.add(new PessoaFisica(pNome, pRenda, pGastosSaude));
			} else if (pTipoPessoa == 'e') {
				System.out.print("Número de empregados:");
				Integer pNumEmpregados = sc.nextInt();
				pessoas.add(new PessoaJuridica(pNome, pRenda, pNumEmpregados));
			}			
		}
		System.out.println("Imposto Pago:");
		double soma = 0.00;
		for (Pessoa pessoa : pessoas) {
			soma += pessoa.calcularImposto();
			System.out.println(pessoa.getNome()+": "+ "R$ "+ String.format("%.2f", pessoa.calcularImposto()));
		}
		System.err.println();
		System.out.println("TOTAL DOS IMPOSTOS: R$ " + String.format("%.2f", soma));
		sc.close();
	}
}
