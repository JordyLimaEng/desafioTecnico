# Desafio Técnico - Backend

Procurou-se atender os requisitos da documentação.

A API foi desenvolvida em JAVA utilizando do Framework Spring e respectivas dependências.

# Rodando a aplicação

Foi gerado um .jar (que pode ser baixado [aqui](https://drive.google.com/file/d/1HuHVz3bFRFipTx-0xQmodl6hw1bXRcRL/view?usp=sharing))

* No diretório onde baixou o arquivo, descompactar e executar o comando:
  
<pre><code>$ java -jar desafioTecnico-0.0.1-SNAPSHOT.jar </code></pre>

* Version atual <b>0.0.1</b> e entidade definida como <b>Terminal</b>.

* Requisições são feitas seguindo a <b>URL_BASE</b> de acordo com cada ambiente

<pre><code>Local: localhost:8080/0.0.1 </code></pre>
<pre><code>Heroku: https://jordy-desafio-tecnico-dock.herokuapp.com/0.0.1 </code></pre>

##

<div>

## Endpoints:
<pre><code>[GET] <b>URL_BASE</b>/Terminals //Lista todos os terminals 

[POST] <b>URL_BASE</b>/Terminal -Body (TEXT/HTML) //Recebe um terminal via post e salva no banco

[GET] <b>URL_BASE</b>/Terminal/logic //Retorna um terminal especifico pelo campo logic

[PUT] <b>URL_BASE</b>/Terminal/logic -Body (JSON) //Atualiza um terminal a partir de JSON na requisição</code></pre>

</div>
<pre><code>
Formato Json:

  {
        "logic": 99885500,
        "serial": "234",
        "model": "PWWIN",
        "sam": 23,
        "ptid": "D25C23ER21B",
        "plat": 4,
        "version": "8.00b3",
        "mxr": 0,
        "mxf": 15127973,
        "verfm": "PWWIN"
  }


Formato Text Html: 99885500;234;PWWIN;23;D25C23ER21B;4;8.00b3;0;15127973;PWWIN

</code></pre>
