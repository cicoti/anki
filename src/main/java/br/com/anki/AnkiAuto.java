package br.com.anki;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

public class AnkiAuto {
	
	Robot robot = null;
	DesktopOptions options;
	WiniumDriverService service;
	WiniumDriver driver;
	
	/*
	 * public static void main(String args[]) throws InterruptedException,
	 * IOException, AWTException {
	 * 
	 * AnkiAuto ankiAuto = new AnkiAuto(); 
	 * ankiAuto.setUp(); 
	 * ankiAuto.baralho();
	 * ankiAuto.tearDown();
	 * 
	 * System.out.println("FIM!");
	 * 
	 * }
	 */
    
	public AnkiAuto() throws InterruptedException, IOException, AWTException {
		
		this.setUp();
		this.baralho();
				
	}
	
    public void setUp() throws IOException, InterruptedException{
		
    	this.tearDown();
    	
    	options = new DesktopOptions();
		options.setApplicationPath("C:\\Program Files (x86)\\Anki\\anki.exe");
		
		File driverPath = new File("C:\\Projetos\\automatizaranki\\Winium.Desktop.Driver.exe");
		//File driverPath = new File("..\\Winium.Desktop.Driver.exe");
		service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999).withVerbose(true).withSilent(true).buildDesktopService();
		
		try {
			service.start();
		} catch (IOException e) {
			System.out.println("Exception while starting WINIUM service");
			e.printStackTrace();
		}
		
		
		driver = new WiniumDriver(service,options);
		
		 try {
			 
			 robot = new Robot();
			 
		  } catch (Exception failed) {
		   System.err.println("Failed instantiating Robot: " + failed);
		  }  
		 
		 
		 
	}
    
    protected void baralho() throws InterruptedException, IOException, AWTException {
    	WiniumDriver driver = new WiniumDriver(new URL("http://127.0.0.1:9999"), options);
        Thread.sleep(10000);
        
        /*
        // baralho master
        robot.keyPress(KeyEvent.VK_TAB);
        */
        
        
        // baralho v2
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        
                       
        Thread.sleep(1000);
        
        // Executar baralho
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_A);

    }
    
	public void fraseIngles(String fraseIngles) throws InterruptedException {
		 
		//robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
		 copiarColar(fraseIngles);
	
	}
	
	public void audioIngles(File caminhoArquivo) throws InterruptedException {
		 
		Thread.sleep(2000);
		 robot.keyPress(KeyEvent.VK_F3);
		 driver.findElementByName("Nome").click();
		 copiarColar(caminhoArquivo.getAbsolutePath());
		 robot.keyPress(KeyEvent.VK_ENTER);
	     
	}
	
	public void frasePortugues(String frasePortugues) throws InterruptedException {
				
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		copiarColar(frasePortugues);
	    adicionarCartao();
		
	}
	
	protected void adicionarCartao() throws InterruptedException {
		
		Thread.sleep(2000); 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);

	
	}
	
	public void fecharAplicacao() throws InterruptedException, IOException {
		
		Thread.sleep(1000);
		driver.findElementByName("Fechar").click();
		Thread.sleep(1000);
		driver.findElementById("Close").click();
		
		this.tearDown();
				
	}
	
	public void copiarColar(String frase) {
		 
		 StringSelection stringSelection = new StringSelection(frase);
		 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		 clipboard.setContents(stringSelection, stringSelection);
		 
		 robot.delay(1000);
		 robot.keyPress(KeyEvent.VK_CONTROL); 
		 robot.keyPress(KeyEvent.VK_V);
		 robot.delay(1000);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
		
		
	}

    public void tearDown() throws IOException, InterruptedException {
    	
    	Process process = Runtime.getRuntime().exec("TASKKILL /F /IM Winium.Desktop.Driver.exe");
		process.waitFor();
		if(process.isAlive()) {
			process.destroy();
		}
    	
    }
    

}