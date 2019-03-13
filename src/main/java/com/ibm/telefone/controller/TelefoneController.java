package com.ibm.telefone.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.contato.model.ContatoModel;
import com.ibm.contato.repository.ContatoRepository;
import com.ibm.telefone.model.TelefoneModel;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {
	
	private final ContatoRepository contatoDAO;
	
	
	@Autowired
	public TelefoneController(ContatoRepository contatoDAO) {
		this.contatoDAO = contatoDAO;
	}
	
//	@GetMapping(path = "/{id}")
//	public ResponseEntity<?> getTelefoneByIdContato(@PathVariable("id") Long id){
//		
//	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> save(@PathVariable("id") Long id){
		Optional<ContatoModel> contato = contatoDAO.findById(id);
		List<TelefoneModel> telefones = new ArrayList<TelefoneModel>();
		
		if (contato.isPresent()) {
			telefones = contato.get().getTelefones();
		}
		
		
		
		return new ResponseEntity<>(telefones ,HttpStatus.OK);
	}

}
