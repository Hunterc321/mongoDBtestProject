package com.example.demoprojectmongodb.model;

import com.example.demoprojectmongodb.student.Address;
import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

public class StudentModel extends RepresentationModel<StudentModel> {

    private String id;
    private String firstName;
    private String lastName;
    private Address address;

    public StudentModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentModel that = (StudentModel) o;
        return id !=null && this.id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
