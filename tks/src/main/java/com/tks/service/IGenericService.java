package com.tks.service;

import com.tks.core.IGenericRepoService;
import com.tks.entity.GenericEntity;
import com.tks.repo.impl.GenericRepo;

public interface IGenericService<T extends GenericEntity, R extends GenericRepo> extends IGenericRepoService<T>{

}
