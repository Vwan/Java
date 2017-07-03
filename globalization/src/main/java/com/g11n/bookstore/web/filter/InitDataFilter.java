package com.g11n.bookstore.web.filter;

import com.g11n.bookstore.model.entity.Book;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-3.
 */

@WebFilter("/index.jsp")
public class InitDataFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("test");
        List<Book> books=new ArrayList<Book>();
        Book b = new Book(1,"book1");
        books.add(b);
        request.setAttribute("books",books);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
