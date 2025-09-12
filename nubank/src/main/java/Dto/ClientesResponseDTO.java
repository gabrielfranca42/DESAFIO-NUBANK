package Dto;


import Model.Cadastro_Contato;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ClientesResponseDTO {

    private Long id;
    private String nome;
    private List<ContatoResponseDTO> cadastro_contato;
}
