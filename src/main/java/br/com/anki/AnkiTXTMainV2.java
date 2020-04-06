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

public class AnkiTXTMainV2 {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {

		boolean isTeste = false;
		boolean isJustWords = true;

		int recomecar = 0;

		/*
		String fileTXTName = "Lost and Found.txt";
		String path = "\\src\\resource\\CursoInglesMairoVergara\\10 - Lost and Found\\part 10\\";
		*/
		
		String fileTXTName = "Steve Jobs.txt";
		String path = "\\src\\resource\\CursoInglesMairoVergara\\11 - Steve Jobs\\part#01\\";

		File file = new File(new File(".").getCanonicalPath().concat(path.concat(fileTXTName)));
		Path pathFileTXT = Paths.get(file.getAbsolutePath());
		byte[] bytes = Files.readAllBytes(pathFileTXT);
		List<String> allLines = Files.readAllLines(pathFileTXT, StandardCharsets.UTF_8);
		int passo = 3;
		List<Anki> listAnki = new ArrayList<Anki>();
		for(int i = 0; i<(allLines.size()/passo); i++) {
			File fileMp3 = new File(new File(".").getCanonicalPath().concat(path.concat("".concat(new Integer(i+1).toString()).concat(".mp3"))));
			Anki anki = new Anki();
			if(fileMp3.exists()) anki.setArquivoAudioIngles(fileMp3);
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
					 System.out.println("Audio Ingles:" + anki.getArquivoAudioIngles());
					 System.out.println("Texto Portugues:" + anki.getTextoPortugues());
					 System.out.println("--------");

					 if(isJustWords) {

						 if(anki.getArquivoAudioIngles()==null) {
							 ankiMineracao.fraseIngles(anki.getTextoIngles().concat(" "));
							 ankiMineracao.audioIngles();
							 ankiMineracao.frasePortugues(anki.getTextoPortugues().concat(" "));
						 }

					 } else {

						 ankiMineracao.fraseIngles(anki.getTextoIngles().concat(" "));
						 if(anki.getArquivoAudioIngles()!=null)  ankiMineracao.audioIngles(anki.getArquivoAudioIngles());
						 else ankiMineracao.audioIngles();
						 ankiMineracao.frasePortugues(anki.getTextoPortugues().concat(" "));
					 }

				 }

			 }

			 ankiMineracao.fecharAplicacao();

		 }	else {

			 for(Anki anki : listAnki) {

				 int pos = listAnki.indexOf(anki);
				 System.out.println(pos);
				 if(pos>=recomecar) {
					 System.out.println("Texto Ingles:" + anki.getTextoIngles());
					 System.out.println("Audio Ingles:" + anki.getArquivoAudioIngles());
					 System.out.println("Texto Portugues:" + anki.getTextoPortugues());
					 System.out.println("--------");
				 }
			 }

		 }

		 System.out.println("FIM!");

	}



}
