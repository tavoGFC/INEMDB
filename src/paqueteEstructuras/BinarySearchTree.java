package paqueteEstructuras;


/**
 * Clase que realiza el Arbol binario de busqueda.
 * 
 * @author Gustavo Alonso Fallas Carrera
 *
 */
public class BinarySearchTree {
	public Node root;
	
	
	public BinarySearchTree(){
		this.root = null;
	}
	
	/**
	 * Metodo para buscar el valor en los nodos, true e impresion si esta, false si no esta.
	 * Necesita el metodo <<search(value, currentNode)>>
	 * 
	 * @param value , valor a buscar
	 * @return , <<true ^ valor encontrado>> o <<false ^ valor no esta>> 
	 */
	public boolean search(int value){
		System.out.println("Search data: " + value + " \n");
		if(value == root.data){
			System.out.println(value +" esta y es la raiz");
			return true;
		}
		else{
			return search(value, root);
		}
		
	}
	
	
	/**
	 * Metodo para realiar la busqueda del valor, corre los hijos,
	 * si el valor a buscar es menor al del nodo actual o si es mayor,
	 * recorre los nodos segun el valor.
	 * 
	 * @param value, valor a buscar
	 * @param currentNode, nodo actual por el que realiza las condiciones
	 * @return
	 */
	protected boolean search(int value, Node currentNode){
		Node leftChild = currentNode.left;
		Node rightChild = currentNode.right;
		
		if(value < currentNode.data){
			if(leftChild == null){
				System.out.println(value +" no esta");
				return false;
			}
			if(value == leftChild.data){
				System.out.println("Valor encontrado");
				return true;
			}
			else{
				search(value, leftChild);
			}
		}
		else if(value > currentNode.data){
			if(rightChild == null){
				System.out.println(value +" no esta");
				return false;
			}
			if(value == rightChild.data){
				System.out.println("Valor encontrado");
				return true;
			}
			else{
				search(value, rightChild);
			}
		}
		else {
			System.out.println(value +" no esta");
			return false;
		}
		return false;
	}
	
	
	/**
	 * Metodo para borrar nodo, marca el puntero sobre el nodo a borrar,
	 * obtiene el hijo derecho de ese nodo, a ese hijo derecho le obtiene el hijo izquierdo
	 * y realiza el borrado y el cambio de posicion, si el hijo derecho no tiene hijo izquierdo, se cambia por el
	 *  
	 * @param id, valor que tiene el nodo a borrar
	 * @return
	 */
	public boolean delete(int id){
		System.out.println("\n");
		System.out.println("Borrando: " + id);
		Node parentNode = root;
		Node currentNode = root;
		boolean isLeftChild = false;
		while(currentNode.data!=id){
			parentNode = currentNode;
			if(currentNode.data>id){
				isLeftChild = true;
				currentNode = currentNode.left;
			}else{
				isLeftChild = false;
				currentNode = currentNode.right;
			}
			if(currentNode ==null){
				return false;
			}
		}
		//if i am here that means we have found the node
		//Case 1: if node to be deleted has no children
		if(currentNode.left==null && currentNode.right==null){
			if(currentNode==root){
				root = null;
			}
			if(isLeftChild ==true){
				parentNode.left = null;
			}else{
				parentNode.right = null;
			}
		}
		//Case 2 : if node to be deleted has only one child
		else if(currentNode.right==null){
			if(currentNode==root){
				root = currentNode.left;
			}else if(isLeftChild){
				parentNode.left = currentNode.left;
			}else{
				parentNode.right = currentNode.left;
			}
		}
		else if(currentNode.left==null){
			if(currentNode==root){
				root = currentNode.right;
			}else if(isLeftChild){
				parentNode.left = currentNode.right;
			}else{
				parentNode.right = currentNode.right;
			}
		}else if(currentNode.left!=null && currentNode.right!=null){
			
			//now we have found the minimum element in the right sub tree
			Node successor	 = getSuccessor(currentNode);
			if(currentNode==root){
				root = successor;
			}else if(isLeftChild){
				parentNode.left = successor;
			}else{
				parentNode.right = successor;
			}			
			successor.left = currentNode.left;
		}		
		return true;		
	}
	
	
	/**
	 * Metodo que obtiene el elemento a ser cambiado
	 * 
	 * @param deleleNode, nodo a ser borrado
	 * @return, el nodo por el cual se cambiara el nodo borrado
	 */
	public Node getSuccessor(Node deleleNode){
		Node successsor =null;
		Node successsorParent =null;
		Node current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}
		
	
	/**
	 * Metodo para insertar el valor en el arbol, llama el metodo asociado insert(id, currentNode)
	 * 
	 * @param id, valor que se insertara en el arbol
	 */
	public void insert(int id){
		if(root == null){
			root = new Node(id);
		}
		else{
			insert(id, root);
		}
	}
	
	
	/**
	 * Metodo para insertar varlor, en el nodo.
	 * 
	 * @param id , valor a insertar
	 * @param currentNode , nodo en el cual se insertara
	 */
	private void insert(int id, Node currentNode){
		
		Node leftChild = currentNode.left;
		Node rightChild = currentNode.right;
		
		if(id < currentNode.data){
			if(leftChild == null){
				currentNode.left = new Node(id);
				System.out.println(String.format("leftChild: %s inserted. Parent: %s", currentNode.left.data, currentNode.data));
			}
			else{
				insert(id, leftChild);
			}
		}
		else if(id > currentNode.data){
			if(rightChild == null){
				currentNode.right = new Node(id);
				System.out.println(String.format("rightChild: %s inserted. Parent: %s", currentNode.right.data, currentNode.data));
			}
			else{
				insert(id, rightChild);
			}
		}
	
	}
	
	
	/**
	 * Metodo para mostrar en cosola, llama el metodo asociado display
	 */
	public void display(){
		if(root == null){
			System.out.println("Empty Tree");
		}
		else{
			display(1, root);
		}
		System.out.println("\n");
	}
	
	
	/**
	 * Metodo para mostrar en consola el arbol, la raiz se imprime en el medio,
	 * los hijos derechos arriba y los izquierdos abajo
	 * 
	 * @param count, cantidad de espacio para el nodo, 1 para la raiz
	 * @param currentNode, nodo que se imprimira
	 */
	protected void display(int count, Node currentNode){
		Node leftChild = currentNode.left;
		Node rightChild = currentNode.right;
		
		if(rightChild != null){
			display(count + 1, rightChild);
		}
	
		System.out.println(String.format(getTreeStringSeparator(count) + "%s", currentNode.data));
		
		if(leftChild != null){
			display(count + 1, leftChild);
		}
		
	}
	
	
	/**
	 * Metodo para contar los espacios
	 * @param count
	 * @return , el string con la cantidad de caracteres caracteres
	 */
	private String getTreeStringSeparator(int count){
		String countString = "";
		for(int i = 0; i < count; i++){
			countString += ".";
		}
		return countString + ""; 
	}
	
}
