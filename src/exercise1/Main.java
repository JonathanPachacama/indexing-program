package exercise1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Main {
	
	 public static void main(String[] args) {

	        try {
	            File inputFile = new File("D:/OneDrive - Escuela Politécnica Nacional/Curso Information Retriviel/indexing-program/src/exercise1/document.txt");
	            
	            
	            SAXBuilder saxBuilder = new SAXBuilder();
	            Document document = saxBuilder.build(inputFile);
	            Element classElement = document.getRootElement();
	            List<Element> docsList = classElement.getChildren();


	            String strnroDoc;
	            String texDoc;
	            List<String> listWords = new ArrayList<String>();
	            List<String> listWordsRep = new ArrayList<String>();
	            List<DocText> objsDocs = new ArrayList<>();
	            String str=" ";



	            for (int temp = 0; temp < docsList.size(); temp++) {
	                DocText objdt = new DocText();
	                Element doc = docsList.get(temp);
	                strnroDoc = doc.getChild("docno").getText();
	                texDoc = doc.getText();
	                StringTokenizer tokens = new StringTokenizer(texDoc, " ");
	                while (tokens.hasMoreTokens()) {
	                  //  System.out.println("while");
	                    str = tokens.nextToken();
	                    if (objsDocs.size() > 0) {
	                        for (int i = 0; i<objsDocs.size(); i++) {

	                            //System.out.println(objsDocs.get(i).getPalabra() + " "+ str);
	                            //System.out.println(objsDocs.size());

	                            if (objsDocs.get(i).getPalabra().equals(str)) {
	                                System.out.println("Entro");
	                                objsDocs.get(i).setFrecuencia(objsDocs.get(i).getFrecuencia() + 1);
	                                objsDocs.get(i).setListDocs(objsDocs.get(i).getListDocs() + " " + strnroDoc);
	                                break;
	                            } else if (i == objsDocs.size() - 1) {
	                                System.out.println("entro e ingresa " + str + " con el contador " + i);
	                                objdt.setPalabra(str);
	                                objdt.setFrecuencia(objdt.getFrecuencia() + 1);
	                                objdt.setListDocs(strnroDoc);
	                                objsDocs.add(objdt);
	                                break;
	                            }


	                        }
	                    }else{
	                        objdt.setPalabra(str);
	                        objdt.setFrecuencia(objdt.getFrecuencia() + 1);
	                        objdt.setListDocs(strnroDoc);
	                        objsDocs.add(objdt);
	                    }
	                }
	            }


	            System.out.println(objsDocs.size() + "\n" + objsDocs.get(3).getPalabra());

	          /*          if (!listWords.contains(str)) {
	                        listWords.add(str);
	                        objdt.setPalabra(str);
	                    }
	                    listWordsRep.add(str);
	                }
	            }

	            Collections.sort(listWords);
	            for (int i =0; i<listWordsRep.size(); i++){
	                System.out.println(listWordsRep.get(i));
	            }*/



	        } catch(JDOMException e) {
	            e.printStackTrace();
	        } catch(IOException ioe) {
	            ioe.printStackTrace();
	        }
	    }

}

