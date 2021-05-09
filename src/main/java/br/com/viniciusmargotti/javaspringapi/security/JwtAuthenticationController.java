package br.com.viniciusmargotti.javaspringapi.security;

import br.com.viniciusmargotti.javaspringapi.exceptions.ProcessException;
import br.com.viniciusmargotti.javaspringapi.models.Usuario;
import br.com.viniciusmargotti.javaspringapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    private class UserRetorno{
        public String token ;
        public Long UserId;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .authenticate(authenticationRequest);
        final String token = jwtTokenUtil.generateToken(userDetails);
        Usuario usuario = usuarioRepository.findByEmail(userDetails.getUsername());
        UserRetorno retorno = new UserRetorno();
        retorno.token = token;
        retorno.UserId = usuario.getId();
        return ResponseEntity.ok(retorno);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {
            throw new ProcessException("Atenção! Email ou senha inválidos");
        }
    }
}