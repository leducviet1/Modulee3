package com.example.thuchanh1808.models;

public class Employee {
    public int id;
    public String fullName;
    public String phone;
    public String email;
    int departmentId;
    String departmentName;

    public Employee(String fullName,  String email,String phone, int departmentId) {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.departmentId = departmentId;
    }

    public Employee(int id, String fullName, String email, String phone, String departmentName) {
        this.email = email;
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Employee(int id, String fullName, String phone, String email, int departmentId) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public Employee() {
    }

    public Employee(String fullName, String email, String phone) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;

    }

    public Employee(int id, String fullName, String email, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfullName() {
        return fullName;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
