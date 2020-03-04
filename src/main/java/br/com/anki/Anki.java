package br.com.anki;

import java.io.File;
import java.util.ArrayList;

public class Anki {
	
	public ArrayList<String> blocos;
	public String textoIngles;
	public String textoPortugues;
	public File arquivoAudioIngles;
	
	public ArrayList<String> getBlocos() {
		return blocos;
	}
	public void setBlocos(ArrayList<String> blocos) {
		this.blocos = blocos;
	}
	public String getTextoIngles() {
		return textoIngles;
	}
	public void setTextoIngles(String textoIngles) {
		this.textoIngles = textoIngles;
	}
	public String getTextoPortugues() {
		return textoPortugues;
	}
	public void setTextoPortugues(String textoPortugues) {
		this.textoPortugues = textoPortugues;
	}
	public File getArquivoAudioIngles() {
		return arquivoAudioIngles;
	}
	public void setArquivoAudioIngles(File arquivoAudioIngles) {
		this.arquivoAudioIngles = arquivoAudioIngles;
	}
	
	
	

}
