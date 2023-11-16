package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity(name = "Sessao") // Colocando nome da entidade para o JPA
@Table(name = "sessoes") // Colocando nome para entidade/tabela no banco de dados

public class Sessao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date dt_sessao;
    private Time hora_sessao;
    private double valor_inteira;
    private double valor_meia;
    private int encerrada;

    public String selSessao(){
        return null;
    }
    @ManyToOne
    private Sala sala;

    @ManyToOne
    private Filme filme;

    @OneToMany
    private List<Ingresso> ingressos;
}
