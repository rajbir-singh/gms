package com.gms.domain;

import com.gms.dto.AccountNameDto;

import javax.persistence.*;
import java.util.List;

//select accountId, name, dob, fathersName, mothersName, mobile1, mobile2, email1, email2, height, weight, qualification, occupation, income, ownHouse, onlyChild, details from account
@NamedNativeQuery(name = "AccountNameQuery", resultClass = AccountNameDto.class, resultSetMapping = "AccountNameMapping", query = "select a.accountId, a.name, a.mobile1 from account a")
@SqlResultSetMappings(
        @SqlResultSetMapping(
        name = "AccountNameMapping",
        classes = {
                @ConstructorResult(
//                        targetClass = com.gms.domain.Account.class,
                        targetClass = com.gms.dto.AccountNameDto.class,
                        columns = {
                                @ColumnResult(name = "account_Id", type = Long.class),
                                @ColumnResult(name = "name"),
                                @ColumnResult(name = "mobile1")
                        }
                )
        }
)
)


//@NamedNativeQuery(name = "AccountComplexQuery", resultClass = AccountNameDto.class, resultSetMapping = "AccountcomplexMapping", query = "select name, dob, fathersName, mothersName, mobile1, mobile2, email1, email2, qualification, occupation, details from account")
//@SqlResultSetMapping(
//        name = "AccountComplexMapping",
//        classes = {
//                @ConstructorResult(
////                        targetClass = com.gms.domain.Account.class,
//                        targetClass = AccountNameDto.class,
//                        columns = {
//                                @ColumnResult(name = "name"),
////                                @ColumnResult(name = "accountId", type = Long.class),
//                                @ColumnResult(name = "dob"),
//                                @ColumnResult(name = "fathersName"),
//                                @ColumnResult(name = "mothersName"),
//                                @ColumnResult(name = "mobile1"),
//                                @ColumnResult(name = "mobile2"),
//                                @ColumnResult(name = "email1"),
//                                @ColumnResult(name = "email2"),
////                                @ColumnResult(name = "height", type = Double.class),
////                                @ColumnResult(name = "weight", type = Double.class),
//                                @ColumnResult(name = "qualification"),
//                                @ColumnResult(name = "qualification"),
////                                @ColumnResult(name = "income", type=Long.class),
////                                @ColumnResult(name = "ownHouse", type = Boolean.class),
////                        @ColumnResult(name = "onlyChild", type=Boolean.class),
//                                @ColumnResult(name = "details")
//                        }
//                )
//        }
//)

@Entity
@Table(name ="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "accountid")
    private Long accountId;
    private String name;
    private String dob;
    private String fathersName;
    private String mothersName;
    private String mobile1;
    private String mobile2;
    private String email1;
    private String email2;
    private Double height;
    private Double weight;
    private String qualification;
    private String occupation;
    private Long income;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Address.class)
//    @JoinColumn(columnN = "resAddressId")
//    @Column(name = "residenceAddress")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Address.class, mappedBy = "account")
    private List<Address> addresses;

//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Address.class)
//    @JoinColumn(name = "correspondenceAddressId")
////    @Column(name = "workAddress")
//    private Address workAddress;

    private Boolean ownHouse;
    private Boolean onlyChild;
    private String details;

    public Account() {
    }

    public Account(Long accountId, String name, String dob, String fathersName, String mothersName, String mobile1, String mobile2, String email1, String email2, Double height, Double weight, String qualification, String occupation, Long income, List<Address> addresses, Boolean ownHouse, Boolean onlyChild, String details) {
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
        this.addresses = addresses;
        this.ownHouse = ownHouse;
        this.onlyChild = onlyChild;
        this.details = details;
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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Boolean getOwnHouse() {
        return ownHouse;
    }

    public void setOwnHouse(Boolean ownHouse) {
        this.ownHouse = ownHouse;
    }

    public Boolean getOnlyChild() {
        return onlyChild;
    }

    public void setOnlyChild(Boolean onlyChild) {
        this.onlyChild = onlyChild;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public static interface AccountIdStep {
        NameStep withAccountId(Long accountId);
    }

    public static interface NameStep {
        DobStep withName(String name);
    }

    public static interface DobStep {
        FathersNameStep withDob(String dob);
    }

    public static interface FathersNameStep {
        MothersNameStep withFathersName(String fathersName);
    }

    public static interface MothersNameStep {
        Mobile1Step withMothersName(String mothersName);
    }

    public static interface Mobile1Step {
        Mobile2Step withMobile1(String mobile1);
    }

    public static interface Mobile2Step {
        Email1Step withMobile2(String mobile2);
    }

    public static interface Email1Step {
        Email2Step withEmail1(String email1);
    }

    public static interface Email2Step {
        HeightStep withEmail2(String email2);
    }

    public static interface HeightStep {
        WeightStep withHeight(Double height);
    }

    public static interface WeightStep {
        QualificationStep withWeight(Double weight);
    }

    public static interface QualificationStep {
        OccupationStep withQualification(String qualification);
    }

    public static interface OccupationStep {
        IncomeStep withOccupation(String occupation);
    }

    public static interface IncomeStep {
        AddressesStep withIncome(Long income);
    }

    public static interface AddressesStep {
        OwnHouseStep withAddresses(List<Address> addresses);
    }

    public static interface OwnHouseStep {
        OnlyChildStep withOwnHouse(Boolean ownHouse);
    }

    public static interface OnlyChildStep {
        DetailsStep withOnlyChild(Boolean onlyChild);
    }

    public static interface DetailsStep {
        BuildStep withDetails(String details);
    }

    public static interface BuildStep {
        Account build();
    }

    public static class Builder implements AccountIdStep, NameStep, DobStep, FathersNameStep, MothersNameStep, Mobile1Step, Mobile2Step, Email1Step, Email2Step, HeightStep, WeightStep, QualificationStep, OccupationStep, IncomeStep, AddressesStep, OwnHouseStep, OnlyChildStep, DetailsStep, BuildStep {
        private Long accountId;
        private String name;
        private String dob;
        private String fathersName;
        private String mothersName;
        private String mobile1;
        private String mobile2;
        private String email1;
        private String email2;
        private Double height;
        private Double weight;
        private String qualification;
        private String occupation;
        private Long income;
        private List<Address> addresses;
        private Boolean ownHouse;
        private Boolean onlyChild;
        private String details;

        private Builder() {
        }

        public static AccountIdStep account() {
            return new Builder();
        }

        @Override
        public NameStep withAccountId(Long accountId) {
            this.accountId = accountId;
            return this;
        }

        @Override
        public DobStep withName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public FathersNameStep withDob(String dob) {
            this.dob = dob;
            return this;
        }

        @Override
        public MothersNameStep withFathersName(String fathersName) {
            this.fathersName = fathersName;
            return this;
        }

        @Override
        public Mobile1Step withMothersName(String mothersName) {
            this.mothersName = mothersName;
            return this;
        }

        @Override
        public Mobile2Step withMobile1(String mobile1) {
            this.mobile1 = mobile1;
            return this;
        }

        @Override
        public Email1Step withMobile2(String mobile2) {
            this.mobile2 = mobile2;
            return this;
        }

        @Override
        public Email2Step withEmail1(String email1) {
            this.email1 = email1;
            return this;
        }

        @Override
        public HeightStep withEmail2(String email2) {
            this.email2 = email2;
            return this;
        }

        @Override
        public WeightStep withHeight(Double height) {
            this.height = height;
            return this;
        }

        @Override
        public QualificationStep withWeight(Double weight) {
            this.weight = weight;
            return this;
        }

        @Override
        public OccupationStep withQualification(String qualification) {
            this.qualification = qualification;
            return this;
        }

        @Override
        public IncomeStep withOccupation(String occupation) {
            this.occupation = occupation;
            return this;
        }

        @Override
        public AddressesStep withIncome(Long income) {
            this.income = income;
            return this;
        }

        @Override
        public OwnHouseStep withAddresses(List<Address> addresses) {
            this.addresses = addresses;
            return this;
        }

        @Override
        public OnlyChildStep withOwnHouse(Boolean ownHouse) {
            this.ownHouse = ownHouse;
            return this;
        }

        @Override
        public DetailsStep withOnlyChild(Boolean onlyChild) {
            this.onlyChild = onlyChild;
            return this;
        }

        @Override
        public BuildStep withDetails(String details) {
            this.details = details;
            return this;
        }

        @Override
        public Account build() {
            return new Account(
                    this.accountId,
                    this.name,
                    this.dob,
                    this.fathersName,
                    this.mothersName,
                    this.mobile1,
                    this.mobile2,
                    this.email1,
                    this.email2,
                    this.height,
                    this.weight,
                    this.qualification,
                    this.occupation,
                    this.income,
                    this.addresses,
                    this.ownHouse,
                    this.onlyChild,
                    this.details
            );
        }
    }
}
