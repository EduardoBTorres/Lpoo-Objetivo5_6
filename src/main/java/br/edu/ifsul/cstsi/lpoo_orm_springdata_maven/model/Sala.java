package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Sala")  // Colocando nome da entidade para o JPA
@Table(name = "salas") // Colocando nome para entidade/tabela no banco de dados
public class Sala {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int nrosala;
    private int capacidade;

    public int conSala(){
        return 0;
    }

    @OneToMany(mappedBy = "sala")
    private List<Sessao> sessoes;
}
