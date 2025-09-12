package Service;

import Dto.ClientesDTO;
import Dto.ClientesResponseDTO;
import Model.Cadastro_Cliente;
import Model.Cadastro_Contato;
import Reporitory.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ClientesService {


    @Autowired
    private ClienteRepository clienteRepository;

    public Cadastro_Cliente salavrCliente(ClientesDTO dto){
        Cadastro_Cliente cadastroCliente = new Cadastro_Cliente();
        cadastroCliente.setNome(dto.getNome());

        if (dto.getCadastro_contato() != null && dto.getCadastro_contato().size() > 0){
            List<Cadastro_Contato> cadastrocontato = dto.getCadastro_contato().stream().map(c -> {
                Cadastro_Contato cadastro_contato = new Cadastro_Contato();
                cadastro_contato.setTelefone(c.getTelefone());
                cadastro_contato.setEmail(c.getEmail());
                cadastro_contato.setCadastroCliente(cadastroCliente);
                return cadastro_contato;
            }).collect(Collectors.toList());
            cadastroCliente.setCadastro_contato(cadastrocontato);
        }
        return clienteRepository.save(cadastroCliente);
    }

    public List<ClientesResponseDTO> listarTodos(){
        return clienteRepository.findAll().stream().map(mapper:null)
    }

    private ClientesResponseDTO toDTO(Cadastro_Cliente cadastroCliente){
        ClientesResponseDTO dto = new ClientesResponseDTO();
        dto.setId(cadastroCliente.getId());
    }


}
