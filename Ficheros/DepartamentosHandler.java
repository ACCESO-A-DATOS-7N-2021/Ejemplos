import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DepartamentosHandler extends DefaultHandler{
    private int nivel = 0;
    private String[] decorador = {"","--- ","--- --- ","--- --- --- ", "--- --- --- --- "};

    @Override
    public void startElement(String uri, 
    String localName, String qName, Attributes attributes) throws SAXException {
        nivel ++;
        System.out.print(decorador[nivel]+qName);
    }

    @Override
   public void endElement(String uri, 
   String localName, String qName) throws SAXException {
        nivel --;
    }
 
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        String texto = new String(ch, start, length).trim();
        if (texto.length() > 0){
            System.out.println(": " + texto);
        } 
        else {
            System.out.println("");
        }
    }
    
}