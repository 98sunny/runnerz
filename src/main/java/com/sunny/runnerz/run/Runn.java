package com.sunny.runnerz.run;

import java.time.LocalDateTime;
import java.util.Objects;
//Writing code with using Class
public class Runn {
    Integer id;
    String title;
    LocalDateTime startedOn;
    LocalDateTime completedOn;
    Integer miles;
    Location location;

    public Runn(Integer id, String title, LocalDateTime startedOn, LocalDateTime completedOn, Integer miles, Location location) {
        this.id = id;
        this.title = title;
        this.startedOn = startedOn;
        this.completedOn = completedOn;
        this.miles = miles;
        this.location = location;
        if(completedOn.isAfter(startedOn)){
            throw new IllegalArgumentException("Compled on date must be after started on date");
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
    }

    public LocalDateTime getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(LocalDateTime completedOn) {
        this.completedOn = completedOn;
    }

    public Integer getMiles() {
        return miles;
    }

    public void setMiles(Integer miles) {
        this.miles = miles;
    }

    @Override
    public String toString() {
        return "Run{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startedOn=" + startedOn +
                ", completedOn=" + completedOn +
                ", miles=" + miles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Runn Runn = (Runn) o;
        return Objects.equals(id, Runn.id) && Objects.equals(title, Runn.title) && Objects.equals(startedOn, Runn.startedOn) && Objects.equals(completedOn, Runn.completedOn) && Objects.equals(miles, Runn.miles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, startedOn, completedOn, miles);
    }
}
