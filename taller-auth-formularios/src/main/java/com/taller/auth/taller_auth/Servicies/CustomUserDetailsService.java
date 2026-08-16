package com.taller.auth.taller_auth.Servicies;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.taller.auth.taller_auth.Repositories.UsuariosRepository;
import com.taller.auth.taller_auth_formularios.Model.Usuarios;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuariosRepository usuariosRepository;

    CustomUserDetailsService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios u = usuariosRepository.findByUsername(username);
        
        // Si el usuario no existe, lanza excepción
        if (u == null) {
            throw new UsernameNotFoundException("No existe: " + username);
        }
        
        // Construye un UserDetails usando el patrón Builder de Spring Security
        return User.builder()
            .username(u.getUsername())
            .password(u.getPassword())      // ya codificada con BCrypt
            .roles(u.getRol())
            .build();
        }
            
}
