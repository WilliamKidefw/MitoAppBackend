package com.mitocode.service;

import java.util.List;

import com.mitocode.dto.UsuarioListaRolDTO;
import com.mitocode.model.UsuarioRol;

public interface IUsuarioRolService {

	List<UsuarioRol> listarRolesPorUsuario(Integer idUsuario);
	
	UsuarioListaRolDTO registrarTransaccional(UsuarioListaRolDTO dto);
	
	void eliminarTransaccional(UsuarioListaRolDTO dto);
}
