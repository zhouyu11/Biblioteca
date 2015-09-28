package com.twu.biblioteca;

import java.util.List;

public class MovieLibrary {

    private List<Movie> moviesList;

    public MovieLibrary(List<Movie> movies) {
        this.moviesList = movies;
    }

    public List<Movie> getMoviesList() {
        return moviesList;
    }

    public String checkout(String movieName) {
        String message = "That movie is not available";
        for (Movie movie :moviesList){
            if (movieName.equals(movie.getName())){
                message= "Thank you! Enjoy the movie";
            }
        }
        return message;
    }
}
