package com.srab.horarios.repo;

import com.srab.horarios.db.Horario;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HorarioRepository implements PanacheRepositoryBase<Horario, Integer> {

}
