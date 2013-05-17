package models;

/**
 * Classe que representa um link. Assim como p�ginas na Web possuem links para outras p�ginas, 
 * os recursos da API do Redu possuem refer�ncias para outros recursos associados. Estas refer�ncias 
 * est�o acess�veis atrav�s da propriedade 'links' nas representa��o do recurso. Esta funcionalidade 
 * torna poss�vel que as aplica��es que usam a API n�o precisem conhecer a priori todas as poss�veis URLs.
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
