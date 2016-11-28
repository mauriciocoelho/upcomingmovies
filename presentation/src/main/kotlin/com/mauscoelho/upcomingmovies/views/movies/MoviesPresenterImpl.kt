package com.mauscoelho.upcomingmovies.views.movies

import com.mauscoelho.upcomingmovies.BuildConfig
import com.mauscoelho.upcomingmovies.domain.boundary.UpcomingMoviesService
import okhttp3.internal.Internal.logger
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MoviesPresenterImpl(val upcomingMoviesService: UpcomingMoviesService,
                          val language: String) : MoviesPresenter {

    lateinit var moviesView: MoviesView
    var currentPage = 0
    var totalPages = 1

    override fun injectView(moviesView: MoviesView) {
        this.moviesView = moviesView
    }

    override fun loadMovies() {
        upcomingMoviesService.getUpcomingMovies(BuildConfig.API_KEY, language, currentPage + 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    currentPage = it.page
                    totalPages = it.total_pages
                    it.results.map {
                        moviesView.addMovie(it)
                    }
                    moviesView.hideLoading()
                }, {
                    logger.info("error:" + it.message)
                })
    }
}