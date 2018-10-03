package com.gms.account;

import com.gms.account.enums.State;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private String resCity;
    private State resState;
    private String workCity;
    private State workState;
    private boolean ownHouse;
    private boolean onlyChild;
    private String details;

    public Account() {
    }

    public Account(Long accountId, String name, String dob, String fathersName, String mothersName, String mobile1, String mobile2, String email1, String email2, double height, double weight, String qualification, String occupation, Long income, String resCity, State resState, String workCity, State workState, boolean ownHouse, boolean onlyChild, String details) {
        this.accountId = accountId;
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
        this.resCity = resCity;
        this.resState = resState;
        this.workCity = workCity;
        this.workState = workState;
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

    public String getResCity() {
        return resCity;
    }

    public void setResCity(String resCity) {
        this.resCity = resCity;
    }

    public State getResState() {
        return resState;
    }

    public void setResState(State resState) {
        this.resState = resState;
    }

    public String getWorkCity() {
        return workCity;
    }

    public void setWorkCity(String workCity) {
        this.workCity = workCity;
    }

    public State getWorkState() {
        return workState;
    }

    public void setWorkState(State workState) {
        this.workState = workState;
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
