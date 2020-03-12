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

public class AnkiAutoTXTMain {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {

		boolean isTeste = true;
				
		// MODULO - 7
		/*
		String indice = "07"; // Até 07
		String path = "C:\\CursoInglesMairoVergara\\7 - Goldilocks\\";
		String pathAudio = "Goldilocks Audios para Anki "+indice+"\\Goldilocks Audios Anki "+indice+"\\";
		String fileTXTName = "TXT Goldilocks and the Three Bears "+indice+".txt";	
		*/
		
		// MODULO - 8
		
		String indice = "01"; // Até 07
		String path = "C:\\CursoInglesMairoVergara\\8 - Antonio Canova\\";
		String pathAudio = "AC Audios para Anki "+indice+"\\Antonio Canova Audios Anki "+indice+"\\";
		String fileTXTName = "TXT Antonio Canova "+indice+".txt";	
		
		File dirAudioFiles = new File(path.concat(pathAudio));
		File[] audioFiles = dirAudioFiles.listFiles();
	
		Path pathFileTXT = Paths.get(path.concat(fileTXTName));
		byte[] bytes = Files.readAllBytes(pathFileTXT);
		List<String> allLines = Files.readAllLines(pathFileTXT, StandardCharsets.UTF_8);

		int passo = 3;
		List<Anki> listAnki = new ArrayList<Anki>();
		for(int i = 0; i<(allLines.size()/passo); i++) {
				
			Anki anki = new Anki();
			String numeroArquivoAudio = (allLines.get(0+(i*passo)));
			for(File nomeArquivo : audioFiles) {
				if(nomeArquivo.getName().toUpperCase().trim().startsWith(numeroArquivoAudio.toUpperCase().trim())){
					anki.setArquivoAudioIngles(nomeArquivo);
					break;
				}
			}

			anki.setTextoIngles(allLines.get(1+(i*passo)));
			anki.setTextoPortugues(allLines.get(2+(i*passo)));
				
			listAnki.add(anki);
		}
		
		if (!isTeste==true) {
			 
			 
			AnkiAuto ankiAuto = new AnkiAuto();
		 
			 for(Anki anki : listAnki) {
				 									  
				 System.out.println("Texto Ingles:" + anki.getTextoIngles());
				 System.out.println("Audio: " + anki.getArquivoAudioIngles());	
				 System.out.println("Texto Portugues:" + anki.getTextoPortugues());
				 System.out.println("--------");
				 
				 ankiAuto.fraseIngles(anki.getTextoIngles().concat(" "));
				 ankiAuto.audioIngles(anki.getArquivoAudioIngles());
				 ankiAuto.frasePortugues(anki.getTextoPortugues().concat(" "));
		 
			 }
			 
			 ankiAuto.fecharAplicacao();
	
		 }	else {
			
			 for(Anki anki : listAnki) {
				  
				 System.out.println("Texto Ingles:" + anki.getTextoIngles());
				 System.out.println("Audio: " + anki.getArquivoAudioIngles());	
				 System.out.println("Texto Portugues:" + anki.getTextoPortugues());
				 System.out.println("--------");
		 
			 }
			 
		 }
		 
		 System.out.println("FIM!");
	
	}
	
	
}
