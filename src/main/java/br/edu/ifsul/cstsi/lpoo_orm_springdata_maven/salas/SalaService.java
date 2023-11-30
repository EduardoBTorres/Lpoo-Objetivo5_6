package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.salas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class SalaService {

    @Autowired
    private SalaRepository rep;

    public Sala insert(Sala sala) {
        Assert.isNull(sala.getId(),"Não foi possível inserir o registro");
        return rep.save(sala);
    }
}
