package com.gms.dto;

import com.gms.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountListItemDto {

    private Long accountId;
    private String name;
    private Date dob;
    private String fathersName;
    private String mothersName;
    private String mobile1;
    private String email1;
    private Double height;
    private Double weight;
    private String qualification;
    private Long income;
    private State state;
    private String city;

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
        Email1Step withMobile1(String mobile1);
    }

    public static interface Email1Step {
        HeightStep withEmail1(String email1);
    }

    public static interface HeightStep {
        WeightStep withHeight(Double height);
    }

    public static interface WeightStep {
        QualificationStep withWeight(Double weight);
    }

    public static interface QualificationStep {
        IncomeStep withQualification(String qualification);
    }

    public static interface IncomeStep {
        StateStep withIncome(Long income);
    }

    public static interface StateStep {
        CityStep withState(State state);
    }

    public static interface CityStep {
        BuildStep withCity(String city);
    }

    public static interface BuildStep {
        AccountListItemDto build();
    }

    public static class Builder implements AccountIdStep, NameStep, DobStep, FathersNameStep, MothersNameStep, Mobile1Step, Email1Step, HeightStep, WeightStep, QualificationStep, IncomeStep, StateStep, CityStep, BuildStep {
        private Long accountId;
        private String name;
        private Date dob;
        private String fathersName;
        private String mothersName;
        private String mobile1;
        private String email1;
        private Double height;
        private Double weight;
        private String qualification;
        private Long income;
        private State state;
        private String city;

        private Builder() {
        }

        public static AccountIdStep accountListItemDto() {
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
        public Email1Step withMobile1(String mobile1) {
            this.mobile1 = mobile1;
            return this;
        }

        @Override
        public HeightStep withEmail1(String email1) {
            this.email1 = email1;
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
        public IncomeStep withQualification(String qualification) {
            this.qualification = qualification;
            return this;
        }

        @Override
        public StateStep withIncome(Long income) {
            this.income = income;
            return this;
        }

        @Override
        public CityStep withState(State state) {
            this.state = state;
            return this;
        }

        @Override
        public BuildStep withCity(String city) {
            this.city = city;
            return this;
        }

        @Override
        public AccountListItemDto build() {
            return new AccountListItemDto(
                    this.accountId,
                    this.name,
                    this.dob,
                    this.fathersName,
                    this.mothersName,
                    this.mobile1,
                    this.email1,
                    this.height,
                    this.weight,
                    this.qualification,
                    this.income,
                    this.state,
                    this.city
            );
        }
    }
}
