package com.partner.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 即时通讯消息记录表
 * </p>
 *
 * @author conlon123
 * @since 2019-04-01
 */
@Data
@Accessors(chain = true)
@TableName("partner_bs_message")
public class PartnerBsMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id" , type = IdType.AUTO)
    private Long id;
    /**
     * 发送人user_id
     */
    @TableField("send_user_id")
    private Long sendUserId;
    /**
     * 接收者user_id
     */
    @TableField("accepter_user_id")
    private Long accepterUserId;
    /**
     * 消息内容
     */
    @TableField("netty_message")
    private String nettyMessage;
    /**
     * 0:未读 , 1:已读
     */
    @TableField("message_read")
    private Integer messageRead;
    @TableField("create_time")
    private Date createTime;


}