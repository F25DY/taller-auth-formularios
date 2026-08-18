package com.taller.auth.taller_auth.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.taller.auth.taller_auth.Repositories.UsuariosRepository;
import com.taller.auth.taller_auth_formularios.Model.Usuarios;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(UsuariosRepository repo, PasswordEncoder encoder) 
    {
        return args -> {
            // Crear un usuario de ejemplo
            if (repo.findByUsername("admin")==null){
                Usuarios a = new Usuarios();
                a.setUsername("admin");
                a.setPassword(encoder.encode("admin123"));
                a.setRol("ADMIN");
                repo.save(a);
            }
        };
    }
}
