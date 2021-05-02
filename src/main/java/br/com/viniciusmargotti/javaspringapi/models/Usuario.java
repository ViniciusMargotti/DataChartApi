package br.com.viniciusmargotti.javaspringapi.models;

import br.com.viniciusmargotti.javaspringapi.dtos.PessoaDTO;
import br.com.viniciusmargotti.javaspringapi.dtos.UsuarioDTO;
import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="USUARIOS")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull(message = "O campo email é obrigatório")
    @Column(name = "EMAIL")
    private String email;

    @NotNull(message = "O campo senha é obrigatório")
    @Column(name = "SENHA")
    private String senha;

    @Valid
    @ManyToOne
    @JoinColumn(name = "ID_PESSOAS")
    private Pessoa pessoa;

    public Usuario() {
    }

    public static class Builder{

        private Long id;
        private String email;
        private String senha;
        private Pessoa pessoa;

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

        public Builder pessoa(Pessoa pessoa) {
            this.pessoa = pessoa;
            return this;
        }

        public Usuario build() {
            Usuario usuario = new Usuario();
            usuario.id = this.id;
            usuario.email = this.email;
            usuario.senha = this.senha;
            usuario.pessoa = this.pessoa;

            return usuario;
        }
    }

}
