package br.com.viniciusmargotti.javaspringapi.services;

import br.com.viniciusmargotti.javaspringapi.dtos.PessoaDTO;
import br.com.viniciusmargotti.javaspringapi.dtos.UsuarioDTO;
import br.com.viniciusmargotti.javaspringapi.exceptions.ProcessException;
import br.com.viniciusmargotti.javaspringapi.models.Pessoa;
import br.com.viniciusmargotti.javaspringapi.models.Usuario;
import br.com.viniciusmargotti.javaspringapi.repository.BairroRepository;
import br.com.viniciusmargotti.javaspringapi.repository.PessoaRepository;
import br.com.viniciusmargotti.javaspringapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BairroRepository bairroRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaDTO.Builder prb;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario saveUsuario(UsuarioDTO usuarioDTO) {

        validaUsuarioDuplicado(usuarioDTO);

        Pessoa pessoa = prb.fromRepresentation(usuarioDTO.getPessoa());

        Pessoa entityPessoa = pessoaRepository.save(pessoa);

        Usuario usuario = new Usuario.Builder()
                .email(usuarioDTO.getEmail())
                .pessoa(entityPessoa)
                .senha(passwordEncoder.encode(usuarioDTO.getSenha())).build();

        return usuarioRepository.save(usuario);
    }

    private void validaUsuarioDuplicado(UsuarioDTO usuario) {
        Usuario usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioExistente != null) {
            throw new ProcessException("Já existe um usuário cadastrado para o email " + usuario.getEmail());
        }
    }
}
