package com.gms.domain;

import com.gms.enums.AddressType;
import com.gms.enums.State;

public class CorrespondenceAddress extends Address {

    public CorrespondenceAddress() {
    }

    public CorrespondenceAddress(String addressLine1, String addressLine2, String addressLine3, String addressLine4, String city, State state, String pincode, String country) {
        super(addressLine1, addressLine2, addressLine3, addressLine4, city, state, pincode, country, AddressType.CORRESPONDENCE);

    }
}

