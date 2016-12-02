package com.mauscoelho.upcomingmovies.views.movieDetail


interface MovieDetailView {
    fun setupToolbar(title: String)
    fun setHeaderImage(imagePath: String?)
    fun setOverview(overview: String)
    fun setPosterImage(posterPath: String?)
    fun setVoteAvarage(voteAverage: Double)
    fun setOriginalTitle(originalTitle: String)
    fun setReleaseDate(release_date: String)
    fun setOriginalLanguage(original_language: String?)
    fun setRuntime(runtime: String?)
}