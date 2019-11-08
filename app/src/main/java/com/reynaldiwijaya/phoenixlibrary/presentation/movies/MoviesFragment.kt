package com.reynaldiwijaya.phoenixlibrary.presentation.movies


import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.reynaldiwijaya.phoenix.base.BaseFragment
import com.reynaldiwijaya.phoenix.data.Result
import com.reynaldiwijaya.phoenix.utils.extensions.gone
import com.reynaldiwijaya.phoenix.utils.extensions.visible
import com.reynaldiwijaya.phoenixlibrary.R
import com.reynaldiwijaya.phoenixlibrary.data.Injection
import com.reynaldiwijaya.phoenixlibrary.presentation.adapter.MovieAdapter
import com.reynaldiwijaya.phoenixlibrary.utils.ViewModelFactory
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_movies.*

/**
 *  Extends Base Fragment
 */
class MoviesFragment : BaseFragment() {

    companion object {
        fun newInstance() : MoviesFragment {
            return MoviesFragment()
        }
    }

    private val disposable = CompositeDisposable()

    private lateinit var movieAdapter : MovieAdapter
    private lateinit var viewModel: MovieViewModel

    // Pass your layout here
    override val layoutResource: Int =
        R.layout.fragment_movies

    override fun initAction() {
    }

    //    Extract desired intent here
    override fun initIntent() {
    }

    //    Init Presenter and Component Injection here
    override fun initLib() {
        val viewModelFactory = ViewModelFactory(disposable, Injection.providePhoenixDataStore())
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieViewModel::class.java)
    }

    //    initialize UI interaction here
    override fun initProcess() {
        viewModel.getMovie()
        viewModel.postMovie.observe(this, Observer {
            when(it) {
                is Result.Default -> {}
                is Result.Loading -> {
                    // Use Ext func in phoenix
                    pbLoading.visible()
                    rvMovie.gone()
                }
                is Result.Success -> {
                    pbLoading.gone()
                    rvMovie.visible()
                    movieAdapter = MovieAdapter(context!!, it.data.toMutableList())
                    rvMovie.adapter = movieAdapter
                }
                is Result.Failure -> {
                    pbLoading.gone()
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    //    initialize main Process here e.g call presenter to load data
    override fun initUI() {
        rvMovie.layoutManager = LinearLayoutManager(activity)
    }
}