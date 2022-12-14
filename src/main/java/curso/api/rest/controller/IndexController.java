package curso.api.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;
import curso.api.rest.repository.UsuarioRepository;


/*POST  = SALVAR
 * GET = TRAZER INF
 * put = att
 * delete = delete*/


@RestController /*Mapeio(Identifico) essa classe como controlador REST*/
@RequestMapping(value = "/usuario") /*Mapeamento da minha requisição do controlador*/
public class IndexController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/*Serviço Restful*/
	@GetMapping(value = "/{id}/relatoriopdf", produces = "application/json") /*Acessar a raiz e produzir um JSON (return json)*/
	public ResponseEntity<Usuario> relatorio(@PathVariable(value = "id") Long id) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		/*Supondo que o retorno seria um relatório*/
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	}
	
	/*Serviço Restful*/
	@GetMapping(value = "/{id}/codigovenda/{venda}", produces = "application/json") /*Acessar a raiz e produzir um JSON (return json)*/
	public ResponseEntity<Usuario> codigoVenda(@PathVariable(value = "id") Long id, @PathVariable(value = "venda") Long venda) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		/*Supondo que o retorno seria um relatório*/
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> usuarios() {
		
		List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();
	
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/cadastrar/", produces = "application/json")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
		
		Usuario usuarioSalvo = usuarioRepository.save(usuario); /*Save: grava no banco de dados e retorna o objeto em seu estado persistente*/
		
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/atualizar/{id}", produces = "application/json")
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario, @PathVariable Long id) {
		
		/*Outras rotinas antes de ATUALIZAR*/
		
		Usuario usuarioSalvo = usuarioRepository.save(usuario); /*Save: grava no banco de dados e retorna o objeto em seu estado persistente*/
		
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/deletar/{id}", produces = "application/text")
	public String delete(@PathVariable(value = "id") Long id) {
		
		usuarioRepository.deleteById(id);
		
		return "Delete OK";
		
	}
	
}
