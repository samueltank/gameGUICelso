package br.senai.sp.jandira.model;


public class Fabricante {

	private String nomeFabricante;
	private String anoQueSurgiuFabricante;
	private double patrimonioFabricante;
	
	public  Fabricante(String nome, String ano, double patrimonio) {
		setNomeFabricante(nome);
		setAnoQueSurgiuFabricante(ano);
		setPatrimonioFabricante(patrimonio);
	}

	public void setNomeFabricante(String nomeFabricante) {
		this.nomeFabricante = nomeFabricante;
	}

	public String getNomeFabricante() {
		return nomeFabricante;
	}

	public void setAnoQueSurgiuFabricante(String anoQueSurgiuFabricante) {
		this.anoQueSurgiuFabricante = anoQueSurgiuFabricante;
	}

	public String getAnoQueSurgiuFabricante() {
		return anoQueSurgiuFabricante;
	}

	public void setPatrimonioFabricante(double patrimonioFabricante) {
		this.patrimonioFabricante = patrimonioFabricante;
	}

	public double getPatrimonioFabricante() {
		return patrimonioFabricante;
	}

}
