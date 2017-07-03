package com.g11n.bookstore.model.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 16-5-3.
 */
public abstract class CommonDaoImpl<T extends java.io.Serializable> implements ICommonDao{
    @Override
    public int save(Serializable serializable) {
        return 0;
    }

    @Override
    public int update(Serializable serializable) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int delete(Serializable serializable) {
        return 0;
    }

    @Override
    public Serializable findById(int id) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public List findByInstance(Serializable serializable) {
        return null;
    }

    @Override
    public List find(int start, int count, String order) {
        return null;
    }
}

