package br.com.anki;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AnkiMineracaoTXTMain {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {

		boolean isTeste = false;	
				
		int recomecar = 0;
		
		/*
		// MODULO - 9
		String indice = "";
		String path = "C:\\CursoInglesMairoVergara\\Fundacao\\9 - Cats and Dogs";
		String fileTXTName = "\\TXT Cats and Dogs.txt";	
		*/
		
		// MODULO - 10
		String path = "C:\\CursoInglesMairoVergara\\Mineracao\\10 - Lost and Found";
		String fileTXTName = "\\TXT Lost and Found.txt";	
			
			
		Path pathFileTXT = Paths.get(path.concat(fileTXTName));
		byte[] bytes = Files.readAllBytes(pathFileTXT);
		List<String> allLines = Files.readAllLines(pathFileTXT, StandardCharsets.UTF_8);

		int passo = 3;
		List<Anki> listAnki = new ArrayList<Anki>();
		for(int i = 0; i<(allLines.size()/passo); i++) {
				
			Anki anki = new Anki();
			anki.setTextoIngles(allLines.get(1+(i*passo)));
			anki.setTextoPortugues(allLines.get(2+(i*passo)));
				
			listAnki.add(anki);
		}
		
		if (!isTeste==true) {
			 
			 
			AnkiMineracao ankiMineracao = new AnkiMineracao(1);
		 
			 for(Anki anki : listAnki) {
				 
				 int pos = listAnki.indexOf(anki);
				 System.out.println(pos);
				 if(pos>=recomecar) {
					 System.out.println("Texto Ingles:" + anki.getTextoIngles());
					 System.out.println("Texto Portugues:" + anki.getTextoPortugues());
					 System.out.println("--------");
					 
					 ankiMineracao.fraseIngles(anki.getTextoIngles().concat(" "));
					 ankiMineracao.audioIngles();
					 ankiMineracao.frasePortugues(anki.getTextoPortugues().concat(" "));
				 }	 
			 }
			 
			 ankiMineracao.fecharAplicacao();
	
		 }	else {
			
			 for(Anki anki : listAnki) {
				  
				 int pos = listAnki.indexOf(anki);
				 System.out.println(pos);
				 if(pos>=recomecar) {
					 System.out.println("Texto Ingles:" + anki.getTextoIngles());
					 System.out.println("Texto Portugues:" + anki.getTextoPortugues());
					 System.out.println("--------");
				 }
			 }
			 
		 }
		 
		 System.out.println("FIM!");
	
	}
	
	
}
