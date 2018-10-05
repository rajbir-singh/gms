package com.gms.dto;

public class AccountCreateDto {

    private String name;
    private String dob;
    private String fathersName;
    private String mothersName;
    private String mobile1;
    private String mobile2;
    private String email1;
    private String email2;
    private double height;
    private double weight;
    private String qualification;
    private String occupation;
    private Long income;
    private AddressCreateDto residenceAddress;
    private AddressCreateDto correspondenceAddress;
    private boolean ownHouse;
    private boolean onlyChild;
    private String details;

    public AccountCreateDto() {

    }

    public AccountCreateDto(String name, String dob, String fathersName, String mothersName, String mobile1, String mobile2, String email1, String email2, double height, double weight, String qualification, String occupation, Long income, AddressCreateDto residenceAddress, AddressCreateDto correspondenceAddress, boolean ownHouse, boolean onlyChild, String details) {
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
        this.residenceAddress = residenceAddress;
        this.correspondenceAddress = correspondenceAddress;
        this.ownHouse = ownHouse;
        this.onlyChild = onlyChild;
        this.details = details;
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
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

    public AddressCreateDto getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(AddressCreateDto residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public AddressCreateDto getCorrespondenceAddress() {
        return correspondenceAddress;
    }

    public void setCorrespondenceAddress(AddressCreateDto correspondenceAddress) {
        this.correspondenceAddress = correspondenceAddress;
    }

    public boolean isOwnHouse() {
        return ownHouse;
    }

    public void setOwnHouse(boolean ownHouse) {
        this.ownHouse = ownHouse;
    }

    public boolean isOnlyChild() {
        return onlyChild;
    }

    public void setOnlyChild(boolean onlyChild) {
        this.onlyChild = onlyChild;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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
        WeightStep withHeight(double height);
    }

    public static interface WeightStep {
        QualificationStep withWeight(double weight);
    }

    public static interface QualificationStep {
        OccupationStep withQualification(String qualification);
    }

    public static interface OccupationStep {
        IncomeStep withOccupation(String occupation);
    }

    public static interface IncomeStep {
        ResidenceAddressStep withIncome(Long income);
    }

    public static interface ResidenceAddressStep {
        CorrespondenceAddressStep withResidenceAddress(AddressCreateDto residenceAddress);
    }

    public static interface CorrespondenceAddressStep {
        OwnHouseStep withCorrespondenceAddress(AddressCreateDto correspondenceAddress);
    }

    public static interface OwnHouseStep {
        OnlyChildStep withOwnHouse(boolean ownHouse);
    }

    public static interface OnlyChildStep {
        DetailsStep withOnlyChild(boolean onlyChild);
    }

    public static interface DetailsStep {
        BuildStep withDetails(String details);
    }

    public static interface BuildStep {
        AccountCreateDto build();
    }


    public static class Builder implements NameStep, DobStep, FathersNameStep, MothersNameStep, Mobile1Step, Mobile2Step, Email1Step, Email2Step, HeightStep, WeightStep, QualificationStep, OccupationStep, IncomeStep, ResidenceAddressStep, CorrespondenceAddressStep, OwnHouseStep, OnlyChildStep, DetailsStep, BuildStep {
        private String name;
        private String dob;
        private String fathersName;
        private String mothersName;
        private String mobile1;
        private String mobile2;
        private String email1;
        private String email2;
        private double height;
        private double weight;
        private String qualification;
        private String occupation;
        private Long income;
        private AddressCreateDto residenceAddress;
        private AddressCreateDto correspondenceAddress;
        private boolean ownHouse;
        private boolean onlyChild;
        private String details;

        private Builder() {
        }

        public static NameStep accountCreateDto() {
            return new Builder();
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
        public WeightStep withHeight(double height) {
            this.height = height;
            return this;
        }

        @Override
        public QualificationStep withWeight(double weight) {
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
        public ResidenceAddressStep withIncome(Long income) {
            this.income = income;
            return this;
        }

        @Override
        public CorrespondenceAddressStep withResidenceAddress(AddressCreateDto residenceAddress) {
            this.residenceAddress = residenceAddress;
            return this;
        }

        @Override
        public OwnHouseStep withCorrespondenceAddress(AddressCreateDto correspondenceAddress) {
            this.correspondenceAddress = correspondenceAddress;
            return this;
        }

        @Override
        public OnlyChildStep withOwnHouse(boolean ownHouse) {
            this.ownHouse = ownHouse;
            return this;
        }

        @Override
        public DetailsStep withOnlyChild(boolean onlyChild) {
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
                    this.residenceAddress,
                    this.correspondenceAddress,
                    this.ownHouse,
                    this.onlyChild,
                    this.details
            );
        }
    }
}
