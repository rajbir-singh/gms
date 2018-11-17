package com.gms.enums;

import java.util.Arrays;

public enum State {
    DL("Delhi"),
    AP("Andhra Pradesh"),
    AR("Arunachal Pradesh"),
    AS("Assam"),
    BR("Bihar"),
    CG("Chhattisgarh"),
    GA("Goa"),
    GJ("Gujarat"),
    HR("Haryana"),
    HP("Himachal Pradesh"),
    JK("Jammu and Kashmir"),
    JH("Jharkhand"),
    KA("Karnataka"),
    KL("Kerala"),
    MP("Madhya Pradesh"),
    MH("Maharashtra"),
    MN("Manipur"),
    ML("Meghalaya"),
    MZ("Mizoram"),
    NL("Nagaland"),
    OR("Orissa"),
    PB("Punjab"),
    RJ("Rajasthan"),
    SK("Sikkim"),
    TN("Tamil Nadu"),
    TR("Tripura"),
    UK("Uttarakhand"),
    UP("Uttar Pradesh"),
    WB("West Bengal"),
    AN("Andaman and Nicobar Islands"),
    CH("Chandigarh"),
    DH("Dadra and Nagar Haveli"),
    DD("Daman and Diu"),
    LD("Lakshadweep"),
    PY("Pondicherry");

    private String name = null;

    private State(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static State fromValue(String value) {
        for (State state : values()) {
            if (state.name.equalsIgnoreCase(value)) {
                return state;
            }
        }
        throw new IllegalArgumentException(
                "Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }
}
