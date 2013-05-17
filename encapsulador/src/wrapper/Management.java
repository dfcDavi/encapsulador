package wrapper;

import http.HttpClient;
import http.ImplementedHttpClient;
import http.PairKeyAndValue;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.Status;
import models.StatusPayload;
import models.User;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import api_interfaces.ReduInterface;

/**Classe responsável por manipular e gerenciar as funcionalidades do encapsulador.
 * Esta classe implementa a interface ReduInterface.
 * @author Davi
 * @param <T> - Tipo de status (Exemplo: Activity,Help,Answer,Log)
 */
public class Management<T> implements ReduInterface<T> {

	//Atributos
	private HttpClient httpClient;
	private final String BASE_URL="http://www.redu.com.br/api/";
	private Gson gson;

	protected Type statusList = new TypeToken<List<Status>>() {}.getType();;	

	protected Class<T> statusClass = (Class<T>) Status.class;
	private Class<T> userClass = (Class<T>) User.class;

	public Management(String consumerKey, String consumerSecret) {

		this.gson = new Gson();
		this.httpClient = new ImplementedHttpClient(consumerKey, consumerSecret);

	}

	public Management(String consumerKey, String consumerSecret, String pin) {

		this.gson = new Gson();
		this.httpClient = new ImplementedHttpClient(consumerKey, consumerSecret, pin);
	}

	/**
	 * Obtém a url de autorização
	 */
	public String getAuthorizeUrl(){

		return this.httpClient.getAuthUrl();

	}

	/**
	 * Inicializa o cliente http a partir de um pin fornecido
	 * @param pin - Corresponde ao pin
	 */
	public void initClient(String pin){

		this.httpClient.initClient(pin);

	}

	//Métodos para obter a Url

	private <T> T getUrl(String url, Class<T> classOfT){
		String json = this.httpClient.get(url);
		T retorno = this.gson.fromJson(json, classOfT);
		return retorno;
	}

	private <T> T getUrl(String url, Class<T> classOfT, Map.Entry<String, String>... args){
		String json = this.httpClient.get(url, args);
		T retorno = this.gson.fromJson(json, classOfT);
		return retorno;
	}

	private <T> T getUrl(String url, Type typeOfT, Map.Entry<String, String>... args){
		List<Map.Entry<String, String>> new_args = new ArrayList<Map.Entry<String, String>>();
		for(Map.Entry<String, String> o : args){
			if(o.getValue() != null){
				new_args.add(o);
			}
		}
		String json = "";
		if(!new_args.isEmpty()){
			json = this.httpClient.get(url, new_args.toArray(new PairKeyAndValue[args.length]));
		}else{
			json = this.httpClient.get(url);
		}
		T retorno = this.gson.fromJson(json, typeOfT);
		return retorno;
	}

	private <T> T getUrl(String url, Type typeOfT){
		String json = this.httpClient.get(url);
		T retorno = this.gson.fromJson(json, typeOfT);
		return retorno;
	}

	//Método para dar um Post Url

	private <T> T postUrl(String url, Class<T> classOfT, String payload, Map.Entry<String, String>... args){
		String json = this.httpClient.post(url, payload.getBytes(), args);
		T retorno = this.gson.fromJson(json, classOfT);
		return retorno;
	}

	/**
	 *Obtém as informações do usuário 
	 */
	public T getMe() {
		return this.getUrl(BASE_URL+"me", this.userClass);
	}

	//Os métodos abaixo representam as principais funcionalidades do encapsulador que cobre a postagem de informações 
	//no mural do Usuário, Disciplina e Aula, além de fornecer métodos para a visualização e listagem.
	//Para detalhes, basta pousar o mouse sobre a assinatura do método.

	@Override
	public T getStatus(String statusId) {
		return this.getUrl(BASE_URL+"statuses/"+statusId, this.statusClass);
	}

	@Override
	public List<T> getAnswers(String statusId) {
		return this.getUrl(BASE_URL+"statuses/"+statusId+"/answers",this.statusList);
	}

	@Override
	public T postAnswer(String statusId, String text) {
		StatusPayload load = new StatusPayload(text);
		String url = BASE_URL+"statuses/"+statusId+"/answers";
		String json = this.gson.toJson(load);
		return this.postUrl(url, this.statusClass, json);
	}

	@Override
	public List<T> getStatusesByUser(String userId, String type, String page) {
		Map.Entry<String, String> arg = new PairKeyAndValue("type", type);
		Map.Entry<String, String> arg1 = new PairKeyAndValue("page", page);
		return this.getUrl(BASE_URL+"users/"+userId+"/statuses", this.statusList, arg, arg1);
	}

	@Override
	public List<T> getStatusesTimelineByUser(String userId, String type,
			String page) {
		Map.Entry<String, String> arg = new PairKeyAndValue("type", type);
		Map.Entry<String, String> arg1 = new PairKeyAndValue("page", String.valueOf(page));
		return this.getUrl(BASE_URL+"users/"+userId+"/statuses/timeline", this.statusList, arg, arg1);
	}

	@Override
	public List<T> getStatusesTimelineBySpace(String spaceId, String type,
			String page) {
		Map.Entry<String, String> arg = new PairKeyAndValue("type", type);
		Map.Entry<String, String> arg1 = new PairKeyAndValue("page", type);
		return this.getUrl(BASE_URL+"spaces/"+spaceId+"/statuses/timeline", this.statusList, arg, arg1);
	}

	@Override
	public T postStatusUser(String userId, String status) {
		StatusPayload load = new StatusPayload(status);
		String url = BASE_URL+"users/"+userId+"/statuses";
		String json = this.gson.toJson(load);
		return this.postUrl(url, this.statusClass, json);
	}

	@Override
	public List<T> getStatusesBySpace(String spaceId, String type, String page) {
		Map.Entry<String, String> arg = new PairKeyAndValue("type", type);
		Map.Entry<String, String> arg1 = new PairKeyAndValue("page", type);
		return this.getUrl(BASE_URL+"spaces/"+spaceId+"/statuses", this.statusList, arg, arg1);
	}

	@Override
	public T postStatusSpace(String spaceId, String text) {
		StatusPayload load = new StatusPayload(text);
		String url = BASE_URL+"spaces/"+spaceId+"/statuses";
		String json = this.gson.toJson(load);
		return this.postUrl(url, this.statusClass, json);
	}

	@Override
	public List<T> getStatusesByLecture(String lectureId) {
		return this.getUrl(BASE_URL+"lectures/"+lectureId+"/statuses", this.statusList);
	}

	@Override
	public T postStatusLecture(String lectureId, String status, String type) {
		StatusPayload load = new StatusPayload(status, type);
		String url = BASE_URL+"lectures/"+lectureId+"/statuses";
		String json = this.gson.toJson(load);
		return this.postUrl(url, this.statusClass, json);
	}

	@Override
	public void deleteStatus(String statusId) {
		this.httpClient.delete(BASE_URL+"statuses/"+statusId);
	}

}