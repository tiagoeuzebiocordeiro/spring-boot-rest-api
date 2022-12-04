package curso.api.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;

@RestController /*Mapeio(Identifico) essa classe como controlador REST*/
@RequestMapping(value = "/usuario") /*Mapeamento da minha requisição do controlador*/
public class IndexController {

	/*Serviço Restful*/
	@GetMapping(value = "/", produces = "application/json") /*Acessar a raiz e produzir um JSON (return json)*/
	public ResponseEntity<Usuario> init() {
		
		Usuario usuario = new Usuario();
		usuario.setId(20L);
		usuario.setLogin("usuario@admin.com");
		usuario.setNome("admin");
		usuario.setSenha("admin");
		
		
		Usuario usuario2 = new Usuario();
		usuario2.setId(8L);
		usuario2.setLogin("Teste");
		usuario2.setNome("usuario");
		usuario2.setSenha("13712703saasdvcv");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		usuarios.add(usuario);
		usuarios.add(usuario2);
		return new ResponseEntity(usuarios, HttpStatus.OK);
	}
	
}
