# movies
API RESTful para possibilitar a leitura da lista de indicados e vencedores da categoria Pior Filme do Golden Raspberry Awards

# Requerimentos de Execução

1. Java >= 8

2. Maven

3. Git

# Passos para Execução
Todos os comandos devem ser executados na linha de comando (Terminal). 

```bash
$ git clone https://github.com/dorcilio/movies.git
```

```bash
$ cd movies
```

```bash
$ mvn install
``` 

```bash
$ java -jar ./target/movies-0.0.1-SNAPSHOT.jar
```
# Rotas - REST API

### Request

Obter o produtor com maior intervalo entre dois prêmios consecutivos, e o que
obteve dois prêmios mais rápido, seguindo a especificação de formato definida.

`GET /movie/winners`

    curl -i -H 'Accept: application/json' http://localhost:8080/movie/winners

### Response

    HTTP/1.1 200 OK
    Date: Fri, 02 Jul 2021 13:50:30 GMT
    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json;charset=UTF-8
    
    {"min":[{"producer":"Joel Silver","previousWin":1990,"followingWin":1991,"interval":1}],"max":[{"producer":"Matthew Vaughn","previousWin":2002,"followingWin":2015,"interval":13}]}

