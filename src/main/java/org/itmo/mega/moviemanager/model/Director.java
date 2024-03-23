package org.itmo.mega.moviemanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Director {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    @NotNull(message = "Field 'fio' is required")
    @Size(max = 100, message = "Field 'fio' should be not longer than 100 symbols")
    private String fio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
}
