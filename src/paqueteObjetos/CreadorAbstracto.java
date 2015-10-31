package paqueteObjetos;


/**
 * 
 * @author Kevin
 *
 */
public abstract class CreadorAbstracto {
	/**
	 * Es la base para el creador concreto
	 * @param nombre un String con la clase que se desee crear
	 * @return Un objeto creado en la clase CreadorConcreto
	 */
	public abstract Object factoryMethod(String nombre);


}
