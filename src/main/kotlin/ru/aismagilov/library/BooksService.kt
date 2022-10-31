package ru.aismagilov.library

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Service
class BooksService(private val booksRepository: BooksRepository) {
    fun getAll(): List<Book> = booksRepository.findAll()

    fun getById(id: Long): Book = booksRepository.findById(id).orElseThrow { NotFoundException() }

    fun create(book: Book): Book = booksRepository.save(book)

    fun updateById(id: Long, book: Book): Book =
        if (booksRepository.existsById(id)) booksRepository.save(book.copy())
        else throw NotFoundException()

    fun deleteById(id: Long) =
        if (booksRepository.existsById(id)) booksRepository.deleteById(id)
        else throw NotFoundException()
}