package at.htl.repo;

import at.htl.model.Employee;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class EmployeeRepo implements PanacheRepository<Employee> {

    public List<Employee> getStaffOf(Employee manager) {
        try {
            if (manager.id != null) {
//                String sql = "select e from Employee e where e.manager.id = :id";
//                return getEntityManager().createQuery(sql, Employee.class)
//                        .setParameter("id", manager.id)
//                        .getResultList();
//                return find("manager_id", manager.id).list();
                return find("#Employee.getStaffFromId", manager.id).list();
            } else {
                if (manager.firstname != null && manager.lastname != null) {
//                    String sql = "select e from Employee e where e.firstname = :fn and e.lastname = :ln";
//                    Employee mgr = getEntityManager().createQuery(sql, Employee.class)
//                            .setParameter("fn", manager.firstname)
//                            .setParameter("ln", manager.lastname)
//                            .getSingleResult();
//                    return mgr.staff;
                    return find("#Employee.getStaffFromFirstnameAndLastname", manager.firstname, manager.lastname).firstResult().staff;
                } else if (manager.firstname != null) {
//                    String sql = "select e from Employee e where e.firstname = :fn";
//                    Employee mgr = getEntityManager().createQuery(sql, Employee.class)
//                            .setParameter("fn", manager.firstname)
//                            .getSingleResult();
//                    return mgr.staff;
                    return find("#Employee.getStaffFromFirstname", manager.firstname).firstResult().staff;
                } else if (manager.lastname != null) {
//                    String sql = "select e from Employee e where e.lastname = :ln";
//                    Employee mgr = getEntityManager().createQuery(sql, Employee.class)
//                            .setParameter("ln", manager.lastname)
//                            .getSingleResult();
//                    return mgr.staff;
                    return find("#Employee.getStaffFromLastname", manager.lastname).firstResult().staff;
                } else {
                    return null;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
