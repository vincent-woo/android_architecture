package com.vincent.mymovie.view.movies

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vincent.mymovie.R
import com.vincent.mymovie.data.RemoteMovieDataSource
import com.vincent.mymovie.model.MoviesViewModel
import com.vincent.mymovie.model.MoviesViewModelFactory
import com.vincent.mymovie.services.OMDBMovieService
import javax.inject.Inject

class MoviesFragment : Fragment(), IMoviesView {
    private val TAG = javaClass.simpleName

    private lateinit var moviesViewModel: MoviesViewModel

    @Inject
    lateinit var movieDataSource: RemoteMovieDataSource

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        moviesViewModel = ViewModelProviders.of(activity!!, MoviesViewModelFactory(OMDBMovieService(movieDataSource))).get(MoviesViewModel::class.java)

        return inflater.inflate(R.layout.fragment_movies, container, false)!!
    }

    private fun onSearchButtonClicked() {
        var movies = moviesViewModel.searchMovies("")
    }
}