package br.com.converte.pdfToText;

import java.awt.Color;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class AnkiRobot {
	
	Robot robot = null;
	int mask = InputEvent.BUTTON1_DOWN_MASK;
	Anki anki = null;
	
	public AnkiRobot() throws InterruptedException {
		
		 try {
			 robot = new Robot();
		  } catch (Exception failed) {
		   System.err.println("Failed instantiating Robot: " + failed);
		  }  
		
	}
	
	public void abrirAplicacao() throws InterruptedException {
		
		Thread.sleep(5000);
		
		// minimizar eclipse
		 robot.mouseMove(1806,10);
		 robot.delay(1000);
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 
		 robot.mouseMove(109, 343);	
		 robot.delay(1000);
		  
		 // first click
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 // second click
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 
		 Thread.sleep(5000);
		 
		 this.baralho();
		 this.menuAdicionar();
					 
		 
	}
	
	protected void baralho() {
		
		// click no nome do baralho.
		 //robot.delay(1000);
		 //robot.mouseMove(1500, 215);	
		robot.mouseMove(1500, 195);	
		robot.delay(1000);
		  
		 // first click
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 // second click
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 
		 
		
	}
	
	protected void menuAdicionar() {
		
		// click em adicionar.
		//robot.delay(1000);
		robot.mouseMove(1500, 120);	
		robot.delay(1000);
		  
		// first click
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
	}
	
	public void fraseIngles(String fraseIngles) {
		
		 //robot.delay(1000);
		 robot.mouseMove(1500, 315);	
		 robot.delay(1000);
		 
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 
		 copiarColar(fraseIngles);
	
	}
	
	public void audioIngles(File caminhoArquivo) {
		
		 //robot.delay(1000);
		 
		 robot.keyPress(KeyEvent.VK_F3);
		
		 //robot.delay(1000);
		 robot.mouseMove(1363, 643);	
		 robot.delay(1000);
		 
		 copiarColar(caminhoArquivo.getAbsolutePath());
		 
		 //robot.delay(1000);
		 robot.mouseMove(1750, 670);	
		 robot.delay(1000);
		 
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 
		 robot.delay(3000);
	
	}
	
	public void frasePortugues(String frasePortugues) {
		
		 //robot.delay(1000);
		 robot.mouseMove(1500, 410);	
		 Color pixelColor = robot.getPixelColor(1500, 410);
		 boolean isBlanc = false;
		 int i = 0;
		 int y = 0;
		 while(!isBlanc) {
			
			 System.out.println(" R: " + pixelColor.getRed() + " G: " + pixelColor.getGreen() + " B: " + pixelColor.getBlue());
			 
			 if(pixelColor.getRed() == 255 && pixelColor.getGreen() == 255 && pixelColor.getBlue() == 255) {
				 isBlanc = true;
			 }else {
				 i = i + 10;
				 y = 410 + i ;
				 robot.mouseMove(1500, y);
				 pixelColor = robot.getPixelColor(1500, y);
				 //robot.delay(1000);
			 }
			 
		 }
		 
		 robot.delay(1000);
		 
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		 copiarColar(frasePortugues);
		 
		 this.adicionarCartao();
		
	}
	
	protected void adicionarCartao() {
		
		 //robot.delay(1000);
		 robot.mouseMove(1555, 755);	
		 robot.delay(1000);
		 
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 
		// robot.delay(1000);
	
	}
	
	public void fecharAdicionar() {
		
		//robot.delay(1000);
		robot.mouseMove(1720, 756);	
		robot.delay(1000);
		 
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 
		//robot.delay(1000);
				
	}
	
	public void fecharAplicacao() {
		
		//robot.delay(1000);
		robot.mouseMove(1831, 70);	
		robot.delay(1000);
		 
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 
		//robot.delay(1000);
				
	}
	
	public void copiarColar(String frase) {
		 
		 StringSelection stringSelection = new StringSelection(frase);
		 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		 clipboard.setContents(stringSelection, stringSelection);

		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 
		 robot.delay(1000);
		
	}
		
	
}
