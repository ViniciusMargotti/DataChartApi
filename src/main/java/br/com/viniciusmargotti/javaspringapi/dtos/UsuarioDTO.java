package br.com.viniciusmargotti.javaspringapi.dtos;

import br.com.viniciusmargotti.javaspringapi.models.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UsuarioDTO implements Serializable {

    private Long id;

    @NotBlank(message = "O campo email é obrigatório")
    private String email;

    @NotBlank(message = "O campo senha é obrigatório")
    private String senha;

    @Valid
    private PessoaDTO pessoa;

    public UsuarioDTO() {
    }

    @Component
    public static class Builder {

        @Autowired
        private PessoaDTO.Builder prb;

        @Autowired
        private PasswordEncoder passwordEncoder;

        private Long id;
        private String email;
        private String senha;
        private PessoaDTO pessoa;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder senha(String senha) {
            this.senha = senha;
            return this;
        }

        public Builder pessoa(PessoaDTO pessoa) {
            this.pessoa = pessoa;
            return this;
        }

        public UsuarioDTO build() {
            UsuarioDTO usuario = new UsuarioDTO();
            usuario.id = this.id;
            usuario.email = this.email;
            usuario.senha = this.senha;
            usuario.pessoa = this.pessoa;

            return usuario;
        }

        public UsuarioDTO toRepresentation(Usuario entity) {

            UsuarioDTO usuario = new Builder()
                    .id(entity.getId())
                    .pessoa(prb.toRepresentation(entity.getPessoa()))
                    .email(entity.getEmail()).build();

            return usuario;
        }

        public List<UsuarioDTO> toListRepresentation(List<Usuario> usuarios){
            return usuarios.stream().map(this::toRepresentation).collect(Collectors.toList());
        }
    }
}
