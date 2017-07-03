package com.g11n.bookstore.model.service;

import java.util.List;

/**
 * Created by Administrator on 16-5-3.
 */
public interface ICommonService<T extends java.io.Serializable> {
    List<T> findAll();
}
