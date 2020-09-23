import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class DOM_escribir_departamentos {
    public static void main(String[] args) {
		//Creamos la factoría
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			//Creamos el builder
			DocumentBuilder builder = factory.newDocumentBuilder();
			//Cargamos el documento DOM de origen
			Document document = builder.parse(new File("departamentos.xml"));
          
            //Buscamos todos los nodos del documento correspondientes a localización
		    NodeList nl_localizacion = document.getElementsByTagName("LOCALIZACION");
            for(int i = 0; i<nl_localizacion.getLength(); i++) {
				Node loc = nl_localizacion.item(i);
				String localizacion = "";
                //Solo tendremos en cuenta los nodo tipo elemento, ya que text tambien son hijos
                if (loc.getNodeType()==Node.ELEMENT_NODE) {	
                    NodeList hijos = loc.getChildNodes();
                    for(int j = 0; j<hijos.getLength(); j++) {	
                        Node hijo = hijos.item(j);
                        if (hijo.getNodeType()==Node.ELEMENT_NODE) {	
							localizacion += hijo.getNodeName() + ": " + hijo.getTextContent() + " ";                        
							//Eliminamos el nodo hijo
							loc.removeChild(hijo);							
						}	
                    }
					//Añadimos el contenido nuevo
					loc.setTextContent(localizacion);
				}
            }	
		
			//Almacenamos el documento modificado como un nuevo archivo xml
			DOMSource fuente = new DOMSource(document);
			//Definimos el destino
			StreamResult resultado = new StreamResult(new java.io.File("departamentos_v2.xml"));
			//Creamos un transformador
			Transformer transformador = TransformerFactory.newInstance().newTransformer();
			//Escribimos en el archivo
			transformador.transform(fuente, resultado);
		}
        catch(Exception e) 
        {
            System.out.println("Excepción: "+e);
        }
	}
}