package com.nx.dynamic.dict.service;

import com.nx.dynamic.dict.model.DictEntity;

import java.util.List;

public interface SysDictService {
    String getOldId(Long id);
    String getOldName(Long id);
    Long getNewId(String id, Integer product_type, Integer supplier_type);
    Long getNewIds(String name, Integer product_type, Integer supplier_type);
    String getOldDescription(Long id);
    Integer editOldDescription(Long id, String description);
    Integer editOldName(Long id, String name);
    Long add(DictEntity dictEntity);
    void deleteDict(Long id);
    List<String> selectByNameBatch(List<Long> list);
    List<String> selectByUUIDBatch(List<Long> list);
    void deleteBatch(List<Long> list);
}
