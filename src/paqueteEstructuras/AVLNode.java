package paqueteEstructuras;

/**
 * 
 * @author Kevin
 *
 */
public class AVLNode {
	/**
	 * Atributos de la clase AVLNode
	 */
	Object element;
	AVLNode left;
	AVLNode right;
	int height;
	
	/**
	 * Constructor de la clase
	 * @param element
	 */
	public AVLNode(Object element){
		this(element,null,null);
	}
	public AVLNode(Object element,AVLNode left, AVLNode right){
		this.element=element;
		this.right=right;
		this.left=left;
		this.height=0;
	}
}
