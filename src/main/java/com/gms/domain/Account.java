package com.gms.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name ="account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
//    @Column(name = "accountid")
    private Long accountId;
    private String name;

    private Date dob;

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

    @JsonManagedReference
//    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Address.class, mappedBy = "account")
    private List<Address> addresses;

//    @Column(name = "ownHouse", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean ownHouse;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean onlyChild;


    private String details;

    public static interface AccountIdStep {
        NameStep withAccountId(Long accountId);
    }

    public static interface NameStep {
        DobStep withName(String name);
    }

    public static interface DobStep {
        FathersNameStep withDob(Date dob);
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
        private Date dob;
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
        public FathersNameStep withDob(Date dob) {
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


//select accountId, name, dob, fathersName, mothersName, mobile1, mobile2, email1, email2, height, weight, qualification, occupation, income, ownHouse, onlyChild, details from account
//@NamedNativeQuery(name = "AccountNameQuery", resultClass = AccountNameDto.class, resultSetMapping = "AccountNameMapping", query = "select a.accountId, a.name, a.mobile1 from account a")
//@SqlResultSetMappings(
//        @SqlResultSetMapping(
//        name = "AccountNameMapping",
//        classes = {
//                @ConstructorResult(
////                        targetClass = com.gms.domain.Account.class,
//                        targetClass = com.gms.dto.AccountNameDto.class,
//                        columns = {
//                                @ColumnResult(name = "account_Id", type = Long.class),
//                                @ColumnResult(name = "name"),
//                                @ColumnResult(name = "mobile1")
//                        }
//                )
//        }
//)
//)


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
