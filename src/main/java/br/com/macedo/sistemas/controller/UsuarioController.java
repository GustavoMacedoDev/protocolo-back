package br.com.macedo.sistemas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.macedo.sistemas.entities.Usuario;
import br.com.macedo.sistemas.model.ResponseModel;
import br.com.macedo.sistemas.repository.UsuarioRepository;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping("/service")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	private @ResponseBody List<Usuario> getUsuarios() {
		
		return this.usuarioRepository.findAll();
		
	}
	
	@RequestMapping(value="/usuario", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody Usuario usuario){
				
		try {
			
			this.usuarioRepository.save(usuario);
			
			return new ResponseModel(1,"Registro salvo com sucesso!");
			
		}catch(Exception e) {
			
			return new ResponseModel(0,e.getMessage());			
		}
	}
	
	@RequestMapping(value="/auth/login", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public @ResponseBody ResponseModel valida(@RequestBody Usuario usuario){
		
		
			if(usuarioRepository.findByLogin(usuario.getLogin()) != null) {
				return new ResponseModel(1,"Registro salvo com sucesso!");
			} else {
				System.out.println("no ok");
			}
			
			return new ResponseModel(1,"Registro salvo com sucesso!");
		
	}

}
