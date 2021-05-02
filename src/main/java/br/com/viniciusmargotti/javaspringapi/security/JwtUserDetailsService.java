package br.com.viniciusmargotti.javaspringapi.security;

import java.util.ArrayList;

import br.com.viniciusmargotti.javaspringapi.models.Usuario;
import br.com.viniciusmargotti.javaspringapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService{

    private final UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public JwtUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario!= null) {
            return new User(usuario.getEmail(), usuario.getSenha(), AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado com email: " + email);
        }
    }

    public UserDetails authenticate(JwtRequest jwtRequest) throws UsernameNotFoundException {
        User user = (User) loadUserByUsername(jwtRequest.getUsername());
        if(passwordEncoder.matches(jwtRequest.getPassword(),user.getPassword())){
            return user;
        }else{
            throw new UsernameNotFoundException("Usuário não encontrado com email: " + jwtRequest.getUsername());
        }
    }
}