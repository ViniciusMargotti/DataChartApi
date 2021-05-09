package br.com.viniciusmargotti.javaspringapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "GRAFICOS")
public class Grafico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Os campos são obrigatórios")
    @Column(name = "CAMPOS")
    private String campos;

    @NotNull(message = "O campo valores é obrigatório")
    @Column(name = "VALORES")
    private String valores;

    @NotNull(message = "O campo cor é obrigatório")
    @Column(name = "COR")
    private String cor;

    @NotNull(message = "O campo título é obrigatório")
    @Column(name = "TITULO")
    private String titulo;

    @NotNull(message = "O campo cor é obrigatório")
    @Column(name = "BORDA")
    private Integer borda;

    @NotNull(message = "O campo idUsuario é obrigatório")
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    public Grafico() {
    }

    public static class Builder {

        private Long id;
        private String campos;
        private String valores;
        private String titulo;
        private String cor;
        private Integer borda;
        private Integer idUsuario;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder campos(String campos) {
            this.campos = campos;
            return this;
        }

        public Builder valores(String valores) {
            this.valores = valores;
            return this;
        }

        public Builder cor(String cor) {
            this.cor = cor;
            return this;
        }

        public Builder borda(Integer borda) {
            this.borda = borda;
            return this;
        }

        public Builder idUsuario(Integer idUsuario) {
            this.idUsuario = idUsuario;
            return this;
        }

        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Grafico build() {
            Grafico grafico = new Grafico();
            grafico.id = this.id;
            grafico.campos = this.campos;
            grafico.valores = this.valores;
            grafico.idUsuario = this.idUsuario;
            grafico.cor = this.cor;
            grafico.borda = this.borda;
            grafico.titulo = this.titulo;
            return grafico;
        }
    }
}
