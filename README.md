Encapsulador
============

Encapsuladores (para APIs REST), também conhecidos como wrappers, são bibliotecas que abstraem detalhes de rede na comunicação com serviços terceiros.

Por exemplo, para criar um post no mural de um usuário no Redu é necessário realizar uma requisição HTTP do tipo POST para a URL http://redu.com.br/api/users/:user_id/statuses passando-se como payload o seguinte json:

{ "status": { "text": "Meu novo post" } }

Tendo em mãos um encapsulador na linguagem Ruby, como é o caso deste, o trabalho seria feito da seguinte forma:

client.create_post(:user => 12, :text => "Meu novo post")

Não são necessários conhecimentos sobre requisições HTTP enviadas, pois o encapsulador abstrai os detalhes. Toda a interação é feita através de invocação de métodos e inicialização de objetos.
