package com.gms.service;

import org.springframework.stereotype.Service;

@Service
public class Utils {
    public static boolean isEmptyObject(Object o) {
        return o == null;
    }
    public static boolean isNotEmptyObject(Object o) {
        return !isEmptyObject(o);
    }
}
