package com.srab.logins.repo;

import com.srab.logins.db.Login;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LoginRepository implements PanacheRepositoryBase<Login, Integer> {

}
