package com.lefg095.criptoone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.lefg095.criptoone.domain.BooksStateEvent
import com.lefg095.criptoone.domain.DataState
import com.lefg095.criptoone.viewmodel.BookViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val bookViewModel by viewModels<BookViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        subscribeObservers()
    }

    private fun subscribeObservers(){
        bookViewModel.bookResponse.observe(this@MainActivity, {
            when(it){
                is DataState.Loading -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Success -> {
                    //AlertsNotifications().alertNormal(this.requireContext())
                    println(it.response.payload)
                }
                is DataState.Error -> {
                    Toast.makeText(this, "Error :(", Toast.LENGTH_LONG).show()
                }
            }
        })
        bookViewModel.makeApiCall(
            BooksStateEvent.GetBooks
        )
    }
}