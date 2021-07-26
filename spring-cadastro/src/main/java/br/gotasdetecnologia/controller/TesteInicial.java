package br.gotasdetecnologia.controller;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.gotasdetecnologia.model.Usuario;
import br.gotasdetecnologia.repository.UsuarioRepository;

@RestController
public class TesteInicial {
	
	@RequestMapping(value = "/mostrarnome/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String testeText(@PathVariable String name) {
		//return "Curso Spring REST" +name;
		
		Usuario usuario = new Usuario();
		usuario.setNome(name);
		//usuario.setIdade(40)
		
		usuarioRepository.save(usuario);
		
		return "Usuario cadastrado: " +name;
		
	}
	
	@Autowired
	//Tem de colocar para mostrar a dependencia ("injeção")
	//se tirar linha 25 não é encontrada
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/listatodos")
	@ResponseBody //retorna os dados para o corpo da resposta em json
	public ResponseEntity<List<Usuario>> listaUsuario()
	{
		List<Usuario> usuarios = usuarioRepository.findAll();//executa consulta no BD
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	
	}
	
	@PostMapping ("/salvar") //mapeando a url
	@ResponseBody  //descrição da resposta
	public ResponseEntity<Usuario> salvar (@RequestBody Usuario usuario)
	{//recebe os dados para salvar
		
		Usuario user = usuarioRepository.save(usuario);
									
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	}
	
	//Mapeamento
	//REquisição
	//Resposta de Dados
	@DeleteMapping ("/apagar")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long iduser){
		
		usuarioRepository.deleteById(iduser);
		
		return new ResponseEntity<String>("Usuario deletado", HttpStatus.OK);
	//Uso do Postman	
	}
	
	//Localizar para editar, deletar...
	@GetMapping ("/buscaruserid")
	@ResponseBody
	public ResponseEntity<Usuario> buscaruserid(@RequestParam (name = "iduser") Long iduser){
		
		Usuario usuario = usuarioRepository.findById(iduser).get();
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	//Uso do Postman	
	}
	
	
	
	
	
	
	}
