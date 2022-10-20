package com.lefg095.criptoone.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.lefg095.criptoone.R
import com.lefg095.criptoone.domain.BooksStateEvent
import com.lefg095.criptoone.domain.DataState
import com.lefg095.criptoone.viewmodel.BookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlankFragment : Fragment() {
    private val bookViewModel by activityViewModels<BookViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
    }

    private fun subscribeObservers(){
        bookViewModel.bookResponse.observe(viewLifecycleOwner, {
            when(it){
                is DataState.Loading -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Success -> {
                    Toast.makeText(requireContext(), "Libros encontrados: ${it.response.payload.size}", Toast.LENGTH_LONG).show()
                }
                is DataState.Error -> {
                    Log.e("_ERROR_", "$it.error.message")
                    Toast.makeText(requireContext(), it.error.message, Toast.LENGTH_LONG).show()
                }
            }
        })
        bookViewModel.makeApiCall(
            BooksStateEvent.GetBooks
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BlankFragment().apply {

            }
    }
}