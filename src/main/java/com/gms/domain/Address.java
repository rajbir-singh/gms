package com.gms.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gms.attributeConverter.AddressTypeEAConverter;
import com.gms.attributeConverter.StateEAConverter;
import com.gms.enums.AddressType;
import com.gms.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long  addressId;

    @NotNull
    @Size(min = 3, max = 50)
    private String addressLine1;

    @Size(min = 3, max = 50)
    private String addressLine2;

    @Size(min = 3, max = 50)
    private String addressLine3;

    @Size(min = 3, max = 50)
    private String addressLine4;

    //TODO : crete city enums
    private String city;

    @Enumerated(EnumType.STRING)
//    @Convert(converter = StateEAConverter.class)
    private State state;

    @NotNull
    @Size(min = 3, max = 50)
    private String pincode;

    private String country;

    @NotNull
    @Convert(converter = AddressTypeEAConverter.class)
    private AddressType addressType;

    //fetchType is EAGER by default, may cause n+1 problem more details here https://www.thoughts-on-java.org/best-practices-many-one-one-many-associations-mappings/ http://www.thoughts-on-java.org/free-n1_select_course/
    //@JsonIgnore
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_accountId")
    private Account account;

    public static interface AddressIdStep {
        AddressLine1Step withAddressId(Long addressId);
    }

    public static interface AddressLine1Step {
        AddressLine2Step withAddressLine1(String addressLine1);
    }

    public static interface AddressLine2Step {
        AddressLine3Step withAddressLine2(String addressLine2);
    }

    public static interface AddressLine3Step {
        AddressLine4Step withAddressLine3(String addressLine3);
    }

    public static interface AddressLine4Step {
        CityStep withAddressLine4(String addressLine4);
    }

    public static interface CityStep {
        StateStep withCity(String city);
    }

    public static interface StateStep {
        PincodeStep withState(State state);
    }

    public static interface PincodeStep {
        CountryStep withPincode(String pincode);
    }

    public static interface CountryStep {
        AddressTypeStep withCountry(String country);
    }

    public static interface AddressTypeStep {
        AccountStep withAddressType(AddressType addressType);
    }

    public static interface AccountStep {
        BuildStep withAccount(Account account);
    }

    public static interface BuildStep {
        Address build();
    }


    public static class Builder implements AddressIdStep, AddressLine1Step, AddressLine2Step, AddressLine3Step, AddressLine4Step, CityStep, StateStep, PincodeStep, CountryStep, AddressTypeStep, AccountStep, BuildStep {
        private Long addressId;
        private String addressLine1;
        private String addressLine2;
        private String addressLine3;
        private String addressLine4;
        private String city;
        private State state;
        private String pincode;
        private String country;
        private AddressType addressType;
        private Account account;

        private Builder() {
        }

        public static AddressIdStep address() {
            return new Builder();
        }

        @Override
        public AddressLine1Step withAddressId(Long addressId) {
            this.addressId = addressId;
            return this;
        }

        @Override
        public AddressLine2Step withAddressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }

        @Override
        public AddressLine3Step withAddressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }

        @Override
        public AddressLine4Step withAddressLine3(String addressLine3) {
            this.addressLine3 = addressLine3;
            return this;
        }

        @Override
        public CityStep withAddressLine4(String addressLine4) {
            this.addressLine4 = addressLine4;
            return this;
        }

        @Override
        public StateStep withCity(String city) {
            this.city = city;
            return this;
        }

        @Override
        public PincodeStep withState(State state) {
            this.state = state;
            return this;
        }

        @Override
        public CountryStep withPincode(String pincode) {
            this.pincode = pincode;
            return this;
        }

        @Override
        public AddressTypeStep withCountry(String country) {
            this.country = country;
            return this;
        }

        @Override
        public AccountStep withAddressType(AddressType addressType) {
            this.addressType = addressType;
            return this;
        }

        @Override
        public BuildStep withAccount(Account account) {
            this.account = account;
            return this;
        }

        @Override
        public Address build() {
            return new Address(
                    this.addressId,
                    this.addressLine1,
                    this.addressLine2,
                    this.addressLine3,
                    this.addressLine4,
                    this.city,
                    this.state,
                    this.pincode,
                    this.country,
                    this.addressType,
                    this.account
            );
        }
    }
}
