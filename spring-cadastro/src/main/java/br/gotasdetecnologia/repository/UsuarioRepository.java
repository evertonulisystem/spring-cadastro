package br.gotasdetecnologia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.gotasdetecnologia.model.Usuario;

@Repository	
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	//Depois de criado esta interface, va ate o controller para criar as ações do CRUD
	//aqui foi so areferencia para utilzação
	
	}


