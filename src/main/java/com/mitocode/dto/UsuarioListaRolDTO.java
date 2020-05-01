package com.mitocode.dto;

import java.util.List;

import com.mitocode.model.Rol;
import com.mitocode.model.Usuario;

public class UsuarioListaRolDTO {

	private Usuario usuario;
	private List<Rol> lstRol;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Rol> getLstRol() {
		return lstRol;
	}
	public void setLstRol(List<Rol> lstRol) {
		this.lstRol = lstRol;
	}
	
	
}
