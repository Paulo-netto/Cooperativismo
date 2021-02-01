# Cooperativismo

API REST

## Getting Started

Para iniciar o projeto siga as instruções seguintes.

### Pré-requisitos

* [Github](https://github.com/)
* [Java SE Development Kit 8](https://www.oracle.com/)
* [Maven 3.x](https://maven.apache.org/)
* [PostgreSQL](https://www.postgresql.org/download/)

### Instalação

Após instalar todos os pré-requisitos necessários, execute os próximos passos para conseguir disponibilizar a aplicação no seu ambiente local de desenvolvimento.

```sh
# Clone o repositório do projeto
$ git clone https://github.com/Paulo-netto/Cooperativismo.git
# Navegue até a pasta root da aplicação
# Instale todas as dependências
$ mvn clean install
```
## Executando a Aplicação

Importe o projeto em uma IDE de suas preferência.

1 - Vá no arquivo Cooperativismo/src/main/resources/application.properties e descomente o codigo 

2 - Vá no arquivo /Cooperativismo/src/main/java/com/br/cooperativismo/CooperativismoApplication.java e execute

>**importante:** Swagger link para testar API http://localhost:8080/swagger-ui/

> **importante:** Para o desenvolvimento do projeto base utilizei o Eclipse.

Agora build a aplicação na sua IDE.

```sh
# Maven goals
$  clean install
```

## Tecnologias utilizadas 

1 - Spring Boot: Para o desenvolvimento do presente projeto foi utilizado como base o SpringBoot, escolhi essa tecnologia, pois, ela tem vários benefícios e um desses é otimizar o tempo e aumentar a produtividade, já que ele facilitar o processo de configuração e publicação da nossa aplicação. Ou seja, não precisei perde tempo desenvolvendo uma aplicação do zero, o springboot já disponibilizou maioria dos recursos necessários.

2 - Banco de dados: Como escolha para persistir os dados e que eles não sejam perdidos, escolhi o modelo relacional SQL e o banco postgresql, pois, são de fácil configuração.

3 - Gerenciamento de dependência: Maven, escolhi essa ferramenta para gerenciar as dependências, pois, ela ajudar no uso de melhores práticas, incentiva a criação de testes unitários e a facilidade que ela gera para o build do projeto.

4 - Ferramente de Log: Logback, para geração dos logs da aplicação utilizei o logback. No pacote resources, criei um arquivo chamado logback-spring.xml e configurei um scrit para que a aplicação crie gere uma pasta no projeto e criei três tipos de logs, uma para a parte de persistência outra para a aplicação e por fim uma para o servidor, assim, facilitando caso ocorra um erro ele seja encontrado facilmente.

5 - Consumir api externa: Utilizei o Resttemplate para consumir a api externa disponibilizada, meus critérios para utilização de tal ferramente foi a finalidade com a mesma, uma vez que precisei fazer uma chamada pontual em uma api externa.

6 - Documentação: Swagger, o swagger além de descrever os recursos que a API contém ele garantir a padronização das interfaces e ainda é possível testar por ela.

7 - Testes: 
          - Unitarios: Mockito
          - Integração: MockMVC
