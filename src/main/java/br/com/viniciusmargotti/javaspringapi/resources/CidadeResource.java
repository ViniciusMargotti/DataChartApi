package br.com.viniciusmargotti.javaspringapi.resources;

import br.com.viniciusmargotti.javaspringapi.models.Cidade;
import br.com.viniciusmargotti.javaspringapi.repository.CidadeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="Cidades")
@RequestMapping(value="/cidades")
@CrossOrigin
public class CidadeResource {

    @Autowired
    private CidadeRepository cidadeRepository;

    @ApiOperation(value="Busca cidade por estado")
    @RequestMapping(method = RequestMethod.GET,value = "/{idEstado}")
    public ResponseEntity<List<Cidade>> findByEstadoId(@PathVariable Long idEstado) {
        return new ResponseEntity(cidadeRepository.findByEstadoId(idEstado), HttpStatus.OK);
    }

}
