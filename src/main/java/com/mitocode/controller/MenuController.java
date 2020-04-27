package com.mitocode.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Menu;
import com.mitocode.service.IMenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {
	
	@Autowired
	private IMenuService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar() {
		List<Menu> menues = service.listar();
		return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
	}
	
	@PostMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar(@RequestBody String nombre) {
		List<Menu> menus = service.listarMenuPorUsuario(nombre);
		return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Menu> leerPorId(@PathVariable("id") Integer id) {
		Menu obj = service.listarPorId(id);
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		return new ResponseEntity<Menu>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Menu men) {
		Menu menu = service.registrar(men);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(menu.getIdMenu()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Menu>  modificar(@Valid @RequestBody Menu men) {
		Menu obj = service.modificar(men);
		return new ResponseEntity<Menu>(obj,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object>  eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Menu>> listarPageable(Pageable pageable) {
		Page<Menu> menus = service.listarPageable(pageable);
		return new ResponseEntity<Page<Menu>>(menus, HttpStatus.OK);
	}
	
	
}
