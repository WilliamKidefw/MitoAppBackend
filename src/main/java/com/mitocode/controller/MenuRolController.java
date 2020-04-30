package com.mitocode.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.dto.MenuListaRolDTO;
import com.mitocode.model.MenuRol;
import com.mitocode.service.IMenuRolService;

@RestController
@RequestMapping("/menuroles")
public class MenuRolController {
	
	@Autowired
	private IMenuRolService service;
	
	@GetMapping(value = "/{idMenu}")
	public ResponseEntity<List<MenuRol>> listar(@PathVariable("idMenu") Integer idMenu) {
		List<MenuRol> menuroles = new ArrayList<>();
		menuroles = service.listarRolesPorMenu(idMenu);
		return new ResponseEntity<List<MenuRol>>(menuroles, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody MenuListaRolDTO dto) {
		MenuListaRolDTO menu = service.registrarTransaccional(dto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(menu.getMenu().getIdMenu()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/delete")
	public ResponseEntity<Object> eliminar(@Valid @RequestBody MenuListaRolDTO dto) {
		try {
			service.eliminarTransaccional(dto);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
