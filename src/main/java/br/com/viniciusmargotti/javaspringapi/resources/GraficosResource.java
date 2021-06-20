package br.com.viniciusmargotti.javaspringapi.resources;

import br.com.viniciusmargotti.javaspringapi.dtos.GraficoDTO;
import br.com.viniciusmargotti.javaspringapi.models.Grafico;
import br.com.viniciusmargotti.javaspringapi.repository.GraficoRepository;
import br.com.viniciusmargotti.javaspringapi.services.GraficoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "Gráficos")
@RequestMapping(value = "/graficos")
@CrossOrigin
public class GraficosResource {

    @Autowired
    private GraficoRepository graficoRepository;

    @Autowired
    private GraficoService graficoService;

    @Autowired
    private GraficoDTO.Builder grb;

    @ApiOperation(value = "Delete um gráfico")
    @PostMapping("delete")
    public ResponseEntity<GraficoDTO> delete(@RequestBody @Valid GraficoDTO graficoDTO) {
        return new ResponseEntity<>(grb.toRepresentation(graficoService.deleteGrafico(graficoDTO)), HttpStatus.OK);
    }

    @ApiOperation(value = "Salva um novo gráfico")
    @PostMapping("save")
    public ResponseEntity<GraficoDTO> save(@RequestBody @Valid GraficoDTO graficoDTO) {
        return new ResponseEntity<>(grb.toRepresentation(graficoService.saveGrafico(graficoDTO)), HttpStatus.OK);
    }

    @ApiOperation(value = "Deleta um gráfico")
    @PostMapping("delete/{id}")
    public ResponseEntity<GraficoDTO> save(@PathVariable long idGrafico) {
        Grafico grafico = graficoRepository.findById(idGrafico).get();
        graficoRepository.delete(grafico);
        return  ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Busca todos os gráficos")
    @GetMapping("getAll/{idUsuario}")
    public ResponseEntity<List<GraficoDTO>> getAll(@PathVariable Integer idUsuario) {
        return new ResponseEntity<>(grb.toListRepresentation(graficoRepository.getByIdUsuario(idUsuario)), HttpStatus.OK);
    }


}
