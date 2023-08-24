package com.student.manage;

public class Manage {
    private int id;
    private String name;
    private String designation;
    private String phone;
    private String salary;

    public Manage(int id, String name, String designation, String phone, String salary) {
        super();
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.phone = phone;
        this.salary = salary;
    }

    public Manage(String name, String designation, String phone, String salary) {
        super();
        this.name = name;
        this.designation = designation;
        this.phone = phone;
        this.salary = salary;
    }

    public Manage() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Manage [id=" + id + ", name=" + name + ", designation=" + designation + ", phone=" + phone + ", salary="
                + salary + "]";
    }

}
