package br.com.converte.pdfToText;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
public class AnkiRobot {
 public static void main(String args[]) {
	 
	boolean isFinish = false; 
	 
	while (!isFinish) {
		
		  try {
			  Thread.sleep(5000);
		  } catch (Exception e) {
			  
		  }
		
		 Robot bot = null;
		 int mask = InputEvent.BUTTON1_DOWN_MASK;
		   
		 try {
		   bot = new Robot();
		  } catch (Exception failed) {
		   System.err.println("Failed instantiating Robot: " + failed);
		  }  
	  		  		  
		  bot.keyPress(KeyEvent.VK_F5); 
		  bot.delay(400);
		  bot.keyRelease(KeyEvent.VK_F5); 
	 
		  try {
			  Thread.sleep(5000);
		  } catch (Exception e) {
			  
		  }
					  	  
		  
		  /* #1 */
		  
		  		  
		  bot.mouseMove(0,0);
		  
		 /* try {
			  Thread.sleep(3000);
		  } catch (Exception e) {
			  
		  }*/
		 
		  bot.delay(1000);
		  bot.mouseMove(912, 656);	
		  bot.delay(1000);
		  
		  isFinish = true;
				      
	}	  
		  
 }
 
 
 
 
}
