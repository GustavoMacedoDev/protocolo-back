package br.com.macedo.sistemas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.macedo.sistemas.entities.Protocolo;
import br.com.macedo.sistemas.repository.ProtocoloRepository;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping("/service")
public class ProtocoloController {
	
	@Autowired
	private ProtocoloRepository protocoloRepository;
	
	@RequestMapping(value = "/protocolo", method = RequestMethod.GET)
	public @ResponseBody List<Protocolo> getProtocolos() {
		
		return this.protocoloRepository.findAll();
		
	}
	
	

}
