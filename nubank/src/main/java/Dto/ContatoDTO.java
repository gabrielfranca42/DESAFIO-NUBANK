package Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContatoDTO {

    private Long id ;
    private String telefone;
    private String email;
    private String clienteId;
}
