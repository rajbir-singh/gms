package com.gms.domain;

import com.gms.enums.State;

import javax.persistence.*;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long accountId;
    private String name;
    private String dob;
    private String fathersName;
    private String mothersName;
    private String mobile1;
    private String mobile2;
    private String email1;
    private String email2;
    private double height;
    private double weight;
    private String qualification;
    private String occupation;
    private Long income;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Address.class)
    private Address residenceAddress;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Address.class)
    private Address correspondenceAddress;

    private boolean ownHouse;
    private boolean onlyChild;
    private String details;

    public Account() {
    }

    public Account(String name, String dob, String fathersName, String mothersName, String mobile1, String mobile2, String email1, String email2, double height, double weight, String qualification, String occupation, Long income, Address residenceAddress, Address correspondenceAddress, boolean ownHouse, boolean onlyChild, String details) {
        this.name = name;
        this.dob = dob;
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.mobile1 = mobile1;
        this.mobile2 = mobile2;
        this.email1 = email1;
        this.email2 = email2;
        this.height = height;
        this.weight = weight;
        this.qualification = qualification;
        this.occupation = occupation;
        this.income = income;
        this.residenceAddress = residenceAddress;
        this.correspondenceAddress = correspondenceAddress;
        this.ownHouse = ownHouse;
        this.onlyChild = onlyChild;
        this.details = details;
    }

    public Account(String name) {
        this.name = name;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Long getIncome() {
        return income;
    }

    public void setIncome(Long income) {
        this.income = income;
    }

    public Address getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(Address residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public Address getCorrespondenceAddress() {
        return correspondenceAddress;
    }

    public void setCorrespondenceAddress(Address correspondenceAddress) {
        this.correspondenceAddress = correspondenceAddress;
    }

    public boolean isOwnHouse() {
        return ownHouse;
    }

    public void setOwnHouse(boolean ownHouse) {
        this.ownHouse = ownHouse;
    }

    public boolean isOnlyChild() {
        return onlyChild;
    }

    public void setOnlyChild(boolean onlyChild) {
        this.onlyChild = onlyChild;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
