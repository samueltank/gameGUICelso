package br.senai.sp.jandira.iofile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public final class File {
	private String path;
	
	public File(String path) {
		this.path = path + "\\ArquivoTeste.txt";
		System.out.println("Seu diretório é: " + this.path);
	}
	
	public File(String path, String nameFile) {
		// Captura o diretório relativo atual
		this.path = path + "\\" + nameFile + ".txt";
		System.out.println("Seu diretório é: " + this.path);
	}
	
	
	public void gravar(String content) {
		try {
			// Objetos de gravação:
			FileWriter fileWriter = new FileWriter(path);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			FileReader fileReader = new FileReader(this.path);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String linha = bufferedReader.readLine();
			while (linha != null) {
				
			}
			// Gravação do conteúdo:
			printWriter.append(content);
			System.out.println("Arquivo escrito com sucesso!");
			
			// Fechar gravador:
			fileWriter.close();
		} catch (IOException e) {
			e.getMessage();
			System.out.println("Ocorreu um erro!");
		}
	}
	
	public void ler() {
		String content = "";
		
		try {
			FileReader fileReader = new FileReader(this.path);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String low = bufferedReader.readLine();
			
			while (low != null) {
				
				
				content += low;
				low = bufferedReader.readLine();
			}
			
			System.out.println("Arquivo lido com sucesso!");
			fileReader.close();
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo!");
			e.getMessage();
		}
	}
	
	public void read(String path) {
		String content = "";
		
		try {
			FileReader fileReader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String low = bufferedReader.readLine();
			
			while (low != null) {
				
				
				content += low;
				low = bufferedReader.readLine();
			}
			
			fileReader.close();
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo!");
			e.getMessage();
		}
	}
}
