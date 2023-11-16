package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Filmes") // Colocando nome da entidade para o JPA
@Table(name = "filmes") // Colocando nome para entidade/tabela no banco de dados

public class Filme {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String titulo;
    private double duracao;

    public String conFilme(){
        return null;
    }

    @OneToMany
    private List<Sessao> sessoes;

}
