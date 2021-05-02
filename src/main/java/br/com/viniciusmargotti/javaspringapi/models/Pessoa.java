package br.com.viniciusmargotti.javaspringapi.models;

import br.com.viniciusmargotti.javaspringapi.dtos.PessoaDTO;
import br.com.viniciusmargotti.javaspringapi.dtos.UsuarioDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="PESSOAS")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull(message = "O campo nome é obrigatório")
    @Column(name = "NOME")
    private String nome;

    @NotNull(message = "O campo nome é obrigatório")
    @Column(name = "SOBRENOME")
    private String sobrenome;

    @NotNull(message = "O campo numero é obrigatório")
    @Column(name = "ENDERECO")
    private String endereco;

    @NotNull(message = "O campo cep é obrigatório")
    @Column(name = "CEP")
    private String cep;

    @NotNull(message = "O campo numero é obrigatório")
    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "REFERENCIA")
    private String referencia;

    @Valid
    @ManyToOne
    @JoinColumn(name = "ID_BAIRROS")
    private Bairro bairro;

    public Pessoa() {
    }

    public static class Builder {

        private Long id;
        private String nome;
        private String sobrenome;
        private String endereco;
        private String numero;
        private String complemento;
        private String referencia;
        private String cep;
        private Bairro bairro;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder sobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
            return this;
        }

        public Builder endereco(String endereco) {
            this.endereco = endereco;
            return this;
        }

        public Builder numero(String numero) {
            this.numero = numero;
            return this;
        }

        public Builder complemento(String complemento) {
            this.complemento = complemento;
            return this;
        }

        public Builder referencia(String referencia) {
            this.referencia = referencia;
            return this;
        }

        public Builder cep(String cep) {
            this.cep = cep;
            return this;
        }

        public Builder bairro(Bairro bairro) {
            this.bairro = bairro;
            return this;
        }

        public Pessoa build() {
            Pessoa pessoa = new Pessoa();
            pessoa.id = this.id;
            pessoa.nome = this.nome;
            pessoa.sobrenome = this.sobrenome;
            pessoa.endereco = this.endereco;
            pessoa.numero = this.numero;
            pessoa.complemento = this.complemento;
            pessoa.referencia = this.referencia;
            pessoa.cep = this.cep;
            pessoa.bairro = this.bairro;

            return pessoa;
        }
    }
}
