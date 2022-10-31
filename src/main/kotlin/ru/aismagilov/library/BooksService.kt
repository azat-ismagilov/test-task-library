package ru.aismagilov.library

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class BooksService(private val booksRepository: BooksRepository) {
    fun getAll(): List<Book> = booksRepository.findAll()

    fun getById(id: Long): Book = booksRepository.findById(id)
        .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "There is no book with such id") }

    fun create(book: Book): Book = booksRepository.save(book)

    fun updateById(id: Long, book: Book): Book =
        if (booksRepository.existsById(id)) booksRepository.save(book.copy())
        else throw ResponseStatusException(HttpStatus.NOT_FOUND, "There is no book with such id")

    fun deleteById(id: Long) =
        if (booksRepository.existsById(id)) booksRepository.deleteById(id)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND, "There is no book with such id")
}