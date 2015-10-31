package paqueteObjetos;

public class Scheme  extends CreadorAbstracto{
	
	String nombreEstructura;
	Object tipo;
	ObjectLong largo;
	@Override
	public Object factoryMethod(String tipo) {
		// TODO Auto-generated method stub
		Object objeto = null;
    	
    	switch(tipo){
    		
    		case "int": objeto =new ObjectInt();
    		break;
    		
    		case "string": objeto =new ObjectString();
    		break;
    		
    		case "float": objeto =new ObjectFloat();
    		break;

    		case "long": objeto =new ObjectLong();
    		break;
    		
    		case "double": objeto =new ObjectDouble();
    		break;
    		
    		case "image": objeto =new ObjectImage();
    		break;
    		
    		case "binary": objeto =new ObjectBinary();
    		break;
    		
    		case "video": objeto =new ObjectVideo();
    		break;
    		
    		case "join": objeto =new ObjectJoin();
    		break;
    	
    		
    	}
    	return objeto;

	}
}
