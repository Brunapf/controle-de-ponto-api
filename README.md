## Sistema Batida de ponto

> Status do Projeto: Em desenvolvimento :warning:

API feita com spring-boot + MYSQL + docker-compose e REST para registrar batidas de ponto.

O sistema recebe um horário e faz seguintes validações:
- [X] Verifica se Data e hora estão em formato válido
- [X] Verifica campo obrigatório
- [X] Verifica se o dia da batidaEntity de ponto é final de semana ( Sábado ou Domingo)
- [X] Verifica se há até 4 batidas em um mesmo dia (caso já tenha 4 não deixa cadastrar)
- [X] Verifica batidas duplicadas (batidaEntity com mesma data e horário)
- [X] Verifica se tem no mínimo 1 hora de almoço.

Para rodar o sistema execute os comandos abaixo na pasta raiz do projeto.


## Compilar o projeto
```sh
./mvnw.cmd clean install
```

## Subindo a aplicação com Docker-compose
```sh
docker-compose up --build --force-recreate
```
### A aplicação possui:
    - GET  
    - POST
