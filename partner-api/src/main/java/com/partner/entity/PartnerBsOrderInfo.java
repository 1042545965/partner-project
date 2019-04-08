package com.partner.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 订单信息表
 * </p>
 *
 * @author conlon123
 * @since 2019-03-30
 */
@Data
@Accessors(chain = true)
@TableName("partner_bs_order_info")
public class PartnerBsOrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 校验码
     */
    @TableField("verification_code")
    private String verificationCode;
    /**
     * 订单编号
     */
    @TableField("order_no")
    private String orderNo;
    /**
     * 预约时间
     */
    @TableField("appoint_date")
    private Date appointDate;
    /**
     * 验证类型：1扫码，2输入
     */
    @TableField("order_scan")
    private Integer orderScan;
    /**
     * 公共发型id
     */
    @TableField("public_hair_id")
    private Long publicHairId;
    /**
     * 用户的ID
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 门店服务产品ID
     */
    @TableField("goods_id")
    private Long goodsId;
    /**
     * 门店ID
     */
    @TableField("store_id")
    private Long storeId;
    /**
     * 服务状态 10：待付款 20：待服务 30：已完成 90：已退款 50：已过期 , 60:支付超时 , 70 : 订单超时支付成功
     */
    @TableField("order_status")
    private Integer orderStatus;
    /**
     * 改签状态 10：未改签  20：已改签 且用户只能改签一次
     */
    @TableField("change_status")
    private Integer changeStatus;
    /**
     * 耗材提交状态（10待提交,20已提交）
     */
    @TableField("expend_status")
    private Integer expendStatus;
    /**
     * 评论状态（10：待评论 20 ：已评论）
     */
    @TableField("comment_status")
    private Integer commentStatus;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
    /**
     * 版本号
     */
    private Long version;
    /**
     * 订单金额
     */
    @TableField("order_money")
    private BigDecimal orderMoney;
    /**
     * 员工id
     */
    @TableField("employee_id")
    private Long employeeId;
    /**
     * 订单对应的工位号
     */
    @TableField("station_num")
    private Integer stationNum;
    /**
     * 改签时间
     */
    @TableField("change_time")
    private Date changeTime;
    /**
     * 订单完成时间
     */
    @TableField("finish_time")
    private Date finishTime;
    /**
     * 退款原因记录({parameter配置的key}:{原因})
     */
    @TableField("refund_remark")
    private String refundRemark;
    /**
     * 退款操作人 , 只有后台操作的时候才要
     */
    @TableField("refund_by")
    private String refundBy;


}