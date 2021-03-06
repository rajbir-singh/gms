package com.gms.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class Utils {

    public static boolean isEmptyObject(Object o) {
        return o == null;
    }

    public static boolean isNotEmptyObject(Object o) {
        return !isEmptyObject(o);
    }

    public static boolean isEmptyList(Object o) {
        if (isEmptyObject(o)) {
            return true;
        } else if (o instanceof List) {
            return ((List) o).size() == 0;
        } else return false;
    }

    public static boolean isNonEmptyList(Object o) {
        return !isEmptyList(o);
    }

    public static boolean isStrNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isStrNonEmpty(String str) {
        return !isStrNullOrEmpty(str);
    }

    public static boolean isLongNullOrEmpty(Long lng) {
        return lng == null || lng == 0;
    }
}
