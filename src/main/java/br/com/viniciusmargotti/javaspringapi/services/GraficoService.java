package br.com.viniciusmargotti.javaspringapi.services;

import br.com.viniciusmargotti.javaspringapi.dtos.GraficoDTO;
import br.com.viniciusmargotti.javaspringapi.models.Grafico;
import br.com.viniciusmargotti.javaspringapi.repository.GraficoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraficoService {

    @Autowired
    private GraficoRepository graficoRepository;

    public Grafico saveGrafico(GraficoDTO graficoDTO) {

        Grafico grafico = new Grafico.Builder()
                .id(graficoDTO.getId())
                .campos(graficoDTO.getCampos())
                .borda(graficoDTO.getBorda())
                .cor(graficoDTO.getCor())
                .idUsuario(graficoDTO.getIdUsuario())
                .titulo(graficoDTO.getTitulo())
                .tipoGrafico(graficoDTO.getTipoGrafico())
                .valores(graficoDTO.getValores()).build();

        return graficoRepository.save(grafico);
    }


}
