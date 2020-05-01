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

import com.mitocode.dto.UsuarioListaRolDTO;
import com.mitocode.model.UsuarioRol;
import com.mitocode.service.IUsuarioRolService;

@RestController
@RequestMapping("/usuarioroles")
public class UsuarioRolController {
	
	@Autowired
	private IUsuarioRolService service;
	
	@GetMapping(value = "/{idUsuario}")
	public ResponseEntity<List<UsuarioRol>> listar(@PathVariable("idUsuario") Integer idUsuario) {
		List<UsuarioRol> usuarioroles = new ArrayList<>();
		usuarioroles = service.listarRolesPorUsuario(idUsuario);
		return new ResponseEntity<List<UsuarioRol>>(usuarioroles, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody UsuarioListaRolDTO dto) {
		UsuarioListaRolDTO usuario = service.registrarTransaccional(dto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(usuario.getUsuario().getIdUsuario()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/delete")
	public ResponseEntity<Object> eliminar(@Valid @RequestBody UsuarioListaRolDTO dto) {
		try {
			service.eliminarTransaccional(dto);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
