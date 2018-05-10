package com.manzano.msauthserver.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Roles table in the database
 */
@Entity
public class Authority implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Size(min = 0, max = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
