package com.ibm.contato.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.ibm.contato.model.ContatoModel;
import com.ibm.contato.repository.ContatoRepository;
import com.ibm.error.CustomErrorType;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
	
	private final ContatoRepository contatoDAO;
	
	@Autowired
	public ContatoController(ContatoRepository contatoDAO) {
		this.contatoDAO = contatoDAO;
	}
	
		
	@GetMapping
	public ResponseEntity<?> listAll(){
		List<ContatoModel> contatos = contatoDAO.findAll();
		return new ResponseEntity<>(contatos, HttpStatus.OK);
	}
	

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getContatoById(@PathVariable("id") Long id){
		Optional<ContatoModel> contato = contatoDAO.findById(id);
		if (!contato.isPresent()) {
			return new ResponseEntity<>(new CustomErrorType("Contato nao encontrado"), HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(contato, HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody ContatoModel contato){
		
		contatoDAO.save(contato);
		return new ResponseEntity<>(contato ,HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		contatoDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody ContatoModel contato){
		contatoDAO.save(contato);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
