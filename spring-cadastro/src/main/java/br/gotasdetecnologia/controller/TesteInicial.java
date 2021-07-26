package br.gotasdetecnologia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
		usuarioRepository.save(usuario);
		
		return "Usuario cadastrado: " +name;
		
	}
	
	@Autowired
	//Tem de colocar para mostrar a dependencia ("injeção")
	private UsuarioRepository usuarioRepository;
	
	

}
