package api_interfaces;

import java.util.List;

/**
 * Interface para permitir o acesso a todos os metodos do mural.
 * @author Davi
 * @param <T> - Tipo do status.
 */
public interface WallMethodsInterface<T> {

	/**
	 * Retorna um status a partir do ID especificado.
	 * @param statusId - ID do status
	 * @return Um status
	 */
	public T getStatus(String statusId);

	/**
	 * Retorna as respostas de um status. � aplicado aos tipos Help e Activity.
	 * @param statusId - ID do status
	 * @return Uma lista de status
	 */
	public List<T> getAnswers(String statusId);

	/**
	 * Cria um status do tipo Answer em resposta a um Activity ou Help.
	 * @param statusId - [OBRIGAT�RIO] ID do status em quest�o. Somente do tipo Activity ou Help.
	 * @param text - [OBRIGAT�RIO] � uma resposta a um coment�rio ou um pedido de ajuda. M�ximo 800 caracteres
	 * @return O status criado
	 */
	public T postAnswer(String statusId, String text);

	/**
	 * Retorna todos os status do usu�rio. Tamb�m � poss�vel filtrar pelo tipo. Caso :type n�o seja informado 
	 * � retornado os status do tipo Activity, Help e Log do usu�rio.
	 * @param userId - [OBRIGAT�RIO] - ID do usu�rio em quest�o
	 * @param type - [OPCIONAL] - Filtragem pelo tipo de status. Pode ser do tipo Activity, Help ou Log
	 * @param page - [OPCIONAL] - Pagina��o dos resultados. As p�ginas possuem 25 entradas. Padr�o � 1. Num�rico
	 * @return Uma lista de Statuses
	 */
	public List<T> getStatusesByUser(String userId, String type, String page);

	/**
	 * Retorna todos os status do usu�rio. Tamb�m � poss�vel filtrar pelo tipo. 
	 * Caso :type n�o seja informado � retornado os status do tipo Activity, Help e Log do usu�rio.
	 * Retorna todos os status do usu�rio e dos cursos que o usu�rio faz parte. Diferente do getStatusesByUser, 
	 * aqui s�o mostradas todas as movimenta��es que interessam ao usu�rio. 
	 * � igual ao que se v� na p�gina inicial do Redu.
	 * @param userId - ID do usu�rio em quest�o
	 * @param type - [OPICIONAL] Filtragem pelo tipo de status. Pode ser do tipo Activity, Help ou Log
	 * @param page - [OPICIONAL] Pagina��o dos resultados. As p�ginas possuem 25 entradas. Padr�o � 1. Num�rico
	 * @return Uma lista de statuses
	 */
	public List<T> getStatusesTimelineByUser(String userId, String type, String page);


	/**
	 * Retorna todos os status da disciplina e das suas aulas. Diferente do getStatusesBySpace, 
	 * aqui s�o agregados tanto as postagens da disciplina quanto as das suas aulas. 
	 * � igual ao que se v� no mural da disciplina.
	 * @param spaceId - ID do space
	 * @param type - [OPICIONAL] Filtragem pelo tipo de status. Pode ser do tipo Activity, Help ou Log
	 * @param page - [OPICIONAL] Pagina��o dos resultados. As p�ginas possuem 25 entradas. Padr�o � 1. Num�rico
	 * @return Uma lista de statuses
	 */
	public List<T> getStatusesTimelineBySpace(String spaceId, String type, String page);


	/**
	 * Cria um status do tipo Activity no Mural do usu�rio.
	 * @param userId - ID do usu�rio em quest�o
	 * @param status - Conte�do do status. M�ximo 800 caracteres
	 * @return O status criado
	 */
	public T postStatusUser(String userId, String status);

	/**
	 * Retorna todos os status do mural de uma disciplina. H� possibilidade de 
	 * filtrar os status da disciplina pelo tipo. � importante preceber 
	 * que os posts listados aqui se limitam �queles postado diretamente na disciplina.
	 * @param spaceId - ID do space
	 * @param type - [OPICIONAL] Filtragem pelo tipo de status. Pode ser do tipo Activity, Help ou Log
	 * @param page - [OPICIONAL] Pagina��o dos resultados. As p�ginas possuem 25 entradas. Padr�o � 1. Num�rico
	 * @return Uma lista de statuses
	 */
	public List<T> getStatusesBySpace(String spaceId, String type, String page);

	/**
	 * Cria um status no Mural da disciplina.
	 * @param spaceId - ID do space em quest�o
	 * @param status - Conte�do do status. M�ximo 800 caracteres
	 * @return O status criado
	 */
	public T postStatusSpace(String spaceId, String text);


	/**
	 * Retorna todos os status do mural de uma aula. 
	 * @param lectureId - ID da lecture em quest�o
	 * @return Uma lista de statuses
	 */
	public List<T> getStatusesByLecture(String lectureId);

	/**
	 * Cria um status no Mural da aula. Somente neste caso � permitido criar um Help (pedido de ajuda).
	 * @param lectureId - ID da lecture em quest�o
	 * @param status - Conte�do do status. M�ximo 800 caracteres
	 * @param type - Tipo do status. Help
	 * @return o status criado
	 */
	public T postStatusLecture(String lectureId, String status, String type);

	/**
	 * Remove o status.
	 * @param statusId - ID do status
	 */
	public void deleteStatus(String statusId);

}
