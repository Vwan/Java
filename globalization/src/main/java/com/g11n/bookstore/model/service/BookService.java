package com.g11n.bookstore.model.service;

import com.g11n.bookstore.model.entity.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-3.
 */
public class BookService {
    List<Book> books ;

    public BookService(List<Book> books){
        this.books=books;
    }

}
