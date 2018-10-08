package com.gms.enums;

public enum State {
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
    DL("Delhi"),
    LD("Lakshadweep"),
    PY("Pondicherry");

    private String name = null;

    private State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public State fromName(String name) {
//        for(State state : State.values()) {
//            if(state.getName().equals(name)) {
//                return state;
//            }
//        }
//    }
}
