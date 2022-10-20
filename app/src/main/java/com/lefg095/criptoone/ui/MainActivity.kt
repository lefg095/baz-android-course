package com.lefg095.criptoone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import com.lefg095.criptoone.R
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

//        changeFragment(BlankFragment.newInstance())
    }


    private fun changeFragment(targetFragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.root_layout, targetFragment, "fragment")
            .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }

    private fun subscribeObservers(){
        bookViewModel.bookResponse.observe(this@MainActivity, {
            when(it){
                is DataState.Loading -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Success -> {
                    Toast.makeText(this, "Libros encontrados: ${it.response.payload.size}", Toast.LENGTH_LONG).show()
                }
                is DataState.Error -> {
                    Log.e("_ERROR_", "$it.error.message")
                    Toast.makeText(this, it.error.message, Toast.LENGTH_LONG).show()
                }
            }
        })
        bookViewModel.makeApiCall(
            BooksStateEvent.GetBooks
        )
    }

}