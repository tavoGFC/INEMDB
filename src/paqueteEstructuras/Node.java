package paqueteEstructuras;

/**
 * Clase para crear nodo
 * 
 * @author Gustavo Alonso Fallas Carrera
 *
 */
public class Node {
	int data;
	Node left;
	Node right;	
	public Object element;
	
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}
