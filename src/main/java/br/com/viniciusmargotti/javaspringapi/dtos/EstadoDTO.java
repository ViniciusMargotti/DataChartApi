package br.com.viniciusmargotti.javaspringapi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EstadoDTO implements Serializable {

    private Long id;
    private String nome;
    private String sigla;

    public EstadoDTO() {
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

        public EstadoDTO build() {
            EstadoDTO estado = new EstadoDTO();
            estado.id = this.id;
            estado.nome = this.nome;
            estado.sigla = this.sigla;
            return estado;
        }

    }
}
