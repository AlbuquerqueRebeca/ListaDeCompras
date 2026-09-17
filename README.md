
## Gerenciamento de Listas de Compras 📝🛍️🛒

-----------------------------------------------

#### Introdução
Este sistema foi desenvolvido para facilitar o gerenciamento de listas de compras, permitindo que usuários cadastrem contas, criem e editem listas, reutilizem listas anteriores e recebam sugestões inteligentes de produtos que costumam comprar com frequência.

A aplicação também conta com recursos de Inteligência Artificial Generativa, permitindo sugerir receitas com base nos produtos presentes nas listas e, de forma interativa, gerar sugestões a partir de ingredientes informados pelo usuário.

As informações são armazenadas em nuvem utilizando Supabase, e a aplicação possui autenticação e controle de acesso para proteger os recursos de cada usuário.

----------------------------------------------------------------------------------------------
#### Funcionalidades 
- Cadastro de usuários (nome, e-mail e senha).
- Criação, edição e exclusão de listas de compras.
- Reutilização de listas anteriores.
- Visualização de listas atuais e antigas.
- Sugestões de produtos comprados com maior frequência.
- Sugestão de receitas com base nos produtos presentes na lista de compras.
- Sugestão interativa de receitas a partir de ingredientes informados pelo usuário.

------------------------------------------------------------------------------------------------------------

#### Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- PostgreSQL
- Supabase (Banco de dados e armazenamento em nuvem)
- Swagger / OpenAPI (Documentação da API)
- Gradle (Gerenciador de dependências)
- JUnit + Mockito (Testes unitários)
- Postman (Testes e validação das APIs)
- Git e GitHub (Controle de versão)
- OpenAI / Inteligência Artificial Generativa (Sugestões de receitas)

--------------------------------------------------------------------------------------------------------------

#### Ferramentas Utilizadas

- Visual Studio Code (VS Code)
- Posteman -> para testar as rotas da API
- Git -> para versionamento e controle de código
- Github -> hospedagem de código 
- Supabase -> para gerenciar o deploy e banco de dados na nuvem

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


#### Rotas da API

| Método | URL                       | Descrição                   |
|--------|---------------------------|-----------------------------|
| POST   | api/criar-usuario         | Cria um novo Usuário        |
| GET    |  api/listar-todos         | mostra o cadastro de usuário|
| DELETE | api/deletar-perfil        | deletar perfil de usuário   |
| POST   | api/criar-lista           |  cria uma nova lista        |
| GET    |  api/buscar               | busca por listas salvas     |
| PUT    | api/editar-lista          | editando lista de compras   |
|GET     | api/sugestoes             | Da sugestoes de produto     |
|DELETE  | apit/deletar-lista        | deleta todas as listas      |



--------------------------------------------------------------------------------------------

#### Fazendo login

{ "username": "Rafaella",

 "password": "242526"
}

Um token é gerado após a verificação de dados do usuário:

"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYWZhZWxsYSIsImlhdCI6MTczNjE5NDQ5Nn0.4XxnWYkEAhpH2QEndp1LaGa28ye7j9ISgt-Spswff75uSQ8c6Akq4V26JMofa8Gtsf0vwG413TDBGx4K6CJdPg"

Com o uso de Bearer Token e adicionando o token gerado, o usuário tem acesso a todas as rotas de autentição:

- Criar lista
- buscar lista
- editar lista
- sugestoes
- deletar lista
- deletar perfil


--------------------------------------------------------------------------------------

#### Teste de Integração

1- Esse teste valida se a API é capaz de criar uma lista de compras corretamente. 
Simulando uma requisiçao POST/criar-lista enviando um JSON com alguns produtos e verifica se a resposta contém
os mesmos itens e nome da lista.

```

@Test
    @WithMockUser(username = "rebeca@gmail.com")
    void deveCriarListaNova() throws Exception {
        String listaJson = """
                {
                     "nome": "lista de compras semanal",
                     "descricao": "Lista de compras para a semana",
             "itens": [
                         {"nome": "Arroz", "quantidade": 2},
                         {"nome": "Feijao", "quantidade": 3},
                         {"nome": "Café", "quantidade": 1}
                         ]
                         
                         }
                """;
        mockMvc.perform(post("/auth/criar-lista")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(listaJson))
                        .andExpect(status().isCreated())
            .andExpect(content().string("Lista criada com Sucesso!! Boas compras"));
            
            
            
    

    }

```

O que este teste garante: 

- Que a rota /criar-lista está funcionando.
- Que o sistema responda com status 200 (ok) e o Json esperado.




2- Este teste valida se a rota /criar-usuario cria um usuário corretamente e retorna os dados esperados

```

@Test
    void  deveCriarUsuario() throws Exception {
        String usuarioJson = """
                
                {
                    "email": "novo.usuario@gmail.com",
                    "nome": "Novo Usuario",
                     "senha": "123456"
                     }
                """;

                  mockMvc.perform(post("/api/criar-usuario")
                       .contentType(MediaType.APPLICATION_JSON)
                       .content(usuarioJson))
                      .andExpect(status().isOk())
                      .andExpect(content().string("Conta criada com Sucesso!!!"));
    }

```

O que este teste garante : 

- Que a rota /criar-usuario está funcionando
- Que o sistema responde um status 200 (ok) e o json esperado.


------------------------------------------------------------------------------------------------------------

#### ✅ Conclusão

Este projeto é uma aplicação onde o usuário é capaz de criar uma nova conta com dados básicos (nome, email e senha). Os usuários devem fazer login em suas contas usando suas credenciais, e todas as senhas são codificadas. Após o login e a verificação dos dados, eles recebem um token JWT que será usado para autenticar suas solicitações.

Os usuários autenticados são capazes de criar, visualizar, atualizar e deletar suas listas de compras, além de reutilizar listas anteriores. O sistema também conta com um módulo de inteligência artificial básica, que sugere produtos mais frequentes para agilizar a criação DE  novas listas.

 Apesar de ser uma aplicação simples, este projeto me deu a oportunidade de explorar tecnologias que eu ainda não tinha utilizado em projeto anteriores, como PostgreSQL para persistência, Railway para deploy em nuvem, testes de integração com mockito e até uma inteligência artificial básica para sugerir produtos frequentes. 

Além disso, este projeto nasceu de uma necessidade pessoal: eu e minha mãe ainda fazemos listas de supermercado no papel e, muitas vezes, esquecemos o papel em casa ou deixamos de anotar algum produto importante. Essa dificuldade não se limita apenas às compras de supermercado, mas também a listas de presentes e tarefas. Por isso, além de aplicar novas tecnologias, este projeto surgiu da vontade de resolver um problema real da minha rotina e torná-la mais prática e organizada.


 




