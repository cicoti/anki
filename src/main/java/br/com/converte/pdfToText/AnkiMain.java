package br.com.converte.pdfToText;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.TextPosition;

public class AnkiMain {

	public static void main(String[] args) throws IOException, InterruptedException {


		String indice = "07";
		String path = "C:\\Projetos\\automatizaranki\\The Boy Who Flew Too High\\";
		String pathAudio = "The Boy Who Flew "+indice+" Audios para o Anki\\The Boy Who Flew "+indice+" Audios Anki\\";
		String filePDFName = "PDF The Boy who Flew too High "+indice+".pdf";
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
            
		}    

		
		
		if (audioFiles.length > 0) {
			
			String nomeArquivoAudio = audioFiles[0].getName().substring(3);
			
			nomeArquivoAudio = nomeArquivoAudio.substring(0,nomeArquivoAudio.indexOf(".mp3")).toUpperCase();
			int linhaInicio = 0;
			int linhaFim = 0;
			
			for (int j = 0 ; j < lines.length ; j++) {
				
	             if(lines[j].toUpperCase().startsWith(nomeArquivoAudio)) {
	            	 linhaInicio = j;
	            	 break;
	             	
	             }	
	         }
			
			nomeArquivoAudio = audioFiles[audioFiles.length-1].getName().substring(3);
			
			nomeArquivoAudio = nomeArquivoAudio.substring(0,nomeArquivoAudio.indexOf(".mp3")).toUpperCase();
			
			for (int j = 0 ; j < lines.length ; j++) {
				
	             if(lines[j].toUpperCase().startsWith(nomeArquivoAudio)) {
	            	 linhaFim = j;
	            	 break;
	             	
	             }	
	         }
			 
			 Anki anki = null;
			 List<Anki> listaTextoAnki = new ArrayList<Anki>();
			 for (int i = 0; i < audioFiles.length; i++) {
		            
				 	anki = new Anki();
				 
				 	anki.setArquivoAudioIngles(audioFiles[i]);
				 	
		            nomeArquivoAudio = audioFiles[i].getName().substring(3);

		            nomeArquivoAudio = nomeArquivoAudio.substring(0,nomeArquivoAudio.indexOf(".mp3")).toUpperCase();
		 
		            ArrayList<String> blocos = new ArrayList<String>();
		            
		            for (int j = linhaInicio ; j < linhaFim+1 ; j++) {
		            		
		            	String linhaTexto = lines[j].replace("’","").replace(",", "").replace("\"", "");
			            	
		                if(linhaTexto.toUpperCase().startsWith(nomeArquivoAudio)) {
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

			 AnkiRobot ankiRobot = new AnkiRobot();
			 ankiRobot.abrirAplicacao();	
			 
			 for(int i = 0; i < listaTextoAnki.size();i++) {
				 
				 Anki a = listaTextoAnki.get(i);
				 
				 if (a.getBlocos().size() % 2 == 0) {
				  
					 String textoIngles = "";
					 
					 for(int j = 0; j < (a.getBlocos().size()/2); j++) {
					
						textoIngles = textoIngles + a.getBlocos().get(j);
						 
					 }
					 
					 a.setTextoIngles(textoIngles);
					 
					 String textoPortugues = "";
					 
					 for(int j = a.getBlocos().size()/2; j < (a.getBlocos().size()); j++) {
							
						 textoPortugues = textoPortugues + a.getBlocos().get(j);
							 
					 }
					 
					 a.setTextoPortugues(textoPortugues);
				  
				} else {
				  
					String textoIngles = "";
					String textoPortugues = "";
					
					if( a.getBlocos().get(1).length() < a.getBlocos().get(2).length()) {

						textoIngles = a.getBlocos().get(0).concat(a.getBlocos().get(1));
						textoPortugues = a.getBlocos().get(2);
						
					}else {
									
						textoIngles = a.getBlocos().get(0);
						textoPortugues = a.getBlocos().get(1).concat(a.getBlocos().get(2));
						
						
					}
					
					a.setTextoIngles(textoIngles);
					a.setTextoPortugues(textoPortugues);
				}
				 
				 
				 ankiRobot.fraseIngles(a.getTextoIngles());
				 ankiRobot.audioIngles(a.getArquivoAudioIngles());
				 ankiRobot.frasePortugues(a.getTextoPortugues());
				 
				 System.out.println("Audio: " + a.getArquivoAudioIngles());	 
				 System.out.println("Texto Ingles:" + a.getTextoIngles());
				 System.out.println("Texto Portugues:" + a.getTextoPortugues());
				 System.out.println("--------");
				 
			 }
			 
			 ankiRobot.fecharAdicionar();
			 ankiRobot.fecharAplicacao();
						
		}
		
		
	}
	
	
}
