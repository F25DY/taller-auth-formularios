package com.taller.auth.taller_auth.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taller.auth.taller_auth.Model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

        Usuarios findByUsername(String username);

    }
