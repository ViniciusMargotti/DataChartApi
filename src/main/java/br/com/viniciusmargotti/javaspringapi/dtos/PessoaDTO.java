package br.com.viniciusmargotti.javaspringapi.dtos;

import br.com.viniciusmargotti.javaspringapi.models.Pessoa;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
public class PessoaDTO implements Serializable {


    private Long id;

    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;

    @NotBlank(message = "O campo sobrenome é obrigatório")
    private String sobrenome;

    public PessoaDTO() {
    }

    @Component
    public static class Builder extends PessoaDTO {

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


        public PessoaDTO build() {
            PessoaDTO pessoa = new PessoaDTO();
            pessoa.id = this.id;
            pessoa.nome = this.nome;
            pessoa.sobrenome = this.sobrenome;
            return pessoa;
        }

        public PessoaDTO toRepresentation(Pessoa entity) {

            PessoaDTO pessoa = new Builder()
                    .id(entity.getId())
                    .nome(entity.getNome())
                    .sobrenome(entity.getSobrenome());

            return pessoa;
        }

        public Pessoa fromRepresentation(PessoaDTO entity) {


            Pessoa pessoa = new Pessoa.Builder()
                    .id(entity.getId())
                    .nome(entity.getNome())
                    .sobrenome(entity.getSobrenome())
                    .build();

            return pessoa;
        }
    }
}
