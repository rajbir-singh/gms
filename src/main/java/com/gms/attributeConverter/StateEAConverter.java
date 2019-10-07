package com.gms.attributeConverter;

import com.gms.enums.State;

//TODO: i have to add the artifact "spring-boot-thin-launcher" to the pom just to make available "BiMap", do some research over the performance hit due to addition of an artifact, if performance is hit look for some alternative
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import javax.persistence.AttributeConverter;

public class StateEAConverter extends GenericEnumAttributeConverter<State, String> implements AttributeConverter<State, String> {

    @Override
    protected BiMap<State, String> createMap() {
        BiMap<State, String> map = HashBiMap.create();
        for (State state : State.values()) {
            map.put(state, state.getName());
        }
        return map;
    }
}
