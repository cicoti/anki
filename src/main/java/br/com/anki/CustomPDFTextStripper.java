package br.com.anki;

import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

class CustomPDFTextStripper extends PDFTextStripper
	{
	    //Vector<Vector<List<TextPosition>>> data = new Vector<Vector<List<TextPosition>>>();
	    public CustomPDFTextStripper() throws IOException {
	        super();
	    }

	    public List<List<TextPosition>> getCharactersByArticle(){
	       // data.add(charactersByArticle);
	        return charactersByArticle;
	    }
	}