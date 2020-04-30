package com.mitocode.service;

import java.util.List;

import com.mitocode.dto.MenuListaRolDTO;
import com.mitocode.model.MenuRol;

public interface IMenuRolService {

	List<MenuRol> listarRolesPorMenu(Integer idMenu);
	
	MenuListaRolDTO registrarTransaccional(MenuListaRolDTO dto);
	
	void eliminarTransaccional(MenuListaRolDTO dto);
}
