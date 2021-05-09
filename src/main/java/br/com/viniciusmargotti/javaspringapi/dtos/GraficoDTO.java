package br.com.viniciusmargotti.javaspringapi.dtos;

import br.com.viniciusmargotti.javaspringapi.models.Grafico;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class GraficoDTO implements Serializable {

    private Long id;

    @NotBlank(message = "Os campos são obrigatório")
    private String campos;

    @NotBlank(message = "O campo valores é obrigatório")
    private String valores;

    @NotBlank(message = "O campo cor é obrigatório")
    private String cor;

    @NotBlank(message = "O campo titulo é obrigatório")
    private String titulo;

    @NotNull(message = "O campo borda é obrigatório")
    private Integer borda;

    @NotNull(message = "O campo idUsuario é obrigatório")
    private Integer idUsuario;


    public GraficoDTO() {
    }

    @Component
    public static class Builder {

        @Autowired
        private PessoaDTO.Builder prb;

        @Autowired
        private PasswordEncoder passwordEncoder;

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

        public GraficoDTO build() {
            GraficoDTO grafico = new GraficoDTO();
           grafico.id = this.id;
           grafico.borda = this.borda;
           grafico.campos = this.campos;
           grafico.cor = this.cor;
           grafico.titulo = this.titulo;
           grafico.valores = this.valores;
           grafico.idUsuario = this.idUsuario;
           grafico.titulo = this.titulo;
           return grafico;
        }

        public GraficoDTO toRepresentation(Grafico entity) {

            GraficoDTO grafico = new Builder()
                    .id(entity.getId())
                    .borda(borda)
                    .campos(campos)
                    .valores(valores)
                    .cor(cor)
                    .idUsuario(idUsuario).build();

            return grafico;
        }

        public List<GraficoDTO> toListRepresentation(List<Grafico> graficos){
            return graficos.stream().map(this::toRepresentation).collect(Collectors.toList());
        }
    }
}
