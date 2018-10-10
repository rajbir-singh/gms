package com.gms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountListItemDto {

    private Long accountId;
    private String name;
    private String dob;
    private String fathersName;
    private String mothersName;
    private String mobile1;
    private String email1;
    private Double height;
    private Double weight;
    private String qualification;
    private Long income;

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
        BuildStep withIncome(Long income);
    }

    public static interface BuildStep {
        AccountListItemDto build();
    }


    public static class Builder implements AccountIdStep, NameStep, DobStep, FathersNameStep, MothersNameStep, Mobile1Step, Email1Step, HeightStep, WeightStep, QualificationStep, IncomeStep, BuildStep {
        private Long accountId;
        private String name;
        private String dob;
        private String fathersName;
        private String mothersName;
        private String mobile1;
        private String email1;
        private Double height;
        private Double weight;
        private String qualification;
        private Long income;

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
        public BuildStep withIncome(Long income) {
            this.income = income;
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
                    this.income
            );
        }
    }
}
