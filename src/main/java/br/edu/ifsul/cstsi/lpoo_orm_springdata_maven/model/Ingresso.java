package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

@Entity(name = "Ingresso") // Colocando nome da entidade para o JPA
@Table(name = "ingressos") // Colocando nome para entidade/tabela no banco de dados
public class Ingresso {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int tipo;

    public int getIng() {
        return 0;
    }

    @ManyToOne
    @JoinColumn(name = "sessao_id")
    private Sessao sessao;
}
