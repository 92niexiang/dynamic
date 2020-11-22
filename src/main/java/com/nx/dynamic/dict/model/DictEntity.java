package com.nx.dynamic.dict.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "dict")
@Data
public class DictEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "old_id")
    private String oldId;

    @Column(name = "old_name")
    private String oldName;

    @Column(name = "old_description")
    private String oldDescription;

    @Column(name = "supplier_type")
    private Integer supplierType;

    @Column(name = "product_type")
    private Integer productType;

    private Integer enable;

    public DictEntity(String oldId, String oldName) {
        this.oldId = oldId;
        this.oldName = oldName;
    }

    public DictEntity(String oldId, String oldName, String oldDescription,Integer productType,Integer supplierType) {
        this.oldId = oldId;
        this.oldName = oldName;
        this.oldDescription = oldDescription;
        this.productType = productType;
        this.supplierType = supplierType;
    }

    public DictEntity() {
    }
}
