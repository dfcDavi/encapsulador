package models;

import java.util.List;

/**
 * Classe que representa um status, isto é, qualquer elemento mostrado no Mural.
 * @author Davi
 *
 */
public class Status {
	
	//Atributos
	public int id;
    public String type;
    public String created_at;
    public String text;
    public User user;
    public List<Link> links;

    @Override
    public String toString(){
        return String.format("id: %s\ntype: %s\ncreated_at: %s\ntext: %s\nuser: %s\nlinks: %s",
                this.id, this.type, this.created_at, this.text, this.user, this.links);
    }

}