# AutomatizacaoDoZero
Automatizando um site do começo ao fim utilizando Selenium com Java!

  <h1>BugBank Testes Automatizados</h1>
Este projeto contém testes automatizados para a aplicação web BugBank. Os testes foram escritos em Java, usando o framework JUnit e Selenium WebDriver.

 <h3>Instalação e Configuração</h3>
Antes de executar os testes, certifique-se de ter as seguintes ferramentas instaladas em seu ambiente:

    .Java JDK 8 ou superior
    .Maven
    .WebDriverManager
    
    
Certifique-se de que o ChromeDriver esteja instalado em seu sistema, ou então você pode utilizar o WebDriverManager para baixá-lo automaticamente no momento da execução dos testes.

<h3>Executando os Testes</h3>
Para executar todos os testes, execute o seguinte comando:


     > mvn test


Você também pode executar um teste específico usando o seguinte comando:


    > mvn -Dtest=<nome_do_teste> test


<h3>Estrutura do Projeto</h3>

<h5>src/main/java:</h5> Contém as classes de suporte para o teste automatizado.
<h5>src/test/java:</h5> Contém as classes de teste JUnit.
<h5>pom.xml: </h5>Contém as dependências do projeto e as configurações do Maven.

<h2>Autor</h2>

Este projeto foi criado por Lucas Brito. Se você tiver alguma dúvida ou sugestão, entre em contato através do Linkedin https://www.linkedin.com/in/lucasdebritonunes/
