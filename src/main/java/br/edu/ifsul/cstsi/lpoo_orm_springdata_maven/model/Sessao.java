package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.salas.Sala;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity(name = "Sessao") // Colocando nome da entidade para o JPA
@Table(name = "sessoes") // Colocando nome para entidade/tabela no banco de dados
public class Sessao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dt_sessao;
    private LocalTime hora_sessao;
    private double valor_inteira;
    private double valor_meia;
    private int encerrada;

    public String selSessao(){
        return null;
    }
    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;

    @OneToMany(mappedBy = "sessao")
    private List<Ingresso> ingressos;
}
