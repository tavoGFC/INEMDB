package paqueteEstructuras;

public class BSTNode {
	
    protected Comparable el;
    protected BSTNode left, right;
    public BSTNode() {
        left = right = null;
    }
    /*
     * funcion para formar el nodo del arbol
     */
    public BSTNode(Comparable el) {
        this(el,null,null);
    }
    /*
     * funcion que determina la posicion del nodo en el arbol
     */
    public BSTNode(Comparable el, BSTNode lt, BSTNode rt) {
        this.el = el; left = lt; right = rt;
    }
}