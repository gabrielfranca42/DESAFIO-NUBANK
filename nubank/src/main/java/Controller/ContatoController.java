package Controller;


import Dto.ContatoDTO;
import Model.Cadastro_Cliente;
import Model.Cadastro_Contato;
import Reporitory.ClienteRepository;
import Reporitory.ContatoRepository;
import jakarta.security.auth.message.ClientAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping ("/contatos")
public class ContatoController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContatoRepository contatoRepository;


    @PostMapping
    public ResponseEntity<?> criar(@RequestBody ContatoDTO dto){

        Optional<Cadastro_Cliente> clientesOpt = clienteRepository.findById(dto.getId());
        if (clientesOpt.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("vc se fudeo ");
        }

        Cadastro_Contato cadastro_contato = new Cadastro_Contato();
        cadastro_contato.setTelefone(dto.getTelefone());
        cadastro_contato.setEmail(dto.getEmail());
        cadastro_contato.setCadastroCliente(clientesOpt.get());
        contatoRepository.save(cadastro_contato);


        return ResponseEntity.status(HttpStatus.CREATED).body(cadastro_contato);
    }

}
