package com.gms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gms.enums.AuthProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetailDto {

    //this field is null in payload if account is to be created, else if it is to be updated then its the Id of the account to be updated
    private Long accountId;

    @NotNull @Size( min = 4, message = "Name must be at least 4 characters long")
    private String name;

    @NotNull @Past @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date dob;

    @NotNull @Size( min = 4) @NotEmpty
    private String fathersName;

    @NotNull @Size( min = 4) @NotEmpty
    private String mothersName;

    @NotNull
//    @Mobile
    private String mobile1;

//    @Mobile
    private String mobile2;

//    @EmailCustomValidator
    @NotNull
    private String email1;

//    @EmailCustomValidator
    private String email2;

    //height in inches
    private Double height;

    //weight in Kgs
    private Double weight;

    private String qualification;

    private String occupation;

    //monthly income
    private Long income;

//    @NotNull
    private List<AddressDetailDto> addresses;

    private Boolean ownHouse;

    private Boolean onlyChild;

    private String details;

    ///////////////////////////////////

    private String imageUrl;

    @Column(nullable = false)
    private Boolean emailVerified = false;

    @JsonIgnore
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private String providerId;

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
        OwnHouseStep withAddresses(List<AddressDetailDto> addresses);
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
        AccountDetailDto build();
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
        private List<AddressDetailDto> addresses;
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

        public static AccountIdStep accountDetailDto() {
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
        public OwnHouseStep withAddresses(List<AddressDetailDto> addresses) {
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
        public AccountDetailDto build() {
            return new AccountDetailDto(
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
