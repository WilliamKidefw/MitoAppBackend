package com.mitocode.dto;

import java.util.List;

import com.mitocode.model.Menu;
import com.mitocode.model.Rol;

public class MenuListaRolDTO {

	private Menu menu;
	private List<Rol> lstRol;
	
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public List<Rol> getLstRol() {
		return lstRol;
	}
	public void setLstRol(List<Rol> lstRol) {
		this.lstRol = lstRol;
	}
	
	
}
