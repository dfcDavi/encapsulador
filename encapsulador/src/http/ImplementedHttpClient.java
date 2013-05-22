package http;

import org.scribe.model.*;
import org.scribe.oauth.OAuthService;
import org.scribe.builder.ServiceBuilder;
import java.util.Map;

/**
 *Classe que extende e implementa os métodos da classe abstrata HttpClient e 
 *contém o token de acesso e serviço do protocolo de autenticação.  
 * @author Davi
 */
public class ImplementedHttpClient extends HttpClient {

	//Atributos
	private OAuthService service;
	private Token accessToken;

	public ImplementedHttpClient(String consumerKey, String consumerSecret){
		super(consumerKey, consumerSecret);
		this.initOauth();

	}

	public ImplementedHttpClient(String consumerKey, String consumerSecret, String pin){
		super(consumerKey, consumerSecret);
		this.initOauth();
		this.accessToken = this.service.getAccessToken(null, new Verifier(pin));
	}

	/**
	 * Método que inicia o serviço do protocolo de autenticação
	 */
	private void initOauth(){
		this.service = new ServiceBuilder().provider(ReduOauth2.class)
				.apiKey(this.consumerKey).apiSecret(this.consumerSecret).callback("").build();

	}

	/**
	 * Método que adiciona os parâmetros da url 
	 * @param request - Requisição ao protocolo OAuth
	 * @param params - Parâmetros da url
	 */
	private void addUrlParams(OAuthRequest request, Map.Entry<String, String>... params){
		for (Map.Entry<String, String> pair : params){
			request.addQuerystringParameter(pair.getKey(), pair.getValue());
		}
	}

	/**
	 * Método que adiciona os parâmetros do body
	 * @param request - Requisição ao protocolo OAuth
	 * @param params - Parâmetros do body
	 */
	private void addBodyParams(OAuthRequest request, Map.Entry<String, String>... params){
		for(Map.Entry<String, String> pair : params){
			request.addBodyParameter(pair.getKey(), pair.getValue());
		}
	}

	//Abaixo seguem as implementações dos métodos especificados na classe abstrata HttpClient

	@Override
	public void initClient(String pin) {
		Verifier v = new Verifier(pin);
		this.accessToken = this.service.getAccessToken(null, v);
	}

	@Override
	public String getAuthUrl() {
		return this.service.getAuthorizationUrl(null);
	}

	@Override
	public String get(String url, Map.Entry<String, String>... params) {

		Response r = null;

		try{

			OAuthRequest request = new OAuthRequest(Verb.GET, url);
			if(params != null){
				this.addUrlParams(request, params);
			}
			this.service.signRequest(this.accessToken, request);
			r = request.send();

		}catch(Exception e){
			e.printStackTrace();
		}
		return r.getBody();
	}

	@Override
	public String post(String url, Map.Entry<String, String>... params) {

		Response r = null;

		try{

			OAuthRequest request = new OAuthRequest(Verb.POST, url);
			if(params != null){
				this.addBodyParams(request, params);
			}
			this.service.signRequest(this.accessToken, request);
			r = request.send();

		}catch(Exception e){
			e.printStackTrace();
		}
		return r.getBody();  
	}

	@Override
	public String post(String url, byte[] payload, Map.Entry<String, String>... params) {

		Response r = null;

		try{

			OAuthRequest request = new OAuthRequest(Verb.POST, url);
			if(params != null){
				this.addBodyParams(request, params);
			}

			request.addPayload(payload);

			request.addHeader("Content-Type", "application/json");
			this.service.signRequest(this.accessToken, request);
			r = request.send();

		}catch(Exception e){
			e.printStackTrace();
		}
		return r.getBody();
	}

	@Override
	public void delete(String url, Map.Entry<String, String>... params) {
		OAuthRequest request = new OAuthRequest(Verb.DELETE, url);
		if(params != null){
			this.addUrlParams(request, params);
		}
		this.service.signRequest(this.accessToken, request);
		Response r = request.send();
		if (!(r.getCode() == 200)){
			throw new ExceptionDeleteAndPut("Invalid return code", r.getCode());
		}
	}

	@Override
	public void put(String url,byte[] payload, Map.Entry<String, String>... params) {
		OAuthRequest request = new OAuthRequest(Verb.PUT, url);
		if(params != null){
			this.addBodyParams(request, params);
		}
		request.addPayload(payload);
		request.addHeader("Content-Type", "application/json");
		this.service.signRequest(this.accessToken, request);
		Response r = request.send();
		if(!(r.getCode() == 200)){
			throw new ExceptionDeleteAndPut("Invalid return code", r.getCode());
		}

	}

}
