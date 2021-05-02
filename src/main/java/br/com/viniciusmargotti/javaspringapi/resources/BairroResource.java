package br.com.viniciusmargotti.javaspringapi.resources;

import br.com.viniciusmargotti.javaspringapi.models.Bairro;
import br.com.viniciusmargotti.javaspringapi.repository.BairroRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="Bairros")
@RequestMapping(value="/bairros")
@CrossOrigin
public class BairroResource {

    @Autowired
    private BairroRepository bairroRepository;

    @ApiOperation(value="Busca bairro por cidade")
    @RequestMapping(method = RequestMethod.GET,value = "/{idCidade}")
    public ResponseEntity<List<Bairro>> findByEstadoId(@PathVariable Long idCidade) {
        return new ResponseEntity(bairroRepository.findByCidadeId(idCidade), HttpStatus.OK);
    }
}
