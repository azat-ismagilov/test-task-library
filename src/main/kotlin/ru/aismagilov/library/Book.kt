package ru.aismagilov.library

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "books")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val title: String,
    val description: String,
    @ManyToOne(cascade = [CascadeType.ALL])
    val author: Author,
    val isbn: String,
    val printYear: Int,
    val readAlready: Boolean
)

@Entity
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val name: String,
    val lastName: String
)
