package com.mauscoelho.upcomingmovies.domain.boundary

import com.mauscoelho.upcomingmovies.model.Movie
import rx.Observable


interface UpcomingMoviesService {
    fun getUpcomingMovies(api_key: String, language: String, page: Int) : Observable<Movie>
    fun getMovie(movieId : Int, api_key: String, language: String) : Observable<Movie>
}