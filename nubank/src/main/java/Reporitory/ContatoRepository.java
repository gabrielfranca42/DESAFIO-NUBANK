package Reporitory;

import Model.Cadastro_Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Cadastro_Contato, Long> {
}
