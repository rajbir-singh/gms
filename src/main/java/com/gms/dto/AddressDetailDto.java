package com.gms.dto;

import com.gms.attributeConverter.StateEAConverter;
import com.gms.enums.AddressType;
import com.gms.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDetailDto {

    private Long addressId;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    //TODO : crete city enums
    private String city;
    @Convert(converter = StateEAConverter.class)
    private State state;
    private String pincode;
    private String country;
    private AddressType addressType;
    //will be null if address is created along with a new account, else this must be the accountId of the account to which this address belongs
    private Long accountId;

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
        AccountIdStep withAddressType(AddressType addressType);
    }

    public static interface AccountIdStep {
        BuildStep withAccountId(Long accountId);
    }

    public static interface BuildStep {
        AddressDetailDto build();
    }

    public static class Builder implements AddressIdStep, AddressLine1Step, AddressLine2Step, AddressLine3Step, AddressLine4Step, CityStep, StateStep, PincodeStep, CountryStep, AddressTypeStep, AccountIdStep, BuildStep {
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
        private Long accountId;

        private Builder() {
        }

        public static AddressIdStep addressDetailDto() {
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
        public AccountIdStep withAddressType(AddressType addressType) {
            this.addressType = addressType;
            return this;
        }

        @Override
        public BuildStep withAccountId(Long accountId) {
            this.accountId = accountId;
            return this;
        }

        @Override
        public AddressDetailDto build() {
            return new AddressDetailDto(
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
                    this.accountId
            );
        }
    }
}
