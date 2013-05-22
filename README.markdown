<h1>Encapsulador</h1>

<p>Este pacote desenvolvido em JAVA encapsula todas as funcionalidades de mural da api do Redu  e abstrai detalhes de rede na comunicação.</p>

<h2>Um breve começo</h2>

<p>Inicie criando um novo objeto management, fornecendo seu consumer token e secret token:.</p>

```java
Management management = new Management("yourconsumerkey", "yoursecretkey");
```

<p>Adquira o seu pin de autenticação e inicie o cliente.</p>

```java
Scanner in = new Scanner(System.in);
System.out.println("Visit this url: "+management.getAuthorizeUrl());
System.out.println("Enter your pin:");
String pin = in.nextLine();
management.initClient(pin);
```

<p>Teste a autenticação conforme abaixo e obtenha as informações do seu login:</p>

```java
System.out.println(management.getMe());
```

<p>*Atenção:

Só é preciso pedir o pin uma vez por usuário, depois de adquirido basta iniciar o client dessa maneira:</p>

```java
Management management = new Management("yourconsumerkey", "yoursecretkey", "yourpin");
```

<h2>Alguns exemplos de uso das funcionalidades</h2>

<p>Uma vez que tenha em mãos o objeto de manipulação (management), você está pronto pra utilizar todas as funcionalidades
que este encapsulador lhe proporciona, através de chamada aos métodos desejados.</p>

<p>Abaixo segue um exemplo de como listar todos os status de um espaço. Atente ao fato de que é possível passar argumentos opcionais como Null.</p>

```java
List<Status> wall = management.getStatusesBySpace("id da disciplina que voce possua acesso", "Log", null);
  	for(Status post : wall){
			System.out.println(post);
		}
```
<p>Criando um post no mural do usuário.</p>

```java
Status post = management.postStatusUser("id do usuário em questão", "Conteúdo do status");
  System.out.println(post);
```

<p>Respondendo um post.</p>

```java
Status answer = management.postAnswer("id do status em questão (somente do tipo Activity ou Help)", "Resposta ao comentário ou pedido de ajuda");
  System.out.println(answer);
```

<h2>Como contribuir</h2>

1. Faça fork do projeto
2. Crie um novo branch (`git checkout -b my-new-feature`)
3. Realize seus commits (`git commit -am 'Add some feature'`)
4. Dê push nas modificações (`git push origin my-new-feature`)
5. Envie um pull request

<h2>Copyright</h2>

<p>Copyright (c) 2013 Redu Educational Technologies</p>

<p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:</p>

<p>The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.</p>

<p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.</p>

