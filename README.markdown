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

<p>Uma vez que tenha em mãos o objeto de manipulação (management), você está pronto pra utilizar todas as funcionalidades
que este encapsulador lhe proporciona, através de chamada aos métodos desejados.</p>

<h2>Como contribuir</h2>

<p>1-Implementar este encapsulador em outras linguagens de programação e disponibilizar no github.com;</p>
<p>2-Dar commit em possíveis melhorias encontradas para este encapsulador;</p>
<p>3-Realizar testes apurados para todas as funcionalidades de mural;</p>
<p>4-Extender o encapsulador para outras funcionalidades.</p>

<h2>Copyright</h2>

<p>Copyright (c) 2013 Redu Educational Technologies</p>

<p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:</p>

<p>The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.</p>

<p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.</p>

