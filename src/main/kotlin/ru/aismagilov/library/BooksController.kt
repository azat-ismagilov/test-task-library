package ru.aismagilov.library

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("books")
class BooksController(private val booksService: BooksService) {

    @GetMapping
    fun getAll(): List<Book> = booksService.getAll()

    @GetMapping("{id}")
    fun getById(@PathVariable("id") id: Long): Book =
        booksService.getById(id)

    @PostMapping()
    fun createEmployee(@RequestBody payload: Book): Book = booksService.create(payload)

    @PutMapping("{id}")
    fun updateById(@PathVariable("id") id: Long, @RequestBody payload: Book): Book =
        booksService.updateById(id, payload)

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable("id") id: Long): Unit =
        booksService.deleteById(id)
}