package paqueteEstructuras;

public class AVLTree
{
    private AVLNode root;     

    /**
     * Constructor de la clase AVLTree
     */
    public AVLTree()
    {
        root = null;
    }
    /**
     * VErifica si el arbol se encuentra vacio
     * @return true si esta vacio, false si no lo esta
     */
    public boolean isEmpty()
    {
        return root == null;
    }
    /**
     * hace al árbol lógicamente vacío, haciendo una referencia nula a la raíz
     */
    public void makeEmpty()
    {
        root = null;
    }
    /**
     * Recibe un elemento y lo inserta en el arbol
     * @param data
     */
    public void insert(int data)
    {
        root = insert(data, root);
    }
    /**
     * Retrona la altura del arbol
     * @param t
     * @return la altura
     */
    private int height(AVLNode t )
    {
        return t == null ? -1 : t.height;
    }
    /**
     * Retorna el maximo del hijo derecho o del izquierdo
     * @param lhs
     * @param rhs
     * @return Retorna el maximo del hijo derecho o del izquierdo
     */
    private int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }
    /**
     * Inserta los datos de manera recursiva
     * @param x
     * @param t
     * @return el nodo insertado
     */
    private AVLNode insert(int x, AVLNode t)
    {
        if (t == null)
            t = new AVLNode(x);
        else if (x < Integer.parseInt(t.element.toString()))
        {
            t.left = insert( x, t.left );
            if( height( t.left ) - height( t.right ) == 2 )
                if( x < Integer.parseInt(t.left.element.toString()) )
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
        }
        else if( x > Integer.parseInt(t.element.toString()) )
        {
            t.right = insert( x, t.right );
            if( height( t.right ) - height( t.left ) == 2 )
                if( x > Integer.parseInt(t.right.element.toString()))
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        else
          ;
        t.height = max( height( t.left ), height( t.right ) ) + 1;
        return t;
    }
    /**
     * realiza la rotacion para mantener el balance del arbol AVL con el hijo izquierdo     
     * @param k2
     * @return el arbol balanceado
     */
    private AVLNode rotateWithLeftChild(AVLNode k2)
    {
        AVLNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = max( height( k1.left ), k2.height ) + 1;
        return k1;
    }

    /**
     * realiza la rotacion para mantener el balance del arbol AVL con el hijo derecho
     * @param k1
     * @return el arbol balanceado
     */
    private AVLNode rotateWithRightChild(AVLNode k1)
    {
        AVLNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = max( height( k2.right ), k1.height ) + 1;
        return k2;
    }
    /**
     * realiza un doble rotacion, primero el hijo izquierdo con el hijo derecho y luego el nodo que se recibe con el hijo izquierdo.
     *  
     */
    private AVLNode doubleWithLeftChild(AVLNode k3)
    {
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }
    /**
    *
    *realiza un doble rotacion, primero el hijo izquierdo con el hijo derecho y luego el nodo que se recibe con el hijo derecho.
    */      
    private AVLNode doubleWithRightChild(AVLNode k1)
    {
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }    
    /**
     * Cuenta la cantidad de nodos en el arbol
     * @return la cantidad de nodos presentes en el arbol
     */
    public int countNodes()
    {
        return countNodes(root);
    }
    private int countNodes(AVLNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }
    /**
     * Realiza la busqueda del elemento ingresado
     * @param val
     * @return true si el elemento se encuentra y false si no
     */
    public boolean search(int val)
    {
        return search(root, val);
    }
    private boolean search(AVLNode r, int val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
            int rval = Integer.parseInt(r.element.toString());
            if (val < rval)
                r = r.left;
            else if (val > rval)
                r = r.right;
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
    /**
     * Imprime el arbol en orden
     */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(AVLNode r)
    {
        if (r != null)
        {
            inorder(r.left);
            System.out.print(r.element +" ");
            inorder(r.right);
        }
    }
    /**
     * Imprime el arbol en preorden
     */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(AVLNode r)
    {
        if (r != null)
        {
            System.out.print(r.element +" ");
            preorder(r.left);             
            preorder(r.right);
        }
    }
    /**
     * Imprime el arbol en un post orden 
     */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(AVLNode r)
    {
        if (r != null)
        {
            postorder(r.left);             
            postorder(r.right);
            System.out.print(r.element +" ");
        }
    }     
}
