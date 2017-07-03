package com.tks.core;

import com.tks.entity.Product;
import com.tks.entity.Release;
import com.tks.entity.Task;
import com.tks.entity.TaskStatus;

import java.util.List;

/**
 * Created by wanjia on 2016/9/1.
 */
public interface IReleaseRepoService {
    /**
     * Find all tasks for specific Product
     * @param p product
     * @return list of tasks for specified product
     */
    List<Release> findByProduct(Product product) ;

}
