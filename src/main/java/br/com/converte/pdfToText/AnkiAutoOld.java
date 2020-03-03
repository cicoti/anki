package br.com.converte.pdfToText;

//netstat -a -n -o | findstr 9999
//Taskkill /PID 17100 /F

/**
 * Created by Maor on 19/03/2018.
 * Refer to https://github.com/2gis/Winium.Desktop
 */

import static java.util.concurrent.TimeUnit.SECONDS;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.Point;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

public class AnkiAutoOld {
	
	DesktopOptions options;
	WiniumDriverService service;
	WiniumDriver driver;
	
	public static void main(String args[]) throws InterruptedException, IOException, AWTException {
		
		AnkiAutoOld ankiAuto = new AnkiAutoOld();
		ankiAuto.setUp();
		ankiAuto.baralho();
		//ankiAuto.tearDown();
		
		
	}
    
    public void setUp(){
		options = new DesktopOptions();
		options.setApplicationPath("C:\\Program Files (x86)\\Anki\\anki.exe");
		File driverPath = new File("C:\\Projetos\\automatizaranki\\Winium.Desktop.Driver.exe");
		//File driverPath = new File("..\\Winium.Desktop.Driver.exe");
		service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
		try {
			service.start();
		} catch (IOException e) {
			System.out.println("Exception while starting WINIUM service");
			e.printStackTrace();
		}
		driver = new WiniumDriver(service,options);
	}
    
    //CursoInglesMairoVergadaV2
    
    public void baralho() throws InterruptedException, IOException, AWTException {
    	Thread.sleep(5000);
    	WiniumDriver driver = new WiniumDriver(new URL("http://127.0.0.1:9999"), options);
        Thread.sleep(5000);
        driver.findElementByName("Adicionar").click();
        Thread.sleep(5000);
        driver.findElementByName("CursoInglesMairoVergara").click();
        Thread.sleep(5000);
        driver.findElementByName("Front").sendKeys("Winium is fun.");
    	
    }
    
    public void adicionar() throws InterruptedException, IOException {
    	
    	
    }

    /*public void calcAddition() throws InterruptedException, IOException {
        WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), options);
        SECONDS.sleep(2);
        driver.findElementById("num8Button").click();
        driver.findElementById("plusButton").click();
        driver.findElementById("num8Button").click();
        driver.findElementById("equalButton").click();
        String output = driver.findElementById("CalculatorResults").getAttribute("Name");
        System.out.println("Result is: " + output);
        SECONDS.sleep(3);
        driver.findElementById("Close").click(); 
    }

    public void calcMultiply () throws InterruptedException, IOException {
        WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), options);
        SECONDS.sleep(2);
        driver.findElementById("num8Button").click();
        driver.findElementById("multiplyButton").click();
        driver.findElementById("num8Button").click();
        driver.findElementById("equalButton").click();
        String output = driver.findElementById("CalculatorResults").getAttribute("Name");
        System.out.println("Result is: " + output);
        SECONDS.sleep(3);
        driver.findElementById("Close").click();
    }*/

    public void tearDown() {
    	driver.close();
    	service.stop();
    }
    

}