package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class City {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String condition;

    @NotNull
    @Min(0)
    private Double windVelocity;

    @NotNull
    @NotBlank
    private String windDirection;

    public City() {
    }

    public City(String name, String condition, Double windVelocity, String windDirection) {
        this.name = name;
        this.condition = condition;
        this.windVelocity = windVelocity;
        this.windDirection = windDirection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Double getWindVelocity() {
        return windVelocity;
    }

    public void setWindVelocity(Double windVelocity) {
        this.windVelocity = windVelocity;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }
}
