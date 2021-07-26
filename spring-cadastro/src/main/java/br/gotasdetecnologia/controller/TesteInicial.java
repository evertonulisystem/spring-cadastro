package br.gotasdetecnologia.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.gotasdetecnologia.repository.UsuarioRepository;
import br.gotasdetecnologia.model.Usuario;

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
	
	@GetMapping(value="listatodos")
	@ResponseBody //retorna os dados para o corpo da resposta em json
	public ResponseEntity<List<Usuario>> listaUsuario(){
		List<Usuario> usuarios = usuarioRepository.findAll();//executa consulta no BD
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
		
	}
	
	

}
