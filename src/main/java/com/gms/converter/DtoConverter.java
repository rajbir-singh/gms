package com.gms.converter;

public interface DtoConverter<T, S> {
    S convertToDto(T t);

    T convertFromDto(S s);
}

