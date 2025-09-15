package Controller;


import Dto.ClientesDTO;
import Dto.ClientesResponseDTO;
import Dto.ContatoResponseDTO;
import Model.Cadastro_Cliente;
import Service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


    @Autowired
    private ClientesService clientesService;

    @PostMapping("path")
    public ResponseEntity<Cadastro_Cliente> criar(@RequestBody ClientesDTO dto){
        Cadastro_Cliente clienteSalvo = clientesService.salavrCliente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<ClientesResponseDTO>> listarTodos(@RequestParam String param){
        return ResponseEntity.ok(clientesService.listarTodos());
    }

    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<ContatoResponseDTO>> listarContatos(@PathVariable Long id){
        return ResponseEntity.ok(clientesService.listarContatosPorCliente(id));
    }

}
