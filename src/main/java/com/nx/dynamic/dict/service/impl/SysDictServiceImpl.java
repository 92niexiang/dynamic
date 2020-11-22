package com.nx.dynamic.dict.service.impl;

import com.nx.dynamic.dict.dao.DictRepository;
import com.nx.dynamic.dict.model.DictEntity;
import com.nx.dynamic.dict.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SysDictServiceImpl implements SysDictService {

    @Autowired
    DictRepository repository;

    @Override
    public String getOldId(Long id) {
        return repository.getOldId(id);
    }

    @Override
    public String getOldName(Long id) {
        return repository.getOldName(id);
    }

    @Override
    public Long getNewId(String id,Integer product_type,Integer supplier_type) {
        return repository.getNewId(id,product_type,supplier_type);
    }

    @Override
    public Long getNewIds(String name,Integer product_type,Integer supplier_type) {
        return repository.getNewIds(name,product_type,supplier_type);
    }

    @Override
    public String getOldDescription(Long id) {
        return repository.getOldDescription(id);
    }

    @Override
    public Integer editOldDescription(Long id,String description) {
        return repository.editOldDescription(id,description);
    }

    @Override
    public Integer editOldName(Long id, String name) {
        return repository.editOldName(id,name);
    }

    @Override
    public Long add(DictEntity dictEntity) {
        repository.save(dictEntity);
        return dictEntity == null ? null : dictEntity.getId();
    }

    @Override
    public void deleteDict(Long id) {
        repository.delete(id);
    }

    @Override
    public List<String> selectByNameBatch(List<Long> list) {
        return repository.selectByNameBatch(list);
    }

    @Override
    public List<String> selectByUUIDBatch(List<Long> list) {
        return repository.selectByUUIDBatch(list);
    }

    @Override
    public void deleteBatch(List<Long> list) {
        this.repository.deleteInBatch(list);
    }
}
