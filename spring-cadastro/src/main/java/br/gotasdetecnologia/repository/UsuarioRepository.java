package br.gotasdetecnologia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.gotasdetecnologia.model.Usuario;

@Repository	
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	//Depois de criado esta interface, va ate o controller para criar as ações do CRUD
	//aqui foi so areferencia para utilização
	
	//buscar por parte do nome. Pois não é um padrao do CRUD. Implementar
	
	@Query(value = "select u from Usuario u where u.nome like %?1%")
	List<Usuario> buscarPorNome(String name);
	
	
	
	
	}


