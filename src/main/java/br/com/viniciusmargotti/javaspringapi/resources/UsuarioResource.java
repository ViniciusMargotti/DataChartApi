package br.com.viniciusmargotti.javaspringapi.resources;

import br.com.viniciusmargotti.javaspringapi.services.UsuarioService;
import br.com.viniciusmargotti.javaspringapi.dtos.UsuarioDTO;
import br.com.viniciusmargotti.javaspringapi.models.Usuario;
import br.com.viniciusmargotti.javaspringapi.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value="Usuarios")
@RequestMapping(value="/usuarios")
@CrossOrigin
public class UsuarioResource {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioDTO.Builder urb;

    @ApiOperation(value="Salva um novo usuário")
    @PostMapping("save")
    public ResponseEntity<UsuarioDTO> saveUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
            return new ResponseEntity<>(urb.toRepresentation(usuarioService.saveUsuario(usuarioDTO)), HttpStatus.OK);
    }

    @ApiOperation(value="Busca todos os usuários")
    @GetMapping("getAll")
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        return new ResponseEntity<>(urb.toListRepresentation(usuarioRepository.findAll()), HttpStatus.OK);
    }


}
