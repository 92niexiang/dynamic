package com.nx.dynamic.user.dao;

import com.nx.dynamic.user.model.RouterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RouterRepository extends JpaRepository<RouterEntity, Long>,JpaSpecificationExecutor<RouterEntity> {

    @Query("select d.name from RouterEntity d where d.id=:id")
    String getName(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update RouterEntity d set d.description=:description where d.id=:id")
    Integer editOldDescription(@Param("id") Long ids, @Param("description") String description);

    @Modifying
    @Transactional
    @Query("delete from RouterEntity d where d.id in(?1)")
    void deleteInBatch(List<Long> list);

    @Query("select d.id from RouterEntity d where d.description=:description and d.destination=:destination and d.vrName=:vrName and d.netmask=:netmask and d.nexthop=:nexthop and d.routeType=:routeType and d.nexthopType=:nexthopType and d.ifGate=:ifGate")
    Long getRouterId(@Param("description") String description, @Param("destination") String destination, @Param("vrName") String vrName, @Param("netmask") String netmask, @Param("nexthop") String nexthop, @Param("routeType") Integer routeType, @Param("nexthopType") Integer nexthopType, @Param("ifGate") String ifGate);

    @Query("select d.name from RouterEntity d where d.id=:id ")
    String getRouterNameById(@Param("id") Long id);

    @Query("select MAX(id)+1 from RouterEntity")
    String getMaxId();
}

