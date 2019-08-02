package com.alexeus.trademo.dao;

import com.alexeus.trademo.domain.FactoryObject;

import java.util.Collection;
import java.util.Map;

public interface FactoryObjectsSearchRepository {
    Collection<FactoryObject> findObjects(Map<String, String[]> params);
}
