package paqueteEstructuras;

/**
 * Clase para crear nodo
 * 
 * @author Gustavo Alonso Fallas Carrera
 *
 */
public class BinarySearchNode {
	int data;
	BinarySearchNode left;
	BinarySearchNode right;	
	public Object element;
	
	public BinarySearchNode(int data){
		this.data = data;
		left = null;
		right = null;
	}
}
