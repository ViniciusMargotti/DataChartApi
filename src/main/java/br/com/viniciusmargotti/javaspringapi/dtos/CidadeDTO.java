package br.com.viniciusmargotti.javaspringapi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CidadeDTO implements Serializable {

    private Long id;
    private String nome;
    private Integer codigo_ibge ;
    private EstadoDTO estado;

    public CidadeDTO() {
    }

    public static class Builder{

        private Long id;
        private String nome;
        private Integer codigo_ibge;
        private EstadoDTO estado;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder codigo_ibge(Integer codigo_ibge) {
            this.codigo_ibge = codigo_ibge;
            return this;
        }

        public Builder estado(EstadoDTO estado) {
            this.estado = estado;
            return this;
        }

        public CidadeDTO build() {
            CidadeDTO cidade = new CidadeDTO();
            cidade.id = this.id;
            cidade.nome = this.nome;
            cidade.estado = this.estado;
            cidade.codigo_ibge = this.codigo_ibge;

            return cidade;
        }
    }
}
