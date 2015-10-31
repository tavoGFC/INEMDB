package paqueteXML;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import paqueteLista.Lista;
import paqueteLista.Nodo;

public class XMLdatos extends XML {
	Document documento;
	Element raiz;
	
	/**
	 * esta funcion se encarga de crear un XML que almacena
	 * los datos ingresados por el cliente
	 * @param name
	 */
	
	public XMLdatos(String nombreXML) {
		super(nombreXML);
		//Obtenemos la referencia al documento que queremos modificar
		this.documento = super.documento;
		
		//Obtiene el elemento raíz del documento
		this.raiz = super.raiz; 
	}
	
	
	public void añadirDatos(Lista lista) throws TransformerConfigurationException, TransformerException{
		Nodo dato = lista.head;
		for(int i = 0; i < lista.CantNodos(); i++){
			Element datoEl = documento.createElement(dato.toString());
			
			raiz.appendChild(datoEl);
			
			if(dato == lista.tail){
				return;
			}
			dato = dato.sig;
			
		}
		cerrarXML();
	}

}
