package exercise1;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class Main {

    public static void main(String[] args) {
        try {
            File inputFile = new File("D:/OneDrive - Escuela Politécnica Nacional/Curso Information Retriviel/indexing-program/src/exercise1/09-Text_Only-Ascii-Coll-2001-5000-NoSem.txt");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            Element classElement = document.getRootElement();
            List<Element> docsList = classElement.getChildren();
            String strnroDoc;
            String texDoc;
            Map<String,Map<String,Integer>> compMap = new TreeMap<>();
            Map<String,Integer> docsMap;


            int cont;
            String str=" ";
            for (int temp = 0; temp < docsList.size(); temp++) {
                Element doc = docsList.get(temp);
                strnroDoc = doc.getChild("docno").getText();
                texDoc = doc.getText();
                StringTokenizer tokens = new StringTokenizer(texDoc, " " + "’"+ "\n");
                while (tokens.hasMoreTokens()) {
                    docsMap = new HashMap<>();
                    cont = 0;
                    str = tokens.nextToken().toLowerCase();
                    if (str.equals("s")) str = "is";
                    if (!compMap.containsKey(str)) {
                            cont++;
                            docsMap.put(strnroDoc,cont);
                            compMap.put(str,docsMap);
                    } else {
                         //Poner el nuevo hashMap de docs actualizado
                        if(!compMap.get(str).containsKey(strnroDoc)){//Verificar que no haya los docs repetidos y lo ponemos
                            //Agregar el documento
                            cont++;
                            compMap.get(str).put(strnroDoc,cont);
                        }else{

                            cont = compMap.get(str).get(strnroDoc) + 1;
                            compMap.get(str).put(strnroDoc,cont);
                        }
                    }
                }
            }



            Iterator<String> it2 = compMap.keySet().iterator();
            while(it2.hasNext()){
                String key = (String) it2.next();
                System.out.println("Word: " + key + " -> Doc: " + compMap.get(key));
            }


        } catch(JDOMException e) {
            e.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

