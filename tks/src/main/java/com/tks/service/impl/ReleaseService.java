package com.tks.service.impl;

import com.tks.entity.Product;
import com.tks.entity.Release;
import com.tks.repo.impl.ReleaseRepo;
import com.tks.service.IReleaseService;

import java.util.List;

@SuppressWarnings("unchecked")
public class ReleaseService extends AbstractGenericService<Release,ReleaseRepo> implements IReleaseService {


    @Override
    public List<Release> findByProduct(Product product) {
        return repo.findByProduct(product);
    }
}
