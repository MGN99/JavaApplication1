package Dominio;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class puntoHandler extends DefaultHandler{
    private ArrayList<Punto> puntos =  new ArrayList();
    private Punto punto;
    private StringBuilder buffer = new StringBuilder();
    

    public ArrayList<Punto> getPuntos() {
        return puntos;
    }
    
    
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch,start,length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "osmid":
                punto.setId(buffer.toString());
                break;
            case "y":
                double valor = Double.parseDouble(buffer.toString());
                punto.setY(valor);
                break;
            case "x":
                double valor2 = Double.parseDouble(buffer.toString());
                punto.setX(valor2);
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "row":
                punto = new Punto();
                puntos.add(punto);
                break;
            case "osmid":
                buffer.delete(0, buffer.length());
                break;
            case "y":
                buffer.delete(0, buffer.length());
                break;
            case "x":
                buffer.delete(0, buffer.length());
                break;
            
        }
    }
  
}
