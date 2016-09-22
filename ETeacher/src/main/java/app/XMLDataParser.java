/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author grze
 */
public class XMLDataParser {
    
    
    public static List<String> getWordsList(String chapter) {
        
        List<String> list = new ArrayList<>();
        
        Document doc = null;
        File xmlFile = new File("src/main/resources/xml/data.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

        } catch (ParserConfigurationException | SAXException | IOException e) {
        }

        NodeList nodeList = doc.getElementsByTagName("chapter");

        for (int i = 0; i < nodeList.getLength(); i++) {

            String s = nodeList.item(i).getAttributes().getNamedItem("id").getNodeValue();
            if (s.equals(chapter)) {

                NodeList childList = nodeList.item(i).getChildNodes();

                for (int j = 0; j < childList.getLength(); j++) {

                    Node child = childList.item(j);

                    if ("word".equals(child.getNodeName())) {
                        list.add(child.getTextContent());
                    }

                }

            }

        }
        
        return list;
        
    }
    
    
}
