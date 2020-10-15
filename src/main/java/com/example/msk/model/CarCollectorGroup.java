package com.example.msk.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CarCollectorGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String groupName;

    @ManyToMany
    private Set<Person> personSet;

    public CarCollectorGroup(int id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public CarCollectorGroup() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
