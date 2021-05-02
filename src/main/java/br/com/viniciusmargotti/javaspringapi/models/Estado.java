package br.com.viniciusmargotti.javaspringapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="ESTADOS")
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull(message = "O campo nome é obrigatório")
    @Column(name = "NOME")
    private String nome;

    @NotNull(message = "O campo sigla é obrigatório")
    @Column(name = "SIGLA")
    private String sigla;

    public Estado() {
    }

    public static class Builder{

        private Long id;
        private String nome;
        private String sigla;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder sigla(String sigla) {
            this.sigla = sigla;
            return this;
        }

        public Estado build() {
            Estado estado = new Estado();
            estado.id = this.id;
            estado.nome = this.nome;
            estado.sigla = this.sigla;
            return estado;
        }

    }
}
