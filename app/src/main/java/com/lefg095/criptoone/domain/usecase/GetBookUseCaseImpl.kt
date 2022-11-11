package com.lefg095.criptoone.domain.usecase

import android.content.Context
import com.lefg095.criptoone.data.BookRepository
import com.lefg095.criptoone.domain.model.Book
import com.lefg095.criptoone.domain.response.BookResponse
import com.lefg095.criptoone.domain.stateevent.DataState
import com.lefg095.criptoone.util.MSG
import com.lefg095.criptoone.util.isConnectedToNet
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class BookUseCase @Inject constructor(
    private val repository: BookRepository
) {

    suspend fun invoke(
        context: Context
      ): Flow<DataState<BookResponse<Book>>> = flow {
          emit(DataState.Loading(MSG))
          try{
              if (isConnectedToNet(context)) {
                  val response = repository.getExternalBooks()
                  if (response.success == "") {
                      val books: List<Book> = repository.getExternalBooks().payload
                      if (books.isNotEmpty()) {
                          repository.cleanBooks()
                          repository.saveBooks(books = books)
                      }
                  }
              }
              emit(
                  DataState.Success(
                  BookResponse(
                      success = "",
                      payload = repository.getLocalBooks()
                  )
              ))
          }catch (e:Exception){
              emit(DataState.Error(e))
          }
      }
}