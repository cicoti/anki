package br.com.anki;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.TextPosition;

public class AnkiAutoPDFMain {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {

		boolean isTeste = true;

		
		/*
		// MODULO - 5
		String indice = "06"; // Até 07
		String path = "C:\\CursoInglesMairoVergara\\5 - The Boy Who Flew Too High\\";
		String pathAudio = "The Boy Who Flew "+indice+" Audios Anki\\";
		String filePDFName = "PDF The Boy who Flew too High "+indice+".pdf";
		*/
		
		/*
		// MODULO - 6
		String indice = "08"; // Até 08
		String path = "C:\\CursoInglesMairoVergara\\6 - The Bell of Atri\\";
		String pathAudio = "The Bell of Atri "+indice+" Audios Anki\\"; 
		String filePDFName = "PDF The Bell of Atri "+indice+".pdf";
		*/	
		
		
		// MODULO - 7
		String indice = "06"; // Até 07
		String path = "C:\\CursoInglesMairoVergara\\7 - Goldilocks\\";
		String pathAudio = "Goldilocks Audios para Anki "+indice+"\\Goldilocks Audios Anki "+indice+"\\";
		String filePDFName = "PDF Goldilocks and the Three Bears "+indice+".pdf";	
		
		
		String lines[] = null;
		String token = "";
		File dirAudioFiles = new File(path.concat(pathAudio));

		File[] audioFiles = dirAudioFiles.listFiles();
		
		File filePDF = new File(path.concat(filePDFName));
		PDDocument documentPDF = PDDocument.load(filePDF);
		documentPDF.getClass();
		
		if (!documentPDF.isEncrypted()) {
            
			CustomPDFTextStripper stripper = new CustomPDFTextStripper();
            
            String pdfFileInText = stripper.getText(documentPDF);
            List<List<TextPosition>>  characters = stripper.getCharactersByArticle();
            for(List<TextPosition> textPositions : characters) {
            	for(TextPosition textPosition : textPositions) {
            		for(int i : textPosition.getCharacterCodes()) {
            			//System.out.println(i + " " + Character.toString ((char) i));
	            		token = token.concat(Character.toString ((char) i));	
            		}
            	}
            }
             
            token = token.substring(token.lastIndexOf(" ")+1,token.length());
            pdfFileInText = pdfFileInText.replace(token, "\n");
            
            lines = pdfFileInText.split("\\r?\\n");
            
            System.out.println(pdfFileInText);
            
		}    

		
		
		if (audioFiles.length > 0) {
			
			try {
			
							String nomeArquivoAudio = audioFiles[0].getName().substring(3);
							
							nomeArquivoAudio = nomeArquivoAudio.substring(0,nomeArquivoAudio.indexOf(".mp3")).toUpperCase();
							int linhaInicio = 0;
							int linhaFim = 0;
							
							for (int j = 0 ; j < lines.length ; j++) {
				            	
								String linhaTexto = lines[j].replaceAll("[^\\dA-Za-z ]", "").toUpperCase().trim();
								
				                if(linhaTexto.toUpperCase().startsWith(nomeArquivoAudio)) {
					            	 linhaInicio = j;
					            	 break;
					             	
					             }	
					         }
							
							nomeArquivoAudio = audioFiles[audioFiles.length-1].getName().substring(3);
							
							nomeArquivoAudio = nomeArquivoAudio.substring(0,nomeArquivoAudio.indexOf(".mp3")).toUpperCase();
							
							for (int j = 0 ; j < lines.length ; j++) {
								
								String linhaTexto = lines[j].replaceAll("[^\\dA-Za-z ]", "").toUpperCase().trim();
								
				                if(linhaTexto.startsWith(nomeArquivoAudio)) {
					            	 linhaFim = j;
					            	 break;
					             	
					             }	
					         }
							
							 List<Anki> listaTextoAnki = new ArrayList<Anki>();
							 for (int i = 0; i < audioFiles.length; i++) {
						            
								 Anki anki = new Anki();
								 
								 	anki.setArquivoAudioIngles(audioFiles[i]);
								 	
						            nomeArquivoAudio = audioFiles[i].getName().substring(3);
				
						            nomeArquivoAudio = nomeArquivoAudio.substring(0,nomeArquivoAudio.indexOf(".mp3")).toUpperCase().trim();
						 
						            ArrayList<String> blocos = new ArrayList<String>();
						            
						            for (int j = linhaInicio ; j < linhaFim+1 ; j++) {
						            		
						            	String linhaTexto = lines[j].replaceAll("[^\\dA-Za-z ]", "").toUpperCase().trim();
						            	
						                if(linhaTexto.startsWith(nomeArquivoAudio)) {
						                	System.out.println(linhaTexto+"<-->"+nomeArquivoAudio);
						                	int k = j;
						                	while(!(lines[k].trim().length()<=0)) {
						                		//System.out.println(lines[k]);
						                		blocos.add(lines[k]);
						                		k++;
						                		
						                	}
						                	//System.out.println("--------");
						                	anki.setBlocos(blocos);
						                }	
						                
						            }
						            
						            listaTextoAnki.add(anki);
						
						    }
				
							 List<Anki> listAnki = new ArrayList<Anki>();
								 
							 
							 for(int i = 0; i < listaTextoAnki.size();i++) {
								 
								 Anki anki = listaTextoAnki.get(i);
								 
								 if (anki.getBlocos().size() % 2 == 0) {
								  
									 String textoIngles = "";
									 
									 for(int j = 0; j < (anki.getBlocos().size()/2); j++) {
									
										textoIngles = textoIngles + anki.getBlocos().get(j);
										 
									 }
									 
									 anki.setTextoIngles(textoIngles);
									 
									 String textoPortugues = "";
									 
									 for(int j = anki.getBlocos().size()/2; j < (anki.getBlocos().size()); j++) {
											
										 textoPortugues = textoPortugues + anki.getBlocos().get(j);
											 
									 }
									 
									 anki.setTextoPortugues(textoPortugues);
								  
								} else {
								  
									String textoIngles = "";
									String textoPortugues = "";
									
									if( anki.getBlocos().get(1).length() < anki.getBlocos().get(2).length()) {
				
										textoIngles = anki.getBlocos().get(0).concat(anki.getBlocos().get(1));
										textoPortugues = anki.getBlocos().get(2);
										
									}else {
													
										textoIngles = anki.getBlocos().get(0);
										textoPortugues = anki.getBlocos().get(1).concat(anki.getBlocos().get(2));
										
										
									}
									
									anki.setTextoIngles(textoIngles);
									anki.setTextoPortugues(textoPortugues);
								}

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
						
							 }	 
							 
							 System.out.print("FIM!");
							 
							 
				} catch (Exception e) {
			
					e.printStackTrace();
					
				}
			
			
			}
		
	
	}
	
	
}
