package com.gms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gms.enums.AuthProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "account", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email1")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
// using @NotNull annotation with only email1 field as we should be able to create account with just email ( for google login use case ),
// @NotNull will be used with all other required fields in the updateDto so the client can only update account if it provides required values
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    //@Column(name = "accountid")
    //not using @Column(name = ), hibernate naming strategy settings in application.yaml make sure that columns' name are same as the variable name
    private Long accountId;

    @Size(min = 3, max = 50)
    private String name;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
//    @NotNull
    @Past
    private Date dob;

    //    @NotNull
    @Size(min = 3, max = 50)
    private String fathersName;

    //    @NotNull
    @Size(min = 3, max = 50)
    private String mothersName;

    //    @NotNull
//    @Mobile
    private String mobile1;

    //    @Mobile
    private String mobile2;

    @NotNull
//    @EmailCustomValidator
    private String email1;

    //    @EmailCustomValidator
    private String email2;

    //height in inches
    private Double height;

    //weight in Kgs
    private Double weight;

    //TODO : make enums for qualification, will help in filtering
    private String qualification;

    //TODO : make enums for qualification, will help in filtering
    private String occupation;

    //monthly income
    private Long income;

    //@EqualsAndHashCode.Exclude
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Address.class, mappedBy = "account")
    private List<Address> addresses;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean ownHouse;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean onlyChild;

    private String details;

    ///////////////////////////

    private String imageUrl;

    @Column(nullable = false)
    private Boolean emailVerified = false;

    @JsonIgnore
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private String providerId;


    public Long getAccountId() {
        return accountId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthProvider getProvider() {
        return provider;
    }

    public void setProvider(AuthProvider provider) {
        this.provider = provider;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

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
        ImageUrlStep withDetails(String details);
    }

    public static interface ImageUrlStep {
        EmailVerifiedStep withImageUrl(String imageUrl);
    }

    public static interface EmailVerifiedStep {
        PasswordStep withEmailVerified(Boolean emailVerified);
    }

    public static interface PasswordStep {
        ProviderStep withPassword(String password);
    }

    public static interface ProviderStep {
        ProviderIdStep withProvider(AuthProvider provider);
    }

    public static interface ProviderIdStep {
        BuildStep withProviderId(String providerId);
    }

    public static interface BuildStep {
        Account build();
    }

    public static class Builder implements AccountIdStep, NameStep, DobStep, FathersNameStep, MothersNameStep, Mobile1Step, Mobile2Step, Email1Step, Email2Step, HeightStep, WeightStep, QualificationStep, OccupationStep, IncomeStep, AddressesStep, OwnHouseStep, OnlyChildStep, DetailsStep, ImageUrlStep, EmailVerifiedStep, PasswordStep, ProviderStep, ProviderIdStep, BuildStep {
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
        private String imageUrl;
        private Boolean emailVerified;
        private String password;
        private AuthProvider provider;
        private String providerId;

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
        public ImageUrlStep withDetails(String details) {
            this.details = details;
            return this;
        }

        @Override
        public EmailVerifiedStep withImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        @Override
        public PasswordStep withEmailVerified(Boolean emailVerified) {
            this.emailVerified = emailVerified;
            return this;
        }

        @Override
        public ProviderStep withPassword(String password) {
            this.password = password;
            return this;
        }

        @Override
        public ProviderIdStep withProvider(AuthProvider provider) {
            this.provider = provider;
            return this;
        }

        @Override
        public BuildStep withProviderId(String providerId) {
            this.providerId = providerId;
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
                    this.details,
                    this.imageUrl,
                    this.emailVerified,
                    this.password,
                    this.provider,
                    this.providerId
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
