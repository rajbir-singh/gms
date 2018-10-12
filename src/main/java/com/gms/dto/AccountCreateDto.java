package com.gms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreateDto {

    //this field is null in payload if account is to be created, else if it is to be updated then its the Id of the account to be updated
    private Long accountId;

    @NotNull @Size( min = 4, message = "Name must be at least 4 chats long") @NotEmpty
    private String name;

//    @NotNull @Past
    private Date dob;

//    @NotNull @Size( min = 4) @NotEmpty
    private String fathersName;

//    @NotNull @Size( min = 4) @NotEmpty
    private String mothersName;

//    @Mobile @Notnull @NotEmpty
    private String mobile1;

//    @Mobile
    private String mobile2;

//    @Email @Notnull @NotEmpty
    private String email1;

//    @Email
    private String email2;

    private Double height;

    private Double weight;

    private String qualification;

    private String occupation;

    private Long income;

//    @NotNull
    private List<AddressCreateDto> addresses;

    private Boolean ownHouse;

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
        OwnHouseStep withAddresses(List<AddressCreateDto> addresses);
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
        AccountCreateDto build();
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
        private List<AddressCreateDto> addresses;
        private Boolean ownHouse;
        private Boolean onlyChild;
        private String details;

        private Builder() {
        }

        public static AccountIdStep accountCreateDto() {
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
        public OwnHouseStep withAddresses(List<AddressCreateDto> addresses) {
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
        public AccountCreateDto build() {
            return new AccountCreateDto(
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
