package curso.api.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController /*Mapeio(Identifico) essa classe como controlador REST*/
@RequestMapping(value = "/usuario") /*Mapeamento da minha requisição do controlador*/
public class IndexController {

	/*Serviço Restful*/
	@GetMapping(value = "/", produces = "application/json") /*Acessar a raiz e produzir um JSON (return json)*/
	/*Não é obrigatorio (required = falso), então se nao for informado é nulo
	 * Em um sistema de verdade, é bom colocar um Default value, como por exemplo, defaultValue = "Nome não foi informado"*/

	public ResponseEntity init(@RequestParam(value = "nome", required = false) String nome, @RequestParam(value = "salario") Long salario) {
		
		System.out.println("Parametro sendo recebido, " + nome + ", salario = R$" + salario);
		return new ResponseEntity("Olá Usuário REST Spring Boot, seu nome é " + nome + " e seu salario eh = R$" + salario, HttpStatus.OK);
		
		/*Passando o parametro pelo navegador, depois do "/" colocar ?=nome(nome_escolhido)
		 * Exemplo: http://localhost:8080/usuario/?nome=tiago
		 * 
		 * Passando dois parametros:
		 * http://localhost:8080/usuario/?nome=tiago&salario=200 
		 * */
		
		
	}
	
}
