package Reporitory;


import Model.Cadastro_Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository  extends JpaRepository<Cadastro_Cliente, Long> {


}
