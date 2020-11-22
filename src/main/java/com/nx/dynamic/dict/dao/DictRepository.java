package com.nx.dynamic.dict.dao;

//import com.baomidou.dynamic.datasource.annotation.DS;
import com.nx.dynamic.dict.model.DictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DictRepository extends JpaRepository<DictEntity,Long>{

    @Query("select d.oldId from DictEntity d where d.id=:id")
    String getOldId(@Param("id") Long id);

    @Query("select d.id from DictEntity d where d.oldId=:id and d.productType=:product_type and d.supplierType=:supplier_type")
    Long getNewId(@Param("id") String id, @Param("supplier_type") Integer supplier_type, @Param("product_type") Integer product_type);

    @Query("select d.id from DictEntity d where d.oldName=:name and d.productType=:product_type and d.supplierType=:supplier_type")
    Long getNewIds(@Param("name") String name, @Param("product_type") Integer product_type, @Param("supplier_type") Integer supplier_type);

    @Query("select d.oldName from DictEntity d where d.id=:id")
    String getOldName(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update DictEntity d set d.oldDescription=:description where d.id=:id")
    Integer editOldDescription(@Param("id") Long id, @Param("description") String description);

    @Modifying
    @Transactional
    @Query("update DictEntity d set d.oldName=:name where d.id=:id")
    Integer editName(@Param("id") Long id, @Param("name") String name);

    @Query("select d.oldDescription from DictEntity d where d.id=:id")
    String getOldDescription(@Param("id") Long id);

    @Query("select d.oldName from DictEntity d where d.id in(:ids)")
    List<String> selectByNameBatch(@Param("ids") List<Long> list);

    @Query("select d.oldId from DictEntity d where d.id in(:ids)")
    List<String> selectByUUIDBatch(@Param("ids") List<Long> list);

    @Modifying
    @Transactional
    @Query("delete from DictEntity d where d.id in(?1)")
    void deleteInBatch(List<Long> list);

    @Modifying
    @Transactional
    @Query("update DictEntity d set d.oldName=:name where d.id=:id")
    Integer editOldName(@Param("id") Long id, @Param("name") String description);

    @Query("select d.id from DictEntity d where d.oldName=:name")
    Long getId(@Param("name") String name);

    @Query("select d.id from DictEntity d where d.oldName=:name and d.supplierType=:supplierType and d.productType=:productType")
    Long getId(@Param("name") String name, @Param("supplierType") Integer supplierType, @Param("productType") Integer productType);

}
