package br.com.viniciusmargotti.javaspringapi.dtos;

import br.com.viniciusmargotti.javaspringapi.models.Bairro;
import br.com.viniciusmargotti.javaspringapi.models.Pessoa;
import br.com.viniciusmargotti.javaspringapi.repository.BairroRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
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

    @NotBlank(message = "O campo endereco é obrigatório")
    private String endereco;

    @NotBlank(message = "O campo cep é obrigatório")
    private String cep;

    @NotBlank(message = "O campo numero é obrigatório")
    private String numero;

    private String complemento;

    private String referencia;

    @Valid
    private BairroDTO bairro;

    public PessoaDTO() {
    }

    @Component
    public static class Builder extends PessoaDTO {

        @Autowired
        private BairroRepository bairroRepository;

        private Long id;
        private String nome;
        private String sobrenome;
        private String endereco;
        private String numero;
        private String complemento;
        private String referencia;
        private String cep;
        private BairroDTO bairro;

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

        public Builder bairro(BairroDTO bairro) {
            this.bairro = bairro;
            return this;
        }

        public PessoaDTO build() {
            PessoaDTO pessoa = new PessoaDTO();
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

        public PessoaDTO toRepresentation(Pessoa entity) {

            PessoaDTO pessoa = new Builder()
                    .id(entity.getId())
                    .nome(entity.getNome())
                    .sobrenome(entity.getSobrenome())
                    .cep(entity.getCep())
                    .complemento(entity.getComplemento())
                    .referencia(entity.getReferencia())
                    .numero(entity.getNumero())
                    .endereco(entity.getEndereco()).build();

            return pessoa;
        }

        public Pessoa fromRepresentation(PessoaDTO entity) {

            Bairro bairro = entity.getBairro()!= null ? bairroRepository.findById(entity.getBairro().getId()).get() : null;

            Pessoa pessoa = new Pessoa.Builder()
                    .id(entity.getId())
                    .nome(entity.getNome())
                    .sobrenome(entity.getSobrenome())
                    .cep(entity.getCep())
                    .complemento(entity.getComplemento())
                    .referencia(entity.getReferencia())
                    .numero(entity.getNumero())
                    .endereco(entity.getEndereco())
                    .bairro(bairro)
                    .build();

            return pessoa;
        }
    }
}
