package com.sunny.runnerz.run;
import jakarta.persistence.Entity;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.Id;


import java.time.LocalDateTime;
//creating using Record
public record Run(
        @Id
        Integer id, @NotEmpty
                  String title, LocalDateTime startedOn, LocalDateTime completedOn, @Positive
                  Integer miles, Location location,
        @Version
        Integer version) {
    public Run{
        if(!completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("CompletedOn must be after StartedOn");
        }
    }

}
