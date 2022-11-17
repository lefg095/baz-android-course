package com.lefg095.criptoone.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.lefg095.criptoone.R
import com.lefg095.criptoone.data.TickerRepository
import com.lefg095.criptoone.data.presenter.TickerPresenter
import com.lefg095.criptoone.databinding.FragmentDashboardBinding
import com.lefg095.criptoone.domain.model.Book
import com.lefg095.criptoone.domain.model.Ticker
import com.lefg095.criptoone.domain.stateevent.BooksStateEvent
import com.lefg095.criptoone.domain.stateevent.DataState
import com.lefg095.criptoone.domain.stateevent.TickerStateEvent
import com.lefg095.criptoone.ui.adapters.BooksAdapter
import com.lefg095.criptoone.ui.callbacks.ItemBookCallBack
import com.lefg095.criptoone.ui.callbacks.TickerCallBack
import com.lefg095.criptoone.util.isConnectedToNet
import com.lefg095.criptoone.viewmodel.BookViewModel
import com.lefg095.criptoone.viewmodel.TickerViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashboardFragment : Fragment(), ItemBookCallBack, TickerCallBack {
    private lateinit var binding: FragmentDashboardBinding
    private val bookViewModel by activityViewModels<BookViewModel>()
    private val tickerViewModel by activityViewModels<TickerViewModel>()
    private var adapterBooks: BooksAdapter? = null
    @Inject lateinit var tickerRepository: TickerRepository
    val presenter: TickerPresenter by lazy { TickerPresenter(this, requireContext(), tickerRepository) }
    lateinit var book: Book

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeBookObserver()
    }

    private fun initRecyclerView(books: List<Book>) {
        adapterBooks = BooksAdapter(books, this)
        binding.rvOne.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.rvOne.adapter = adapterBooks
    }

    override fun showDetailClicket(book: Book) {
        this.book = book
        if (isConnectedToNet(requireContext())) {
            getTickerWhitRx()
        }else{
            subscribeTickerObserver()
        }
    }

    private fun getTickerWhitRx(){
        presenter.getTicker(book.book)
    }

    private fun subscribeTickerObserver(){

        tickerViewModel.tickerResponse.observe(viewLifecycleOwner, {
            when(it){
                is DataState.Loading -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Success -> {
                    val bookBundle = bundleOf("book" to book, "ticker" to it.response.payload)
                    view?.findNavController()?.navigate(R.id.detailsFragment, bookBundle)
                }
                is DataState.Error -> {
                    Log.e("_ERROR_", "$it.error.message")
                    Toast.makeText(requireContext(), it.error.message, Toast.LENGTH_LONG).show()
                }
            }
        })
        tickerViewModel.makeApiCall(
            TickerStateEvent.GetTicker(book.book, requireContext())
        )
    }

    private fun subscribeBookObserver() {
        bookViewModel.bookResponse.observe(viewLifecycleOwner, {
            when (it) {
                is DataState.Loading -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Success -> {
                    val textoResp = "Elementos: ${it.response.payload.size}"
                    binding.et1.text = textoResp
                    initRecyclerView(it.response.payload)
                }
                is DataState.Error -> {
                    Log.e("_ERROR_", "$it.error.message")
                    Toast.makeText(requireContext(), it.error.message, Toast.LENGTH_LONG).show()
                }
            }
        })
        bookViewModel.makeApiCall(
            BooksStateEvent.GetBooks(requireContext())
        )
    }

    override fun onLoading(msg: String) {
        Log.i("getTicker_", "onLoading")
        Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
    }

    override fun onError() {
        Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
    }

    override fun onSucess(ticker: Ticker) {
        tickerViewModel.makeApiCall(
            TickerStateEvent.SaveTicker(ticker)
        )
        Toast.makeText(requireContext(), "onSucess, todo ok con Rx!!", Toast.LENGTH_LONG).show()
        val bookBundle = bundleOf("book" to book, "ticker" to ticker)
        view?.findNavController()?.navigate(R.id.detailsFragment, bookBundle)
    }
}