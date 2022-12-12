package at.htl.model;

import com.fasterxml.jackson.annotation.*;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Employee.getStaffFromId", query = "select e from Employee e where e.manager.id = ?1"),
        @NamedQuery(name = "Employee.getStaffFromFirstnameAndLastname", query = "select e from Employee e where e.firstname = ?1 and e.lastname = ?2"),
        @NamedQuery(name = "Employee.getStaffFromFirstname", query = "select e from Employee e where e.firstname = ?1"),
        @NamedQuery(name = "Employee.getStaffFromLastname", query = "select e from Employee e where e.lastname = ?1"),
})
public class Employee extends PanacheEntity {

    @Column(length = 50)
    public String firstname;

    @Column(length = 50)
    public String lastname;

    @ManyToOne
    public Department department;

    @ManyToOne
    @JsonIgnoreProperties({"firstname", "lastname", "department", "manager", "staff"})
    public Employee manager;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager", fetch = FetchType.EAGER)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId = true)
    public List<Employee> staff;

}
