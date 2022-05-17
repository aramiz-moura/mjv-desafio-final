# mjv-desafio-final

# ecommerce-api

API criada como desafio final da school MJV.


## Arquitetura


* Maven
* Java 17
* Spring Boot
* Spring Data
* Spring JPA
* Specification
* Exception Handler
* Lombok
* Docker
* PostgreSQL




### Clone

```console
git clone https://github.com/aramiz-moura/mjv-desafio-final
```



## Requisições
- Todas as requisições estão documentadas no swagger. Após inicialização do projeto acesse o endereço: http://localhost:8080/swagger-ui.html
- Por favor, atentar a todas as observações das requisições.


<details><summary><b>Rotas dos produtos (Clique aqui)</b></summary>

> Utiliza-se o estilo RESTFull portanto todos os caminhos partem do path: **/v1/produto**

1. Caminho=/ , Metodo=**POST**
   ```
   Body:
   ```	
   ```json
   {
	"nome": "string",
	"descricao": "string",
	"tipoMidia": "DIGITAL ou FISICO (enum)",
	"plataforma": "string",
	"valor": "BigDecimal"
   }
   ```
	> Obs.: O tipo de midia foi escolhido um ENUM para representa-lo, então ele espera os valores (**DIGITAL**, **FISICO**). Caso informe um tipo diferente desses gerará um erro inesperado.
  
2. Caminho=*/v1/produto?nome={nomedoProduto}&tipoMidia={tipoMidia}&valor={BigDecimal}*, Método=**GET**
```
  Não é necessário nenhum Body. Porém, possui filtros para nome do produto, tipo de midia e valor.
  Caso não passe nenhum filtro, retornará todos os produtos.
```
3. caminho=*/{idProduto}*, Método=**GET**
   ```
   Consulta um produto através do seu Id. 
   Retorna um JSON com as informações do produto.
   ```	
4. Caminho=*/{idProduto}*, Método=**DELETE**
   ```
   Deleta um determinado produto através do Id.
   ```
5. Caminho=*/{idProduto}*, Método=**PUT**
   ```
   Body:
   ```	
   ```json
   {
	"nome": "string",
	"descricao": "string",
	"tipoMidia": "DIGITAL ou FISICO (enum)",
	"plataforma": "string",
	"valor": "BigDecimal"
   }
   ```
	
  > Obs.: Atualiza produto já cadastrado.
   
</details>


<details><summary><b>Rotas dos usuários (Clique aqui)</b></summary>

> Utiliza-se o estilo RESTFull portanto todos os caminhos partem do path: **/v1/usuario**

1. Caminho=/, Método=**POST**
    ```
    Body:
    ```
   ```json
 	{
	"nomeUsuario": "string",
	"nome": "string",
	"email": "string",
	"cpf": "string"	
	}
   ```
2. Caminho=*/{idUsuario}*, Método=**GET**
   
   Consulta um usuário através do seu Id. 
   Retorna um JSON com as informações do usuário.

3. Caminho=*/v1/usuario?nome=string&nomeUsuario=string*, Método=**GET**
   ```
   NENHUM BODY NECESSÁRIO.
   Consulta usuário(s) a partir dos filtros informados.
   Caso não passe nenhum filtro, retornará todos os usuários.
   ```
4. Caminho=*/{idUsuario}*, Método=**DELETE**
   ```
   Deleta um determinado produto através do Id.
   ```
5. Caminho=/{idUsuario}, Método=**PUT**
   ```
   Body:
   ```	
   ```json
   	{
	"nome": "string",
	"nomeUsuario": "string",
	"email": "string",
	"cpf": "string"
  	}
   ```
  > Obs.: Atualiza usuário já cadastrado.
		
</details>


<details><summary><b>Rotas do carrinho (Clique aqui)</b></summary>

> Utiliza-se o estilo RESTFull portanto todos os caminhos partem do path: **/v1/carrinho**
  
1. Caminho=*/{idCarrinho}*, Método=**POST**
   ```	
   Body:
   ```	
   ```json
  	{
	"produtoId": "Long",
	"quantidade": "Integer"
  	}
   ```
  > Obs.: Adiciona produtos ao carrinho informado. Retorna um JSON com as informações e o produto adicionado ao Carrinho.
  
2. Caminho=*/{idCarrinho}*, Método=**GET**
   ```
   NENHUM BODY NECESSÁRIO.
   Consulta um carrinho através do seu Id. 
   Retorna um JSON com as informações do carrinho.
   ```
3. Caminho=*/{idCarrinho}/{idItemCarrinho}*, Método=**DELETE**
   ```
   NENHUM BODY NECESSÁRIO.
   Deleta o item de carrinho especifico de um determinado carrinho.
   Retorna um JSON do que foi deletado.
   ```
	
</details>

## Detalhes


1. Para comunicação foi usado a arquitetura REST, baseado no Restful. Os serviços recebem e respondem JSON.

2. Para banco de dados foi usado banco local através do docker. Para testes, foi utilizado H2. 
  Sendo assim, é necessário uma base de dados localmente.

3. Na documentação foi pensado no swagger por ser uma ferramenta de facil implementação e usabilidade.

4. Nas respostas foi escolhido o objeto ResponseEntity do spring para gerenciar todo o objeto da resposta.

5. Para testes foi usado o INSOMNIA com os endpoints informados acima.

