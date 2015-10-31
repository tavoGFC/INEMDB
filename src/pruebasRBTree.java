import java.util.Scanner;

public class pruebasRBTree {
	public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	RedBlackTree rbt = new RedBlackTree(0);
	char ch;
	
	/*  Perform tree operations  */
    do    
    {
        System.out.println("\nRed Black Tree Operations\n");
        System.out.println("1. insert ");
        System.out.println("2. search");
        System.out.println("3. count nodes");
        System.out.println("4. check empty");
        System.out.println("5. clear tree");

        int choice = scan.nextInt();            
        switch (choice)
        {
        case 1 : 
            System.out.println("Enter integer element to insert");
            rbt.insert( scan.nextInt() );                     
            break;                          
        case 2 : 
            System.out.println("Enter integer element to search");
            System.out.println("Search result : "+ rbt.search( scan.nextInt() ));
            break;                                          
        case 3 : 
            System.out.println("Nodes = "+ rbt.countNodes());
            break;     
        case 4 : 
            System.out.println("Empty status = "+ rbt.isEmpty());
            break;     
        case 5 : 
            System.out.println("\nTree Cleared");
            rbt.makeEmpty();
            break;         
        default : 
            System.out.println("Wrong Entry \n ");
            break;    
        }
        /*  Display tree  */
        System.out.print("\nPost order : ");
        rbt.postorder();
        System.out.print("\nPre order : ");
        rbt.preorder();
        System.out.print("\nIn order : ");
        rbt.inorder(); 

        System.out.println("\nDo you want to continue (Type y or n) \n");
        ch = scan.next().charAt(0);                        
    } while (ch == 'Y'|| ch == 'y');
    
	}
	
}
