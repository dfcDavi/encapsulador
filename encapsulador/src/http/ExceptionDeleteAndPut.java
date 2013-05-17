package http;

/**
 * Classe que representa uma exce��o na implementa��o dos m�todos de delete e put.
 * @author Davi
 */
public class ExceptionDeleteAndPut extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private int statusCode;

	public ExceptionDeleteAndPut(String error, int statusCode){
		super(error);
	}

	public int getStatusCode(){
		return this.statusCode;
	}
}