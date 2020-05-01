package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.UsuarioRol;

public interface IUsuarioRolRepo extends JpaRepository<UsuarioRol, Integer>{
	
	@Modifying
	@Query(value = "INSERT INTO usuario_rol(id_usuario, id_rol) VALUES (:idUsuario, :idRol)", nativeQuery = true)
	Integer registrar(@Param("idUsuario") Integer idUsuario, @Param("idRol") Integer idRol);
	
	//@Transactional
	@Modifying
	@Query(value = "DELETE FROM usuario_rol WHERE id_usuario = :idUsuario AND id_rol = :idRol", nativeQuery = true)
	void eliminar(@Param("idUsuario") Integer idUsuario, @Param("idRol") Integer idRol);
	
	@Query("from UsuarioRol ur where ur.usuario.idUsuario = :idUsuario")
	List<UsuarioRol> listarRolesPorUsuario(@Param("idUsuario") Integer idUsuario);
}
