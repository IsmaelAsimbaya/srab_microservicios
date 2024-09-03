package com.srab.marcaciones.repo;

import com.srab.marcaciones.db.Marcacion;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MarcacionRepository implements PanacheRepositoryBase<Marcacion, Integer> {

}
