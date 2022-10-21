// Generated by Dagger (https://dagger.dev).
package com.lefg095.criptoone.viewmodel;

import com.lefg095.criptoone.data.interfaces.IBookRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class BookViewModel_Factory implements Factory<BookViewModel> {
  private final Provider<IBookRepository> booksIBookRepositoryProvider;

  public BookViewModel_Factory(Provider<IBookRepository> booksIBookRepositoryProvider) {
    this.booksIBookRepositoryProvider = booksIBookRepositoryProvider;
  }

  @Override
  public BookViewModel get() {
    return newInstance(booksIBookRepositoryProvider.get());
  }

  public static BookViewModel_Factory create(
      Provider<IBookRepository> booksIBookRepositoryProvider) {
    return new BookViewModel_Factory(booksIBookRepositoryProvider);
  }

  public static BookViewModel newInstance(IBookRepository booksIBookRepository) {
    return new BookViewModel(booksIBookRepository);
  }
}