
    import java.io.File;
    import javax.xml.parsers.SAXParser;
    import javax.xml.parsers.SAXParserFactory;
        
    public class SAX_departamentos{
    
       public static void main(String[] args) {
    
          try {
             File inputFile = new File("departamentos.xml");
             SAXParserFactory factory = SAXParserFactory.newInstance();
             SAXParser saxParser = factory.newSAXParser();
             DepartamentosHandler depthandler = new DepartamentosHandler();
             saxParser.parse(inputFile, depthandler);     
          } catch (Exception e) {
             e.printStackTrace();
          }
       }   
    }