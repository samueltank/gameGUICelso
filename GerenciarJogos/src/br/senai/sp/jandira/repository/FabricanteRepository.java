package br.senai.sp.jandira.repository;

import java.util.ArrayList;
import java.util.HashMap;

import br.senai.sp.jandira.model.Fabricante;

public class FabricanteRepository {

	private ArrayList<Fabricante> colecaoFabricante;
	
	private  HashMap<String, Fabricante> valuesFabricante;
	
	public FabricanteRepository() {
		colecaoFabricante = new ArrayList<Fabricante>();
        for (Fabricante i : colecaoFabricante) {
			valuesFabricante.put(i.getNomeFabricante(), i);
		}
	}
	
	public void gravar(Fabricante fabricante) {
		colecaoFabricante.add(fabricante);
	}
	
	public Fabricante listarFabricante(int posicao) {
		return colecaoFabricante.get(posicao);
	}
	
	public Fabricante listarFabricante(String name) {
		return valuesFabricante.get(name);
	}
	
	public Fabricante[] listarTodos() {
		return (Fabricante[]) colecaoFabricante
				.toArray(new Fabricante[colecaoFabricante.size()]);
	}
}
