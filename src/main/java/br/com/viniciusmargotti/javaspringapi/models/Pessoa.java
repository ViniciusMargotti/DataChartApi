package br.com.viniciusmargotti.javaspringapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    public Pessoa() {
    }

    public static class Builder {

        private Long id;
        private String nome;
        private String sobrenome;

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


        public Pessoa build() {
            Pessoa pessoa = new Pessoa();
            pessoa.id = this.id;
            pessoa.nome = this.nome;
            pessoa.sobrenome = this.sobrenome;
            return pessoa;
        }
    }
}
