package awtgl.map;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import awtgl.math.Vector2i;

public class TMXMap {
    
    private Vector2i pos = new Vector2i(0);
    private Vector2i size;
    private Vector2i tiledSize;
    private String map;
    private File tmxFile;

    public void setFile(String file) {

        this.tmxFile = new File(file);

    }



    private void parseFile() throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(this.tmxFile);
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("data");

        this.size = new Vector2i(
            
            Integer.parseInt(nodeList.item(0).getAttributes().getNamedItem("width").getNodeValue()),
            Integer.parseInt(nodeList.item(0).getAttributes().getNamedItem("height").getNodeValue())

        );

        this.tiledSize = new Vector2i(
            
            Integer.parseInt(nodeList.item(0).getAttributes().getNamedItem("tiledwidth").getNodeValue()),
            Integer.parseInt(nodeList.item(0).getAttributes().getNamedItem("tiledheight").getNodeValue())

        );
        
    }



    public void createMap() throws ParserConfigurationException, SAXException, IOException {

        this.parseFile();

        int x;
        int y;

        for (y = 0; y < lines.length; y++) {
            
            for (x = 0; x < lines.length; x++) {
            
            

            }

        }

    }

}
