package com.gms.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dummy {
    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private Long accountId;
    private String name;

    public Dummy() {
    }

//    public Dummy(Long accountId, String name) {
    public Dummy(String name) {
        this.name = name;
    }

//    public Long getAccountId() {
//        return accountId;
//    }
//
//    public void setAccountId(Long accountId) {
//        this.accountId = accountId;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
