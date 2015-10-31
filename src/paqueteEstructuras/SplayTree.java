package paqueteEstructuras;

public class SplayTree extends BST {
    public SplayTree() {
        super();
    }
    /*
     * formacion del arbol
     */
    private void continueRotation(BSTNode gr, BSTNode par,BSTNode ch, BSTNode desc) {
        if (gr != null) { // if par has a grandparent;
            if (gr.right == ((SplayTreeNode)ch).parent)
                gr.right = ch;
            else gr.left = ch;
        }
        else root = ch;
        if (desc != null)
            ((SplayTreeNode)desc).parent = par;
            ((SplayTreeNode)par).parent = ch;
            ((SplayTreeNode)ch).parent = gr;
        }
    	/*
    	 * funcion que hace rotacion hacia la derecha
    	 */
        private void rotateR(SplayTreeNode p) {
            p.parent.left = p.right;
            p.right = p.parent;
            continueRotation(((SplayTreeNode)p.parent).parent,p.right,p,p.right.left);
        }
        /*
         * funcion que hace rotacion hacia la izquierda
         */
        private void rotateL(SplayTreeNode p) {
            p.parent.right = p.left;
            p.left = p.parent;
            continueRotation(((SplayTreeNode)p.parent).parent,p.left,p,p.left.right);
        }
        private void semisplay(SplayTreeNode p) {
            while (p != root) {
                if (((SplayTreeNode)p.parent).parent == null) // if p'sparent is
                    if (p.parent.left == p) // the root;
                        rotateR(p);
                    else rotateL(p);
                else if (p.parent.left == p) // if p is a left child;
                    if (((SplayTreeNode)p.parent).parent.left == p.parent) {
                        rotateR((SplayTreeNode)p.parent);
                        p = (SplayTreeNode)p.parent;
                    }
                else {
                    rotateR((SplayTreeNode)p); // rotate p and itsparent;
                    rotateL((SplayTreeNode)p); // rotate p and its newparent;
                }
                else // if p is a right child;
            if (((SplayTreeNode)p.parent).parent.right == p.parent) {
                rotateL((SplayTreeNode)p.parent);
                p = (SplayTreeNode)p.parent;
            }
            else {
                rotateL(p); // rotate p and its parent;
                rotateR(p); // rotate p and its new
            } // parent;
            if (root == null) // update the root;
                root = p;
            }
    }
}