package br.com.viniciusmargotti.javaspringapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="BAIRROS")
public class Bairro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull(message = "O campo nome é obrigatório")
    @Column(name = "NOME")
    private String nome;

    @NotNull(message = "A cidade deve estar vinculada a um estado")
    @ManyToOne
    @JoinColumn(name = "ID_CIDADES")
    private Cidade cidade;

    public Bairro() {
    }

    public static class Builder{

        private Long id;
        private String nome;
        private Cidade cidade;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder cidade(Cidade cidade) {
            this.cidade = cidade;
            return this;
        }

        public Bairro build() {
            Bairro bairro = new Bairro();
           bairro.id = this.id;
           bairro.nome = this.nome;
           bairro.cidade = this.cidade;

           return bairro;
        }
    }


}
