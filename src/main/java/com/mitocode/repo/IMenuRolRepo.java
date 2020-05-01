package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.MenuRol;

public interface IMenuRolRepo extends JpaRepository<MenuRol, Integer>{
	
	@Modifying
	@Query(value = "INSERT INTO menu_rol(id_menu, id_rol) VALUES (:idMenu, :idRol)", nativeQuery = true)
	Integer registrar(@Param("idMenu") Integer idMenu, @Param("idRol") Integer idRol);
	
	//@Transactional
	@Modifying
	@Query(value = "DELETE FROM menu_rol WHERE id_menu = :idMenu AND id_rol = :idRol", nativeQuery = true)
	void eliminar(@Param("idMenu") Integer idMenu, @Param("idRol") Integer idRol);
	
	@Query("from MenuRol mr where mr.menu.idMenu = :idMenu")
	List<MenuRol> listarRolesPorMenu(@Param("idMenu") Integer idMenu);
}
