package models;

import java.util.List;

/***
 * Classe que representar um usuário do Redu. É importante notar que ela não contém todos os
 * atributos da especificação por questões de simplificação e evitar excesso de informações
 * não requisitadas pela especificação do encapsulador.
 * @author Davi
 */
public class User {
	
	//Atributos
    public String login;
    public String mobile;
    public String email;
    public String localization;
    public int friends_count;
    public int id;
    public String first_name;
    public String last_name;
    public String birthday;
    public String birth_localization;
    public List<Link> links;

    @Override
    public String toString(){

        String retorno = String.format("login: %s\nmobile: %s\nemail: %s\nlocalization: %s\nfriends_count: %s\nid: %s\n" +
                "name: %s %s\nbirthday: %s\nbirth_localization: %s\nlinks: %s",
                this.login, this.mobile, this.email, this.localization, this.friends_count,this.id, this.first_name, this.last_name,this.birthday,
                this.birth_localization,this.links);

        return retorno;
    }
}
