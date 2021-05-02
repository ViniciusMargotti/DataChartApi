package br.com.viniciusmargotti.javaspringapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="CIDADES")
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull(message = "O campo nome é obrigatório")
    @Column(name = "NOME")
    private String nome;

    @NotNull(message = "O campo slogan é obrigatório")
    @Column(name = "CODIGO_IBGE")
    private Integer codigo_ibge ;

    @NotNull(message = "A cidade deve estar vinculada a um estado")
    @ManyToOne
    @JoinColumn(name = "ID_ESTADOS")
    private Estado estado;

    public Cidade() {
    }

    public static class Builder{

        private Long id;
        private String nome;
        private Integer codigo_ibge;
        private Estado estado;

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

        public Builder estado(Estado estado) {
            this.estado = estado;
            return this;
        }

        public Cidade build() {
            Cidade cidade = new Cidade();
            cidade.id = this.id;
            cidade.nome = this.nome;
            cidade.estado = this.estado;
            cidade.codigo_ibge = this.codigo_ibge;

            return cidade;
        }
    }
}
