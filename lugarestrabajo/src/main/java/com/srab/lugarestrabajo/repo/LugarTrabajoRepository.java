package com.srab.lugarestrabajo.repo;

import com.srab.lugarestrabajo.db.LugarTrabajo;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LugarTrabajoRepository implements PanacheRepositoryBase<LugarTrabajo, Integer> {

}
