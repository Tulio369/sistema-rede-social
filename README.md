# Sistema de Rede Social em Java
Este projeto consiste em um sistema simples de rede social desenvolvido em Java.
O sistema permite que os usuários se cadastrem, publiquem posts, comentem, curtam posts e gerenciem suas amizades.
Foi implementado utilizando o conceito de CRUD (Criar, Ler, Atualizar e Deletar), segurança com criptografia de senha (BCrypt), e funcionalidades de interação entre usuários.

# Desenvolvedor 
**Nome**: Tulio de Lima Avelino

**RA**: 1794575

# Descrição Detalhada
O sistema possui as seguintes funcionalidades:

**Cadastro de Usuário**: O usuário pode se cadastrar informando nome, username, email e senha. A senha é criptografada antes de ser armazenada.

**Login**: Embora não tenha sido implementado com autenticação JWT, o sistema pode ser expandido para incluir validação de login.

**Publicação de Posts**: O usuário pode criar posts de texto, e esses posts são armazenados e exibidos.

**Comentário e Curtida**: Os posts podem ser comentados e curtidos por outros usuários.

**Amizades**: O sistema permite que os usuários adicionem e removam amigos.

**Validações**: O sistema valida campos de entrada (como email e senha), e realiza a verificação de permissões antes de permitir exclusão de dados.

# Tecnologias Utilizadas
**Java**: Linguagem de programação principal para a implementação do sistema.

**BCrypt**: Biblioteca usada para criptografar as senhas dos usuários.

**Spring Boot (opcional para desenvolvimento futuro)**: Pode ser utilizado para uma versão mais robusta com APIs REST

# Instruções de Execução
# Passo 1: Baixar o código

Clone o repositório do projeto para o seu ambiente local:

git clone https://github.com/Tulio369/sistema-rede-social.git
cd rede-social-java

# Passo 2: Configuração do Ambiente
Certifique-se de que você tem o JDK instalado em sua máquina. Você pode verificar isso com o comando:

java -version

# Passo 3: Compilação e Execução
1. Abra o projeto no IntelliJ IDEA ou em sua IDE de preferência.
2. Compile o projeto.
3. Execute o método main da classe Main.java para iniciar o sistema de rede social.
javac com/redesocial/Main.java
java com.redesocial.Main

# Passo 4: Interação no Console
Ao rodar o programa, o sistema exibirá o menu principal, onde você pode:

**Cadastrar um novo usuário.**

**Criar posts.**

**Interagir com o sistema** conforme os menus interativos no console.

# Exemplos de Uso
# Cadastro de Usuário
Quando você escolhe a opção "Cadastrar novo usuário", o sistema pede os seguintes dados:

=== Cadastro de Usuário ===

Digite seu nome: João Silva

Digite seu username: joao123

Digite seu email: joao@email.com

Digite sua senha: ********

Usuário cadastrado com sucesso!

# Criação de Post
Após o login, o usuário pode criar posts. Exemplo:

=== Novo Post ===

Digite seu post: Olá, este é meu primeiro post na rede social!

Post publicado com sucesso!

# Explicação das Decisões de Implementação
# Segurança
**Criptografia de Senha**: Utilizamos o **BCrypt** para criptografar as senhas dos usuários, garantindo que as senhas não sejam armazenadas em texto claro.

**Validação de Dados**: A validação de dados (como email, username e senha) é feita tanto no lado do cliente (console) quanto em nível de backend, como a verificação de existência de um email já cadastrado.

# Design do Sistema
**Modelo**: O sistema é estruturado com 3 principais pacotes: modelo, gerenciador e ui. As classes modelo contêm os dados essenciais do sistema, como Usuario, Post, e Comentario. A camada gerenciador é responsável pela lógica de negócios, como criação de posts, cadastro de usuários, e validação. A camada ui contém a interface com o usuário (console), onde o usuário interage com o sistema.

# Performance
**Paginação de Posts**: Embora o sistema atual não tenha paginação implementada, é uma melhoria importante que pode ser implementada para otimizar a exibição de posts.

**Cache**: Não implementado diretamente, mas poderia ser adicionado para armazenar dados frequentemente acessados, como a lista de posts de um usuário.

# Usabilidade
**Feedback Claro**: Sempre que uma ação é concluída, o sistema fornece um feedback claro, como "Post publicado com sucesso!" ou "Usuário cadastrado com sucesso!".

**Navegação Intuitiva**: O menu principal e o menu do usuário são simples e fáceis de navegar, com opções claras e instruções simples.

# Considerações Finais
Este projeto pode ser expandido para incluir funcionalidades mais avançadas, como autenticação de sessão com JWT, persistência de dados em banco de dados relacional, e suporte a diferentes tipos de mídia em posts.
