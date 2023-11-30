package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.salas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala,Long> { //classe de modelo, tipo do identificador
}
