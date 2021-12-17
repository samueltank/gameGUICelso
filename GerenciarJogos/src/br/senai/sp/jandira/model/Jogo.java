package br.senai.sp.jandira.model;

import br.senai.sp.jandira.lista.TipoConsole;

public class Jogo {

	private String jogoName;
	private Fabricante fabricante;
	private TipoConsole tipoConsole;
	private boolean zerado;
	private double valor;
	private String observacoes;

	public void setName(String jogo) {
		this.jogoName = jogo;
	}

	public String getName() {
		return this.jogoName;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Fabricante getFabricante() {
		return this.fabricante;
	}

	public void setTipoConsole(TipoConsole tipoConsole) {
		this.tipoConsole = tipoConsole;
	}

	public TipoConsole getTipoConsole() {
		return this.tipoConsole;
	}

	public void setZerado(boolean zerado) {
		this.zerado = zerado;
	}

	public boolean getZerado() {
		return this.zerado;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return this.valor;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getObservacoes() {
		return this.observacoes;
	}

	public String getFullContent() {
		String process = getName() + ";" + getFabricante().getNomeFabricante()
				+ ";" + getTipoConsole().getDescription() + ";"
				+ String.valueOf(getZerado()) + ";" + String.valueOf(getValor())
				+ ";" + getObservacoes();
		return process;
	}
}
