
# Tarefa teste de um Usuário API - O bicho papão dos testes

# Desenvolvido por: Luis Antonio Pereira Silva ( Sr. Luis, antigo mago do código)  
📧 luismusicdm1@gmail.com — Manda um alô, pode ser pra reclamar que algo não funciona ou só pra dizer que gostou (prefiro a segunda opção, viu? 😜)


# O que é isso?

Uma API REST em Java com Spring Boot que faz CRUD de usuários com toda a pompa e circunstância:

- Tem nome, email, senha, timestamp e um flag de conta bloqueada (pra caso o usuário apronte)
- Pode ter descrição, telefone e roles (porque a gente é chique)
- Endpoints básicos: GET /status, POST, PUT e DELETE, tudo na régua, paginado e ordenado — aquele esquema que os nerds adoram.


# Como rodar esse troço?

1. *Clona o repo*  
   bash
git clone https://github.com/seu-usuario/usuario-api.git
cd usuario-api


2. *Configura o banco*  
Rodar o PostgreSQL na sua máquina e criar os bancos `usuario_dev`, `usuario_homolog`, `usuario_prod`. Atualiza os `application-*.yml` com seu usuário e senha.

3. *Builda com Maven*  
    bash
mvn clean package
 

4. *Roda a API com Docker*  
    bash
docker build -t usuarioapi .
docker run -p 8080:8080 usuarioapi
 

5. *Teste os endpoints* com o Postman, Insomnia, ou até aquele amigo chato que gosta de fazer requisição curl no terminal.

 

# Segurança

Tem um esquema básico com Spring Security:  
Usuário: `admin`  
Senha: `senha123`  
Por enquanto, só pra dar um gostinho. Mas é só um teste mesmo.



# Pipeline de CI/CD

Configurado com GitHub Actions pra garantir que o código não quebre antes de você reclamar.  
Sempre que você der um push na branch `main`, o pipeline vai rodar o build e os testes. Se der ruim, já sabe: volta pro código que nem super-herói volta pra salvar o dia.

 

# Considerações finais

Esse projeto é tipo aquele amigo que faz tudo direito, mas também sabe fazer piada.  
Pode usar, modificar, aprender e até zoar o código (mas com carinho, por favor).

Se quiser trocar ideia, só mandar e-mail ou abrir um issue aqui no repo.  
Prometo responder (não garanto que vai ser rápido, mas é porque tô codando com amor).
Luis Antonio



# Bora estudar e relembrar pra codar java com alegria! 🚀🔥

