package Dominio;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class lineaHandler extends DefaultHandler{
    private ArrayList<Punto> puntos = new ArrayList();
    private ArrayList<Linea> lineas = new ArrayList<Linea>();
    private Linea linea;
    private StringBuilder buffer = new StringBuilder();

    public void setPuntos(ArrayList<Punto> puntos) {
        this.puntos = puntos;
    }

    public ArrayList<Linea> getLineas() {
        return lineas;
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch,start,length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "u":
                Punto p = buscarP(buffer.toString());
                linea.setP1(p);
                break;
            case "v":
                Punto pp = buscarP(buffer.toString());
                linea.setP2(pp);
                break;
            case "osmid":
                linea.setId(buffer.toString());
                break;
            case "name":
                linea.setNombre(buffer.toString());
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "edge":
                linea = new Linea();
                lineas.add(linea);
                break;
            case "u":
                buffer.delete(0, buffer.length());
                break;
            case "v":
                buffer.delete(0, buffer.length());
                break;
            case "osmid":
                buffer.delete(0, buffer.length());
                break;
            case "name":
                buffer.delete(0, buffer.length());
                break;
            
            
        }
    }
    
    public Punto buscarP(String id){
        
        for(Punto p: puntos){
            if(p.getId().equals(id)){
                return p;
            }              
        }
        
        return null;
    }
    
}
