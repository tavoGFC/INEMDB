

/**
 * Clase para crear nodo
 * 
 * @author Gustavo Alonso Fallas Carrera
 *
 */
public class NodeRedBlack {
	NodeRedBlack left;
	NodeRedBlack right;	
	Object element;
	int color;
	
	public NodeRedBlack(Object value){
		this.element = value;
		left = null;
		right = null;
	}
	
	public NodeRedBlack(Object element, NodeRedBlack left, NodeRedBlack right){
		this.left = left;
		this.right = right;
		this.element = element;
		this.color = 1;  
	}
}
