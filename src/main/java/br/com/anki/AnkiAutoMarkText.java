package br.com.anki;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;

public class AnkiAutoMarkText {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String path = "C:\\CursoInglesMairoVergara\\Textos Completos\\";
		String filePDFName = "02 - PDF Jack Hannaford.pdf";	
		
		File filePDF = new File(path.concat(filePDFName));
		PDDocument documentPDF = PDDocument.load(filePDF);
		documentPDF.getClass();
	
		
		if (!documentPDF.isEncrypted()) {
			List<PDAnnotation> la = new ArrayList<PDAnnotation>();
			CustomPDFTextStripper stripper = new CustomPDFTextStripper();
			PDDocumentCatalog catalog = documentPDF.getDocumentCatalog();
			PDPageTree pageTree = catalog.getPages();
			
			for(int i = 0; i < pageTree.getCount(); i++){
				PDPage page = (PDPage) catalog.getPages().get(i);
			     la = page.getAnnotations();
			    if(la.size() < 1){
			        continue;
			    }
			}
			
			for(PDAnnotation annotation : la) {
				try {
					System.out.println((annotation.getContents()).trim());
				} catch (Exception e) {
					
				}
			}
		}
		
	}

}
