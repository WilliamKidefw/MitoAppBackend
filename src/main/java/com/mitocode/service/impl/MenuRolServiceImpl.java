package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.dto.MenuListaRolDTO;
import com.mitocode.model.MenuRol;
import com.mitocode.repo.IMenuRolRepo;
import com.mitocode.service.IMenuRolService;

@Service
public class MenuRolServiceImpl implements IMenuRolService {

	@Autowired
	private IMenuRolRepo repo;
	
	@Override
	public List<MenuRol> listarRolesPorMenu(Integer idMenu) {
		return repo.listarRolesPorMenu(idMenu);
	}

	@Transactional
	@Override
	public MenuListaRolDTO registrarTransaccional(MenuListaRolDTO dto) {
			
		dto.getLstRol().forEach(ex -> repo.registrar(dto.getMenu().getIdMenu(), ex.getIdRol()));
		
		return dto;
	}

	@Transactional
	@Override
	public void eliminarTransaccional(MenuListaRolDTO dto) {
		
		dto.getLstRol().forEach(ex -> repo.eliminar(dto.getMenu().getIdMenu(), ex.getIdRol()));
	}

}
