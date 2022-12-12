package at.htl.repo;

import at.htl.model.Department;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DeparmentRepo implements PanacheRepository<Department> {



}
