package http;

import java.util.Map;

/**
 * Classe abstrata que representa um cliente Http.
 * @author Davi
 */
public abstract class HttpClient {

	//Atributos
	protected String consumerKey;
	protected String consumerSecret;

	public HttpClient(String consumerKey, String consumerSecret){
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}

	//As assinaturas abaixo correspondem a m�todos dispon�veis para um cliente http
	//As retic�ncias representam um array de par�metros opcionais
	
	public abstract void initClient(String accessToken);

	public abstract String getAuthUrl();

	public abstract String get(String url, Map.Entry<String, String>... params);

	public abstract String post(String url,Map.Entry<String, String>... params);

	public abstract String post(String url, byte[] payload, Map.Entry<String, String>... params);

	public abstract void delete(String url, Map.Entry<String, String>... params);

	public abstract void put(String url,byte[] payload,  Map.Entry<String, String>... params);
}
