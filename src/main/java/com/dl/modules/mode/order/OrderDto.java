package com.dl.modules.mode.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单
 */
@Data
public class OrderDto {

    /** openID */
    private String openid;
    /** 门店ID */
    private String storeId;
    /** 订单id */
    private String orderId;
    /** 订单号 */
    private String orderCode;
    /** 购物车ids */
    private List<Long> cartIds;
    /** 订单ids */
    private List<String> orderIds;
    /** 订单总价格 */
    private BigDecimal totalPrice;
    /** 收货人地址id */
    private Long addressId;
    /** 备注 */
    private String remark;
    /** 付款状态: 0-待支付, 1-已支付 */
    private Integer settleStatus;
    /** 订单状态: 0-待处理, 1-已确认, 2-已发货, 3-已完成, 4-已取消 */
    private Integer status;
    /** 查询状态  1-待付款 2-待发货 3-待收货 */
    private Integer queryStatus;
    /** 提交订单的来源 TV:精选tv XCX:精选小程序 */
    private int source;
    private Integer pageNum = 1;
    private Integer pageSize = 5;
}