package br.com.anki;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnaliseTextoContaPalavras {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String path = "D:\\silvio\\projetos\\AutomatizarAnki\\git\\anki\\src\\resource\\CursoInglesMairoVergara\\Mar\\2 - Dead to Me\\Season 2";
		//String fileTXTName = "\\Dead to Me - 1x07 - I Can Handle It.HDTV.AMRAP.en.srt";
		String fileTXTName = "\\1.srt";

		Path pathFileTXT = Paths.get(path.concat(fileTXTName));
		byte[] bytes = Files.readAllBytes(pathFileTXT);
		List<String> allLines = Files.readAllLines(pathFileTXT);
		int j = 1;
		boolean show = true;
		int i = 1;
		String linhaUnica = "";
		for(String linha : allLines) {

			linha = "".concat(linha);

			if(linha.contentEquals("9999")) {
				break;
			}

			show = true;


			if(linha.contains("-->")) {
				show = false;
			} else if(linha.contains("color=")) {
				show = false;
			} else if (linha.isEmpty()) {
				show = false;
			} else {

				try {

					i = Integer.parseInt(linha.trim());

				}catch(Exception e) {
					//e.printStackTrace();
				}


				if(i == j) {
					show = false;
					j++;
				}

			}

			if(show) {
				//System.out.print(linha+" ");
				//sb.append(linha);
				linhaUnica = linhaUnica + linha + " ";

			}

		}

		ArrayList<String> palavrasTexto = new ArrayList<String>();
		String[] palavras = linhaUnica.split(" ");
		String[] palavrasUnicas = new String[palavras.length];
		String palavra = "";
		for(i = 0;i<palavras.length;i++) {
			palavra = palavras[i];
			palavra = palavra.replace("\"", "");
			palavra = palavra.replace("!", "");
			palavra = palavra.replace("?", "");
			palavra = palavra.replace(",", "");
		    palavra = palavra.replace(".", "");
		    palavra = palavra.replace("&", "");
		    palavra = palavra.replace("[", "");
		    palavra = palavra.replace("]", "");
		    palavra = palavra.replace("<i>", "");
		    palavra = palavra.replace("</i>", "");
		    palavra = palavra.toLowerCase();
			//System.out.println(palavra);
		    //palavrasTexto.add(palavra);
		    //palavrasUnicas[i] = palavra;
		   // System.out.println(palavra);
		}


		Long qtd = 0L;
		Map<String, Long> p = new HashMap<String, Long>();
		p.put("teste", ++qtd);
		if(p.get("teste") != null) {
			qtd = p.get("teste");
			p.put("teste",++qtd);
		}
		if(p.get("teste") != null) {
			qtd = p.get("teste");
			System.out.println(qtd);
		}

	}

}
