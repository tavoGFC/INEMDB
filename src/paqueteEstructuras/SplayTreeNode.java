package paqueteEstructuras;

public class SplayTreeNode extends BSTNode {
    protected BSTNode parent;
    public SplayTreeNode() {
        left = right = parent = null;
    }
    /*
     * funcion que genera los nodos del arbol
     */
    public SplayTreeNode(Comparable el) {
        this(el,null,null,null);
    }
        public SplayTreeNode(Comparable ob, SplayTreeNode lt,
    SplayTreeNode rt, SplayTreeNode pr) {
        el = ob; left = lt; right = rt; parent = pr;
    }
}
