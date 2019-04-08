package com.partner.api;

import com.partner.entity.PartnerBsUser;
import com.ruoyi.common.core.result.RestResponseBo;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author conlon123
 * @since 2019-04-01
 */
public interface PartnerBsUserService {

    /**
     * 查询${tableComment}
     *
     * @param partnerBsUser 信息
     * @return 结果
     */
    public List<PartnerBsUser> selectList(PartnerBsUser partnerBsUser);

    /**
     * 查询${tableComment}
     *
     * @param id 信息
     * @return 结果
     */
    public PartnerBsUser selectPartnerBsUserById(Long id);

    /**
     * 查询${tableComment}
     *
     * @param partnerBsUser 信息
     * @return 结果
     */
    public PartnerBsUser selectPartnerBsUserByOne(PartnerBsUser partnerBsUser);

    /**
     * 修改${tableComment}
     *
     * @param partnerBsUser 信息
     * @return 结果
     */
    public int updatePartnerBsUser(PartnerBsUser partnerBsUser);

    /**
     * 新增${tableComment}
     *
     * @param partnerBsUser 信息
     * @return 结果
     */
    public int insertPartnerBsUser(PartnerBsUser partnerBsUser);

    /**
     * @param userIds
     * @return
     */
    RestResponseBo<List<PartnerBsUser>> getLinkUserList(String userIds);

    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
    RestResponseBo userLogin(String username, String password);

    /**
     * 用户注册
     * @param partnerBsUser
     * @return
     */
    RestResponseBo userRegister(PartnerBsUser partnerBsUser);

    /**
     * 用户名查找
     * @param userName
     * @return
     */
    PartnerBsUser selectPartnerBsUserByUserName(String userName);
}
