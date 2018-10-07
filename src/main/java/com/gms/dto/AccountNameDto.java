package com.gms.dto;

public class AccountNameDto {

    private Long accountId;
    private String name;
//    private String dob;
//    private String fathersName;
//    private String mothersName;
    private String mobile1;
//    private String mobile2;
//    private String email1;
//    private String email2;
//    private double height;
//    private double weight;
//    private String qualification;
//    private String occupation;
//    private Long income;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Address.class)
////    @Column(name = "residenceAddressId")
//    private Address residenceAddressId;
//
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Address.class)
////    @Column(name = "correspondenceAddressId")
//    private Address correspondenceAddressId;

//    private boolean ownHouse;
//    private boolean onlyChild;
//    private String details;

    public AccountNameDto(Long a, String name, String mobile1) {
        this.accountId = a;
        this.name = name;
        this.mobile1 = mobile1;
    }

//    public AccountNameDto(String name, String dob, String fathersName, String mothersName, String mobile1, String mobile2, String email1, String email2, String qualification, String occupation, String details) {
//        this.name = name;
//        this.dob = dob;
//        this.fathersName = fathersName;
//        this.mothersName = mothersName;
//        this.mobile1 = mobile1;
//        this.mobile2 = mobile2;
//        this.email1 = email1;
//        this.email2 = email2;
//        this.qualification = qualification;
//        this.occupation = occupation;
//        this.details = details;
//    }
//
//    public AccountNameDto(String name) {
//        this.name = name;
//    }
}
