package com.mitocode.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitocode.model.Usuario;

public interface IUserService extends ICRUD<Usuario, Integer> {

	Page<Usuario> listarPageable(Pageable pageable);
}
