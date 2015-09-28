package com.twu.biblioteca;

import java.time.Year;

public class Movie {

    private String Name;
    private Year Year;
    private String Director;
    private int Rete;

    public Movie(String movieName, java.time.Year year, String director, int rate) {
        this.Name = movieName;
        this.Year = year;
        this.Director = director;
        this.Rete = rate;
    }

    public String getName(){
        return this.Name;
    }

    public Year getYear() {
        return Year;
    }

    public int getRete() {
        return Rete;
    }

    public String getDirector() {
        return Director;
    }
}
