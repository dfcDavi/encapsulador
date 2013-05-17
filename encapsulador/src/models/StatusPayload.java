package models;

/**
 *Classe que representa um status payload. 
 * @author Davi
 */
public class StatusPayload {

	//Atributo
	In status;

	public StatusPayload(String text){
		this.status = new In(text);
	}

	public StatusPayload(String text, String type){
		this.status = new In(text, type);
	}

	class In{
		String text;
		String type;
		public In(String text){
			this.text = text;
		}
		public In(String text, String type){
			this.text = text;
			this.type = type;
		}
	}
}