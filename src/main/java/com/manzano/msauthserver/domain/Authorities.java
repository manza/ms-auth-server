package com.manzano.msauthserver.domain;

/**
 * Defines the two main business rules in terms of authorization accesses
 */
public enum Authorities {

    ROLE_USER,
    ROLE_ADMIN;

    public static String[] names() {
        String[] names = new String[values().length];
        for (int index = 0; index < values().length; index++) {
            names[index] = values()[index].name();
        }
        return names;
    }
}
