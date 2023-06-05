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

import awtgl.entity.Entity;
import awtgl.entity.EntityGroup;
import awtgl.entity.tile.Tile;
import awtgl.math.Vector2i;

public class TMXMap {
    
    private Vector2i pos = new Vector2i(0);
    private Vector2i size;
    private Vector2i tiledSize;
    private String map;
    private File tmxFile;

    private void parseFile() throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(this.tmxFile);
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getChildNodes();

        this.map = document.getElementsByTagName("data").item(0).getTextContent();
        System.out.println(this.map);

        this.size = new Vector2i(
            
            Integer.parseInt(nodeList.item(0).getAttributes().getNamedItem("width").getNodeValue()),
            Integer.parseInt(nodeList.item(0).getAttributes().getNamedItem("height").getNodeValue())

        );

        this.tiledSize = new Vector2i(
            
            Integer.parseInt(nodeList.item(0).getAttributes().getNamedItem("tilewidth").getNodeValue()),
            Integer.parseInt(nodeList.item(0).getAttributes().getNamedItem("tileheight").getNodeValue())

        );
        
    }



    public EntityGroup<Entity> createMap() {

        try {

            this.parseFile();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            
            e.printStackTrace();

        }

        int x;
        int y;

        EntityGroup<Entity> entities = new EntityGroup<Entity>() {};

        for (y = 0; y < this.tiledSize.y; y++) {
            
            for (x = 0; x < this.tiledSize.x; x++) {

                System.out.println(Integer.parseInt(this.map.split("\n")[y].replace(",", "").charAt(x) + ""));
            
                // Tile newTile = new Tile(Integer.parseInt(this.map.split("\n")[y].charAt(x) + ""));
                // newTile.setPos(new Vector2i(x, y));

                // entities.add(newTile);

            }

        }

        return entities;

    }



    public Vector2i getPos() {
        return pos;
    }



    public void setPos(Vector2i pos) {
        this.pos = pos;
    }



    public Vector2i getSize() {
        return size;
    }



    public void setSize(Vector2i size) {
        this.size = size;
    }



    public Vector2i getTiledSize() {
        return tiledSize;
    }



    public void setTiledSize(Vector2i tiledSize) {
        this.tiledSize = tiledSize;
    }



    public String getMap() {
        return map;
    }



    public void setMap(String map) {
        this.map = map;
    }



    public File getTmxFile() {
        return tmxFile;
    }



    public void setTmxFile(File tmxFile) {
        this.tmxFile = tmxFile;
    }

}
