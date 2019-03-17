package com.example.hakanmovieapp.data;

public class Studio {

    private String name;

    private String founder;

    private String ownerCompany;

    public Studio(String name, String founder, String ownerCompany) {
        this.name = name;
        this.founder = founder;
        this.ownerCompany = ownerCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getOwnerCompany() {
        return ownerCompany;
    }

    public void setOwnerCompany(String ownerCompany) {
        this.ownerCompany = ownerCompany;
    }
}
