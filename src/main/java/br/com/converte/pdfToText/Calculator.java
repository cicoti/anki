package br.com.converte.pdfToText;


/**
 * Created by Maor on 19/03/2018.
 * Refer to https://github.com/2gis/Winium.Desktop
 */

import static java.util.concurrent.TimeUnit.SECONDS;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class Calculator {
	
	public static void main(String args[]) throws InterruptedException, IOException {
		
		Calculator calculator = new Calculator();
		calculator.setUp();
		calculator.calcAddition();
		calculator.setUp();
		calculator.calcMultiply();
		
	}
	
    public DesktopOptions options = new DesktopOptions();

    public void setUp() throws InterruptedException, IOException {
        options.setApplicationPath("C:\\Windows\\System32\\calc.exe");
    }

    public void calcAddition() throws InterruptedException, IOException {
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
    }

}