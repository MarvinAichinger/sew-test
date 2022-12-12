package at.htl.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Department extends PanacheEntity {

    public String name;

    public String location;

}
