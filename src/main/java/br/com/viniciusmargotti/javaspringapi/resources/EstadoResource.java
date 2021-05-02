package br.com.viniciusmargotti.javaspringapi.resources;

import br.com.viniciusmargotti.javaspringapi.models.Estado;
import br.com.viniciusmargotti.javaspringapi.repository.EstadoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value="Estados")
@RequestMapping(value="/estados")
@CrossOrigin
public class EstadoResource {

    @Autowired
    private EstadoRepository estadoRepository;

    @ApiOperation(value="Busca todas os estados")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Estado>> getAll() {
        return new ResponseEntity(estadoRepository.findAll(), HttpStatus.OK);
    }

}
