package br.com.converte.pdfToText;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
public class AnkiRobotOld {
 public static void main(String args[]) {
	 
	boolean isFinish = false; 
	 
	while (!isFinish) {
		
		  try {
			  Thread.sleep(5000);
		  } catch (Exception e) {
			  
		  }
		
		 Robot robot = null;
		 int mask = InputEvent.BUTTON1_DOWN_MASK;
		   
		 try {
			 robot = new Robot();
		  } catch (Exception failed) {
		   System.err.println("Failed instantiating Robot: " + failed);
		  }  
	  		  		  

	 
		  try {
			  Thread.sleep(5000);
		  } catch (Exception e) {
			  
		  }
					  	  
		  
		  /* #1 */
		  
		  		  
		  robot.mouseMove(0,0);
		  
		 /* try {
			  Thread.sleep(3000);
		  } catch (Exception e) {
			  
		  }*/
		 
		  robot.delay(1000);
		  robot.mouseMove(109, 343);	
		  robot.delay(1000);
		  
		 // first click
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 // second click
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 
		 try {
			  Thread.sleep(5000);
		  } catch (Exception e) {
			  
		  }
		 
		 robot.delay(1000);
		 robot.mouseMove(1500, 215);	
		 robot.delay(1000);
		  
		 // first click
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 // second click
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 
		 robot.delay(1000);
		 robot.mouseMove(1500, 120);	
		 robot.delay(1000);
		  
		 // first click
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 
		 robot.delay(1000);
		 robot.mouseMove(1500, 315);	
		 robot.delay(1000);
		  
		 // ingles
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 
		 String text = "Do not fly too low or your wings will get wet from the waves,";
		 StringSelection stringSelection = new StringSelection(text);
		 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		 clipboard.setContents(stringSelection, stringSelection);

		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_CONTROL);

		 // audio
		 robot.delay(1000);
		 
		 robot.keyPress(KeyEvent.VK_F3);
		 robot.delay(1000);
		 robot.mouseMove(1363, 643);	
		 robot.delay(1000);
		 
		 text = "C:\\Projetos\\automatizaranki\\The Boy Who Flew Too High\\The Boy Who Flew 05 Audios para o Anki\\The Boy Who Flew 05 Audios Anki\\48 Do not fly.mp3";
		 stringSelection = new StringSelection(text);
		 clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		 clipboard.setContents(stringSelection, stringSelection);

		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 
		 robot.delay(1000);
		 robot.mouseMove(1750, 670);	
		 robot.delay(1000);
		 
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 
		 // portugues
		 
		 robot.delay(1000);
		 robot.mouseMove(1500, 415);	
		 robot.delay(1000);
		 
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 
		 text = "Não voe muito baixo ou suas asas ficarão molhadas com as ondas,";
		 stringSelection = new StringSelection(text);
		 clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		 clipboard.setContents(stringSelection, stringSelection);

		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 
		 // adicionar
		 
		 robot.delay(1000);
		 robot.mouseMove(1555, 755);	
		 robot.delay(1000);
		 
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 
		  
		  isFinish = true;
				      
	}	  
		  
 }
 
 
 
 
}
