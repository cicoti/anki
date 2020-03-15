package br.com.anki;

import java.awt.AWTException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;

public class AnkiAutoMarkText {
	


	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		// TODO Auto-generated method stub

		int recomecar = -1;
		boolean isTeste = false;
		
		String path = "C:\\CursoInglesMairoVergara\\Textos Completos\\";
		
		String filePDFName = "02 - PDF Jack Hannaford.pdf";	
		//String filePDFName = "03 - PDF The Endless Tale.pdf";
		
		File filePDF = new File(path.concat(filePDFName));
		PDDocument documentPDF = PDDocument.load(filePDF);
		documentPDF.getClass();
	
		
		if (!documentPDF.isEncrypted()) {
			List<List<PDAnnotation>> la = new ArrayList<List<PDAnnotation>>();
			CustomPDFTextStripper stripper = new CustomPDFTextStripper();
			//System.out.println(stripper.getText(documentPDF));	
			PDDocumentCatalog catalog = documentPDF.getDocumentCatalog();
			PDPageTree pageTree = catalog.getPages();
			
			for(int i = 0; i < pageTree.getCount(); i++){
				PDPage page = (PDPage) catalog.getPages().get(i);
				la.add(page.getAnnotations());
			    if(la.size() < 1){
			      continue;
			    }
			}
				
			for(List<PDAnnotation> a : la) {
				for(PDAnnotation annotation : a) {
					try {
						
							String fraseIngles = (annotation.getContents()).toLowerCase().trim();
							String frases[] = fraseIngles.split("\n");
							for(int i = 0; i<frases.length;i++) {
								if(i % 2 == 0) {
									System.out.println(frases[i].concat("!"));
								}
							}
							
					}catch(Exception e) {
						
					}
				}
			}
			
			
			System.out.println("------------");
			
			List<Anki> listAnki = new ArrayList<Anki>();
			
			
			for(List<PDAnnotation> a : la) {
				for(PDAnnotation annotation : a) {
					try {
						
						String fraseIngles = (annotation.getContents()).toLowerCase().trim();
	
						System.out.println(fraseIngles);
						
						String frases[] = fraseIngles.split("\n");
						
						Anki anki = new Anki();
						for(int i = 0; i<frases.length;i++) {
							
							
							if(i % 2 == 0) {
								System.out.println(frases[i]);
								anki.setTextoIngles(frases[i].toLowerCase().trim());
								String fileName = frases[i].toLowerCase().trim().concat(".mp3");
								File file = new File("C:\\CursoInglesMairoVergara\\Textos Completos\\audio\\".concat(fileName.toLowerCase().trim()));
								if(!file.exists()) {
									//System.out.println(file.getAbsolutePath());
									throw new Exception("Arquivo não existe!");
								}else {
									anki.setArquivoAudioIngles(file);
									//System.out.println(file.getAbsolutePath());
								}
							}else {
								anki.setTextoPortugues(frases[i].toLowerCase().trim());
								//System.out.println(frases[i]);
							}
							
							
							
						}
						
						listAnki.add(anki);
											
						
					} catch (NullPointerException e) {
						//e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			
			
			
			if (!isTeste==true) {
				 
				 
				AnkiAuto ankiAuto = new AnkiAuto(2);
			 
				 for(Anki anki : listAnki) {
					 
					 int pos = listAnki.indexOf(anki);
					 System.out.println(pos);
					 if(pos>recomecar) {
						 System.out.println("Texto Ingles:" + anki.getTextoIngles());
						 System.out.println("Audio: " + anki.getArquivoAudioIngles());	
						 System.out.println("Texto Portugues:" + anki.getTextoPortugues());
						 System.out.println("--------");
						 
						 ankiAuto.fraseIngles(anki.getTextoIngles().concat(" "));
						 ankiAuto.audioIngles(anki.getArquivoAudioIngles());
						 ankiAuto.frasePortugues(anki.getTextoPortugues().concat(" "));
					 }	 
				 }
				 
				 ankiAuto.fecharAplicacao();
		
			 }	else {
				
				 for(Anki anki : listAnki) {
					  
					 int pos = listAnki.indexOf(anki);
					 System.out.println(pos);
					 if(pos>recomecar) {
						 System.out.println("Texto Ingles:" + anki.getTextoIngles());
						 System.out.println("Audio: " + anki.getArquivoAudioIngles());	
						 System.out.println("Texto Portugues:" + anki.getTextoPortugues());
						 System.out.println("--------");
					 }
				 }
				 
			 }
			 
			 System.out.println("FIM!");
			
		}
		
	}
	
	
	
	
}
