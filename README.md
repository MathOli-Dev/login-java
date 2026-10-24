# Sistema simples de login (Spring Boot + JWT)

Cadastro, login e rota protegida. Java 17+, Maven, Spring Security, JPA e H2.

## Rodar
```bash
mvn spring-boot:run
# opcional (recomendado): export JWT_SECRET="uma-chave-com-pelo-menos-32-caracteres"
```
A API sobe em http://localhost:8080

## Rotas
- `POST /api/auth/register` cria o usuário (senha com hash BCrypt)
- `POST /api/auth/login` devolve o JWT
- `GET  /api/me` rota protegida (header `Authorization: Bearer <token>`)

## Testar
```bash
curl -X POST localhost:8080/api/auth/register -H "Content-Type: application/json" \
  -d '{"email":"teste@email.com","password":"senha1234"}'

curl -X POST localhost:8080/api/auth/login -H "Content-Type: application/json" \
  -d '{"email":"teste@email.com","password":"senha1234"}'

curl localhost:8080/api/me -H "Authorization: Bearer SEU_TOKEN"
```

## Estrutura
- `model` e `repository`: entidade User e acesso ao banco
- `dto`: entradas e saídas com validações (Bean Validation)
- `service`: regra de negócio (cadastro e login)
- `security`: JwtService, JwtAuthFilter e SecurityConfig
- `controller`: rotas
- `exception`: tratamento dos erros de validação

## Desafios
1. Refresh token e logout
2. Limitar tentativas de login (rate limit)
3. Roles (USER/ADMIN) com `@PreAuthorize`
4. Sessão com cookie HttpOnly em vez de JWT
5. Testes com MockMvc e `@SpringBootTest`
