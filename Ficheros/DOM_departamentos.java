import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOM_departamentos {
    public static void main(String[] args) {
		//Creamos la factoría
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			//Creamos el builder
			DocumentBuilder builder = factory.newDocumentBuilder();
			//Creamos el documento DOM
			Document document = builder.parse(new File("departamentos.xml"));
            
            //Mostramos de forma jerárquica el documento
            
            //Extraemos todos los nodos del documento de nivel 1
		    NodeList nl1 = document.getChildNodes();
            for(int i = 0; i<nl1.getLength(); i++) {
    			Node n1 = nl1.item(i);
                //Solo tendremos en cuenta los nodo tipo elemento, ya que text tambien son hijos
                if (n1.getNodeType()==Node.ELEMENT_NODE) {	
                    System.out.print("--- ");
                    System.out.println(n1.getNodeName());
                    NodeList nl2 = n1.getChildNodes();
                    for(int j = 0; j<nl2.getLength(); j++) {	
                        //extraemos un node de segundo nivel (dep_row)
                        Node n2 = nl2.item(j);
                        if (n2.getNodeType()==Node.ELEMENT_NODE) {	
                            System.out.print("--- --- ");
                            System.out.println(n2.getNodeName());
                        
                            NodeList nl3 = n2.getChildNodes();
                            for (int k = 0; k<nl3.getLength();k++){
                                //extraemos un node de tercer nivel (datos dentro de dep_row)
                                Node n3 = nl3.item(k);
                                if (n3.getNodeType()==Node.ELEMENT_NODE) {	
                                    System.out.print("--- --- --- ");
                                    System.out.print(n3.getNodeName());
                                    System.out.print(": ");
                                    System.out.println(n3.getTextContent());
                                }
                            }
                        
                        }
                    }
                }
            }	
		}
        catch(Exception e) 
        {
            System.out.println("Excepción: "+e);
        }
	}
}
