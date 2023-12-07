package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.salas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SalaRepository extends JpaRepository<Sala,Long> { //classe de modelo, tipo do identificador
//    @Query(value = "SELECT c FROM Sala c where c.id like ?1")
//    Optional<Sala> findById(Long id);
//findSalaByCapacidade
//    int findByCapacidade(String s);

      @Query(value = "SELECT s FROM Sala s where s.capacidade = ?1")
      List<Sala> getSalaByCapacidade(Integer capacidade);

}
