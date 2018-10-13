package com.gms.converter;

import com.gms.exception.ResourceNotFoundException;

public interface DtoConverter<T, S> {
    S convertToDto(T t) throws ResourceNotFoundException;

    T convertFromDto(S s) throws ResourceNotFoundException;
}

