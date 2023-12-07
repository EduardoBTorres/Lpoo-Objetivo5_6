package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.salas;

import br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model.Sessao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Sala")  // Colocando nome da entidade para o JPA
@Table(name = "salas") // Colocando nome para entidade/tabela no banco de dados
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sala {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer nrosala;
    private Integer capacidade;

    public int conSala(){
        return 0;
    }

    @OneToMany(mappedBy = "sala", fetch = FetchType.LAZY)
    private List<Sessao> sessoes;

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", nrosala=" + nrosala +
                ", capacidade=" + capacidade +
                '}';
    }
}
