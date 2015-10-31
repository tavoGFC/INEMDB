import javax.xml.soap.Node;

public class RedBlackTree{
	private NodeRedBlack current;
    private NodeRedBlack parent;
    private NodeRedBlack grand;
    private NodeRedBlack great;
    private NodeRedBlack header;    
    private static NodeRedBlack nullNode;
    
    /* static initializer for nullNode */
    static { 
    	nullNode = new NodeRedBlack(0);
    	nullNode.left = nullNode;
    	nullNode.right = nullNode;
    }
    
    
    /* Black - 1  RED - 0 */
    static final int BLACK = 1;    
    static final int RED   = 0;

    
    /* Constructor */
    public RedBlackTree(int negInf){
        header = new NodeRedBlack(negInf);
        header.left = nullNode;
        header.right = nullNode;
    }
    
    
    /* Function to check if tree is empty */
    public boolean isEmpty(){
    	return header.right == nullNode;
    }
    
    
    /* Make the tree logically empty */
    public void makeEmpty(){
        header.right = nullNode;
    }
    
    /**
     * Method to insert item
     */
    public void insert(Object item){
    	 current = parent = grand = header;
         nullNode.element = item;
         while (current.element != item)
         {            
             great = grand; 
             grand = parent; 
             parent = current;
             if(current.left.color == RED && current.right.color == RED){
            	 handleReorient(item);
             }
         }
         if(current != nullNode)
        	 return;
         current = new NodeRedBlack(item, nullNode, nullNode);
         //attach to parent
         if(item.getClass().equals(java.lang.Integer.class))
        	 if((int)item < (int)parent.element)
        		 parent.left = current;
        	 else
        		 parent.right = current;
         handleReorient(item);
    }
    
    private void handleReorient(Object item){
    	// Do the color flip
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;

        if (parent.color == RED)   
        {
            // Have to rotate
        	grand.color = RED;
        	if(item.getClass().equals(java.lang.Integer.class))
        		if((int)item < (int)grand.element != (int)item < (int)parent.element)
        			parent = rotate(item, grand);
        		current = rotate(item, great);
        		current.color = BLACK;
        }
        //Make root black
        header.right.color = BLACK;
   
    }
    
    private NodeRedBlack rotate(Object item, NodeRedBlack parent){
    	if((int)item < (int)parent.element)
            return parent.left = (int)item < (int)parent.left.element ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;  
        else
            return parent.right = (int)item < (int)parent.right.element ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);  
    }
    
    /**
     * Rotate binary tree node with left child
     */
    private NodeRedBlack rotateWithLeftChild(NodeRedBlack k2){
    	NodeRedBlack k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }
    
    
    /**
     * Rotate binary tree node with right child
     */
    private NodeRedBlack rotateWithRightChild(NodeRedBlack k1){
    	NodeRedBlack k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }
    
    /**
     * Count number of nodes
     */
    public int countNodes(){
    	return countNodes(header.right);
    }
    
    private int countNodes(NodeRedBlack r){
    	if(r == nullNode)
    		return 0;
    	else{
    		int count = 1;
    		count += countNodes(r.left);
    		count += countNodes(r.right);
    		return count;
    	}
    }
    
    
    /**
     * Search for an element
     */
    public boolean search(Object value){
    	return search(header.right, value);
    }
    
    private boolean search(NodeRedBlack r, Object value){
    	boolean found = false;
    	while((r != nullNode) && !found){
    		int rval = (int)r.element;
    		if((int)(value) < rval)
    			r = r.left;
    		else if((int)value > rval)
    			r = r.right;
    		else{
    			found = true;
    			break;
    		}
    		found = search(r, value);
    	}
    	return found;
    }
    
    
    /* Function for inorder traversal */ 
    public void inorder(){
        inorder(header.right);
    }
    
    private void inorder(NodeRedBlack r){
        if (r != nullNode){
        	inorder(r.left);
            char c = 'B';
            if (r.color == 0)
                c = 'R';
            System.out.print(r.element +""+c+" ");
            inorder(r.right);
        }
    }
    
    
    /* Function for preorder traversal */
    public void preorder(){
        preorder(header.right);
    }
    
    private void preorder(NodeRedBlack r){
        if (r != nullNode){
            char c = 'B';
            if (r.color == 0)
                c = 'R';
            System.out.print(r.element +""+c+" ");
            preorder(r.left);             
            preorder(r.right);
        }
    }
    
    
    /* Function for postorder traversal */
    public void postorder(){
        postorder(header.right);
    }
    
    private void postorder(NodeRedBlack r){
        if (r != nullNode){
            postorder(r.left);             
            postorder(r.right);
            char c = 'B';
            if (r.color == 0)
                c = 'R';
            System.out.print(r.element +""+c+" ");
        }
    }
    
}//final class

