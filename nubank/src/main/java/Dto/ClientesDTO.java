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


public class ClientesDTO {


    private String nome;
    private List<ContatoDTO> cadastro_contato;
}
