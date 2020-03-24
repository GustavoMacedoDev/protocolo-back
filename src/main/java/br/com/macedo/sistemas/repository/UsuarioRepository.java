package br.com.macedo.sistemas.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.macedo.sistemas.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario findByLogin(String login);
	Usuario findBySenha(String senha);

}
