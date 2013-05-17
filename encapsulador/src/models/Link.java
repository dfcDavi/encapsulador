package models;

/**
 * Classe que representa um link. Assim como páginas na Web possuem links para outras páginas, 
 * os recursos da API do Redu possuem referências para outros recursos associados. Estas referências 
 * estão acessíveis através da propriedade 'links' nas representação do recurso. Esta funcionalidade 
 * torna possível que as aplicações que usam a API não precisem conhecer a priori todas as possíveis URLs.
 * @author Davi
 */
public class Link {
  
	//Atributos
	public String rel;
    public String href;

    @Override
    public String toString(){
        return String.format("rel: %s\nhref: %s", this.rel, this.href);
    }
}
