package com.gms.dto;

import com.gms.enums.State;

public class AccountListItemDto {

    private Long accountId;
    private String name;
    private String dob;
    private String fathersName;
    private String mothersName;
    private String mobile1;
    private String email1;
    private double height;
    private double weight;
    private String qualification;

    public AccountListItemDto() {
    }

    public AccountListItemDto(Long accountId, String name, String dob, String fathersName, String mothersName, String mobile1, String email1, double height, double weight, String qualification) {
        this.accountId = accountId;
        this.name = name;
        this.dob = dob;
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.mobile1 = mobile1;
        this.email1 = email1;
        this.height = height;
        this.weight = weight;
        this.qualification = qualification;
    }

}
