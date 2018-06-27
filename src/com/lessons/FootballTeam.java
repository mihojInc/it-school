package com.lessons;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class FootballTeam {
    String nameOfTeam;
    String instructor;
    String country;

    FootballTeam(String nameOfTeam, String instructor, String country){
        this.nameOfTeam = nameOfTeam;
        this.instructor = instructor;
        this.country = country;
    }

    public String getNameOfTeam() {
        return nameOfTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballTeam that = (FootballTeam) o;
        return Objects.equals(nameOfTeam, that.nameOfTeam) &&
                Objects.equals(instructor, that.instructor) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nameOfTeam, instructor, country);
    }
}
