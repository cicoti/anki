package br.com.anki;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

public class TesteAnkiAuto {
	
	Robot robot = null;
	DesktopOptions options;
	WiniumDriverService service;
	WiniumDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		
		AnkiAuto ankiAuto = new AnkiAuto();
		 
		 Thread.sleep(8000);
		 
		 File file = new File("C:\\CursoInglesMairoVergara\\5 - The Boy Who Flew Too High\\The Boy Who Flew 01 Audios Anki\\01 The underground paths.mp3");
		
		 ankiAuto.fraseIngles("CAR ");
		 ankiAuto.audioIngles(file);
		 ankiAuto.frasePortugues("CARRO ");
		 ankiAuto.fecharAplicacao();
		 
		 ankiAuto.tearDown();
		
	}
    

}
