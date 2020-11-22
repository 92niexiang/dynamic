package com.nx.dynamic.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "router")
@Data
public class RouterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String name; // 天玑平台路由名称
    private String destination; // 目的ip
    private String netmask; // 掩码
    @Column(name = "gate_ifname")
    private String gateIfname; // 网关的下一跳接口名称
    private String preference;
    private String weight; // 权重
    private String nexthop; // 可能是ip或接口
    @Column(name = "nexthop_type")
    private Integer nexthopType; // 3---网关 5---接口 10---虚拟路由器
    @Column(name = "vr_name")
    private String vrName;
    @Column(name = "route_type")
    private Integer routeType; // 2---目的路由
    @Column(name = "nexthop_flags")
    private Integer nexthopFlags;
    @Column(name = "if_gate")
    private String ifGate;// nexthopType=5，指定的网关IP地址
    private String description;

}
