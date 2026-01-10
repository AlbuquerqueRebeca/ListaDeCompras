
## Gerenciamento de Listas de Compras 📝🛍️🛒

-----------------------------------------------

#### Introdução
Este sistema foi desenvolvido para facilitar o gerenciamento de listas de compras, permitindo que usuários cadastrem contas, criem e editem listas, reutilizem listas anteriores e recebam sugestões inteligentes de produtos mais frequentes. 
Todas as informações são armazenadas na nuvem via Railway, garantindo segurança dos dados.

----------------------------------------------------------------------------------------------
#### Funcionalidades 
- Cadastro de usuários (nome, e-mail, senha).
- Criação, edição e exclusão de listas de compras.
- Reutilização de listas anteriores.
- Visualização de listas atuais e antigas.
- Sugestões inteligentes de produtos mais frequentes 
- Sincronização com armazenamento em nuvem.

------------------------------------------------------------------------------------------------------------

#### Tecnologias Utilizadas
- Java 17
- Spring Framework (Web, Data JPA, Security)
- Banco de Dados SQL (PostegreSQL)
- Swagger (Documentação da API)
- Railway (Hospedagem e deploy)
- Gradle (Gerenciador de dependências)
- Junit + Mockito (Teste de integração)
- Inteligência Artificial (sugestões de produtos)

--------------------------------------------------------------------------------------------------------------

#### Ferramentas Utilizadas

- Visual Studio Code (VS Code)
- Posteman -> para testar as rotas da API
- Git -> para versionamento e controle de código
- Raiway -> para gerenciar o deploy e banco de dados na nuvem

--------------------------------------------------------------------------------------------------------------

  #### Como executar localmente

 
  1- Clone o repositório:
  
  git clone https://github.com/AlbuquerqueRebeca/ListaDeCompras.git

 
  2- Entre na pasta:
  
  cd ListaDeCompras

 
  3- Gere o JAR:
  
  ./gradlew bootJar

 
  4 - Rode a aplicação:
  
  java -jar build/libs/projetolistacompras-0.0.1-SNAPSHOT.jar


 5- Acesse:
 
 http://localhost:8080


-------------------------------------------------------------------------------------------------------






