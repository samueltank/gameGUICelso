package br.senai.sp.jandira.repository;

import java.util.ArrayList;

import br.senai.sp.jandira.iofile.File;
import br.senai.sp.jandira.model.Jogo;



public class JogoRepository {
	
	private static final ArrayList<Jogo> colecaoJogos = new ArrayList<Jogo>();
	File arq;

	{
		arq = new File("C:\\Users\\devsa\\Downloads\\test", "TestJogos");
	}
	
	public void gravar(Jogo jogo) {
		colecaoJogos.add(jogo);
		arq.gravar(jogo.getFullContent());
	}

	public Jogo listarJogo(int posicao) {
		return colecaoJogos.get(posicao);
	}

	public ArrayList<Jogo> listarTodos() {
		return colecaoJogos;
	}
}
