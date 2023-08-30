package com.atguigu.domain;

import lombok.Data;

/**
 * @auther zzyy
 * @create 2019-12-11 16:40
 */

@Data
public class Storage {

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}