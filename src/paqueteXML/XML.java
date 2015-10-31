package paqueteXML;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class XML {
	
    String nombreXML;
    Document documento;
    //Main Node
    Element raiz;
    
    /**
     * contructor de la clase
     * @param name: string con el nombre del archivo XML
     */

    public XML(String name){
    	try{
            this.nombreXML=name;
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			
            DOMImplementation implementation = builder.getDOMImplementation();
            documento = implementation.createDocument(null, nombreXML, null);
            documento.setXmlVersion("1.0");
            
            this.raiz = documento.getDocumentElement();
//            cerrarXML();
    	}
    	catch (ParserConfigurationException e) {
			e.printStackTrace();
			System.out.println("ERROR al crear el documento xml");
		}
                
    }
    
    /**
     * funcion que se encarga de cerrar el archivo XML cuando se termina de añadir informacion
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    
    public void cerrarXML() throws TransformerConfigurationException, TransformerException{
        //Generate XML
        DOMSource source = new DOMSource(documento);
        //Indicamos donde lo queremos almacenar
        Result result = new StreamResult(new java.io.File(nombreXML+".xml")); //nombre del archivo
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
        
        transformer.transform(source, result);
            
}
}