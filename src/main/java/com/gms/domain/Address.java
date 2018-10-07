package com.gms.domain;

import com.gms.enums.AddressType;
import com.gms.enums.State;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long  addressId;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    //TODO : crete city enums
    private String city;
    @Enumerated(EnumType.STRING)
    private State state;
    private String pincode;
    private String country;
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    public Address() {
    }

    public Address(String addressLine1, String addressLine2, String addressLine3, String addressLine4, String city, State state, String pincode, String country, AddressType addressType) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.addressLine4 = addressLine4;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.country = country;
        this.addressType = addressType;
    }

    public Address(Long addressId, String addressLine1, String addressLine2, String addressLine3, String addressLine4, String city, State state, String pincode, String country, AddressType addressType) {
        this.addressId = addressId;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.addressLine4 = addressLine4;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.country = country;
        this.addressType = addressType;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getAddressLine4() {
        return addressLine4;
    }

    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

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
        BuildStep withAddressType(AddressType addressType);
    }

    public static interface BuildStep {
        Address build();
    }


    public static class Builder implements AddressIdStep, AddressLine1Step, AddressLine2Step, AddressLine3Step, AddressLine4Step, CityStep, StateStep, PincodeStep, CountryStep, AddressTypeStep, BuildStep {
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
        public BuildStep withAddressType(AddressType addressType) {
            this.addressType = addressType;
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
                    this.addressType
            );
        }
    }
}
