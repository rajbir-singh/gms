package com.gms.attributeConverter;

import com.gms.enums.AddressType;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import javax.persistence.AttributeConverter;

public class AddressTypeEAConverter extends GenericEnumAttributeConverter<AddressType, String> implements AttributeConverter<AddressType, String> {

    @Override
    protected BiMap<AddressType, String> createMap() {
        BiMap<AddressType, String> map = HashBiMap.create();
        for (AddressType addressType : AddressType.values()) {
            map.put(addressType, addressType.name());
        }
        return map;
    }
}
