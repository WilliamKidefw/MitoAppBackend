package com.mitocode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Menu;
import com.mitocode.model.Usuario;
import com.mitocode.service.IUserService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUserService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> usuarios = service.listar();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> leerPorId(@PathVariable("id") Integer id) {
		Usuario obj = service.listarPorId(id);
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Usuario>> listarPageable(Pageable pageable) {
		Page<Usuario> usuarios = service.listarPageable(pageable);
		return new ResponseEntity<Page<Usuario>>(usuarios, HttpStatus.OK);
	}
}
