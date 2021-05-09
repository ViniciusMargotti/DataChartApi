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
                .campos(graficoDTO.getCampos())
                .cor(graficoDTO.getCor())
                .borda(graficoDTO.getBorda())
                .idUsuario(graficoDTO.getIdUsuario())
                .titulo(graficoDTO.getTitulo())
                .valores(graficoDTO.getCampos()).build();

        return graficoRepository.save(grafico);
    }


}
