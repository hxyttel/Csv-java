package com.csv.bean;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

public class Contact  implements Serializable {
    @CsvBindByName(column = "id")
    private String id;
    @CsvBindByName(column = "user_name")
    private String name;
    @CsvBindByName(column = "sex")
    private String sex;
    @CsvBindByName(column = "phone")
    private String phone;
    @CsvBindByName(column = "address")
    private String address;

    public Contact() {
    }

    public Contact(String id, String name, String sex, String phone, String address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

