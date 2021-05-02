package br.com.viniciusmargotti.javaspringapi.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class BairroDTO implements Serializable {

    @NotNull(message = "O bairro é obrigatorio")
    private Long id;

    private String nome;

    private CidadeDTO cidade;

    public BairroDTO() {
    }

    public static class Builder{

        private Long id;
        private String nome;
        private CidadeDTO cidade;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder cidade(CidadeDTO cidade) {
            this.cidade = cidade;
            return this;
        }

        public BairroDTO build() {
            BairroDTO bairro = new BairroDTO();
            bairro.id = this.id;
            bairro.nome = this.nome;
            bairro.cidade = this.cidade;

            return bairro;
        }
    }
}
