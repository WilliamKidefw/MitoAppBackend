package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.dto.UsuarioListaRolDTO;
import com.mitocode.model.UsuarioRol;
import com.mitocode.repo.IUsuarioRolRepo;
import com.mitocode.service.IUsuarioRolService;

@Service
public class UsuarioRolServiceImpl implements IUsuarioRolService {

	@Autowired
	private IUsuarioRolRepo repo;

	@Override
	public List<UsuarioRol> listarRolesPorUsuario(Integer idUsuario) {
		return repo.listarRolesPorUsuario(idUsuario);
	}

	@Transactional
	@Override
	public UsuarioListaRolDTO registrarTransaccional(UsuarioListaRolDTO dto) {
		dto.getLstRol().forEach(ex -> repo.registrar(dto.getUsuario().getIdUsuario(), ex.getIdRol()));
		
		return dto;
	}

	@Transactional
	@Override
	public void eliminarTransaccional(UsuarioListaRolDTO dto) {
		dto.getLstRol().forEach(ex -> repo.eliminar(dto.getUsuario().getIdUsuario(), ex.getIdRol()));
	}
	


}
