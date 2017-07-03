package com.g11n.bookstore.model.dao;

import com.g11n.bookstore.model.entity.Book;

import java.util.List;

/**
 * Created by Administrator on 16-5-3.
 */
public class BookDaoImpl extends CommonDaoImpl<Book> {
    List<Book> books;

    public  BookDaoImpl(List<Book> books){
        this.books=books;
    }
    public Book findById(int id){
        for (Book b:books){
            if(b.getId()==id) return b;
            break;
        }
        return null;

    }
}
