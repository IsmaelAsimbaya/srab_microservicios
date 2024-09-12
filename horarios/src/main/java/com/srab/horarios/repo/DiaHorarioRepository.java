package com.srab.horarios.repo;

import com.srab.horarios.db.DiaHorario;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DiaHorarioRepository implements PanacheRepositoryBase<DiaHorario, Integer> {

}
