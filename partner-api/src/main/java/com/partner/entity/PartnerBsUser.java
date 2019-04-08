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
 * 用户表
 * </p>
 *
 * @author conlon123
 * @since 2019-04-01
 */
@Data
@Accessors(chain = true)
@TableName("partner_bs_user")
public class PartnerBsUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id" , type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户昵称
     */
    @TableField("nick_name")
    private String nickName;
    /**
     * 手机号码
     */
    @TableField("user_mobile")
    private String userMobile;
    /**
     * 用户状态(暂未使用)
     */
    @TableField("user_status")
    private Integer userStatus;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 用户级别
     */
    @TableField("user_type")
    private String userType;
    /**
     * 微信用户的标识
     */
    @TableField("open_id")
    private String openId;
    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    @TableField("user_sex")
    private String userSex;
    /**
     * 用户所在城市
     */
    @TableField("user_city")
    private String userCity;
    /**
     * 用户所区域(详细地址)
     */
    @TableField("user_area")
    private String userArea;
    /**
     * 用户所在省份
     */
    @TableField("user_province")
    private String userProvince;
    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    private String unionid;
    /**
     * 登录失败次数
     */
    @TableField("fail_times")
    private Integer failTimes;


}