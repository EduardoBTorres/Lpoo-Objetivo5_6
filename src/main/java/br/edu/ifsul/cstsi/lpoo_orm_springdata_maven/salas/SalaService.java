package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.salas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    @Autowired
    private SalaRepository rep;

    public List<Sala> getSala() {
        return rep.findAll();
    }

    public Sala getSalaById(Long id) {
        Optional<Sala> optional = rep.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public List<Sala> getSalaByCapacidade(Integer capacidade) {
        return new ArrayList<>(rep.getSalaByCapacidade(capacidade));
    }


    public Sala insert(Sala sala) {
        Assert.isNull(sala.getId(),"Não foi possível inserir o registro");
        return rep.save(sala);
    }

    public Sala update(Sala sala) {
        System.out.println(sala);
        Assert.notNull(sala.getId(),"Não foi possível atualizar o registro");

        // Busca o produto no banco de dados
        Optional<Sala> optional = rep.findById(sala.getId());
        if(optional.isPresent()) {
            Sala db = optional.get();
            // Copiar as propriedades
            db.setCapacidade(sala.getCapacidade());
            // Atualiza o produto
            rep.save(db);

            return db;
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }
}
