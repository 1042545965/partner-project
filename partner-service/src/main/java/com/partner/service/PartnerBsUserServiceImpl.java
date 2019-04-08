package com.partner.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.partner.api.PartnerBsUserService;
import com.partner.dao.PartnerBsUserDao;
import com.partner.entity.PartnerBsUser;
import com.ruoyi.common.core.result.RestResponseBo;
import com.ruoyi.common.enums.operation.OptBaseExceptionEnum;
import com.ruoyi.common.enums.operation.OptUserExceptionEnum;
import com.ruoyi.common.exception.operation.OptBaseException;
import com.ruoyi.common.exception.operation.OptUserException;
import com.ruoyi.common.exception.user.UserException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.Md5Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author conlon123
 * @since 2019-04-01
 */
@Service
public class PartnerBsUserServiceImpl implements PartnerBsUserService {


    @Resource
    private PartnerBsUserDao partnerBsUserDao;

    /**
     * 查询用户表
     *
     * @param partnerBsUser 信息
     * @return 结果
     */
    @Override
    public List<PartnerBsUser> selectList(PartnerBsUser partnerBsUser) {
        EntityWrapper<PartnerBsUser> entityWrapper = getEntityWrapper(partnerBsUser);
        return partnerBsUserDao.selectList(entityWrapper);
    }

    /**
     * 查询用户表
     *
     * @param id 信息
     * @return 结果
     */
    @Override
    public PartnerBsUser selectPartnerBsUserById(Long id) {
        return partnerBsUserDao.selectById(id);
    }

    /**
     * 查询用户表
     *
     * @param partnerBsUser 信息
     * @return 结果
     */
    @Override
    public PartnerBsUser selectPartnerBsUserByOne(PartnerBsUser partnerBsUser) {
        return partnerBsUserDao.selectOne(partnerBsUser);
    }

    /**
     * 修改用户表
     *
     * @param partnerBsUser 信息
     * @return 结果
     */
    @Override
    public int updatePartnerBsUser(PartnerBsUser partnerBsUser) {
        return partnerBsUserDao.updateById(partnerBsUser);
    }

    /**
     * 新增用户表
     *
     * @param partnerBsUser 信息
     * @return 结果
     */
    @Override
    public int insertPartnerBsUser(PartnerBsUser partnerBsUser) {
        return partnerBsUserDao.insert(partnerBsUser);
    }

    @Override
    public RestResponseBo<List<PartnerBsUser>> getLinkUserList(String userIds) {
        if (StringUtils.isEmpty(userIds)){
            throw new OptBaseException(OptBaseExceptionEnum.PARAMETER_ERROR);
        }
        EntityWrapper<PartnerBsUser> entityWrapper = new EntityWrapper<>();
        entityWrapper.in("id" , userIds);
        return RestResponseBo.ok(partnerBsUserDao.selectList(entityWrapper));
    }

    @Override
    public RestResponseBo userLogin(String username, String password) {
        PartnerBsUser partnerBsUser = new PartnerBsUser();
        partnerBsUser.setUserName(username);
        PartnerBsUser queryUser = this.selectPartnerBsUserByOne(partnerBsUser);
        if (StringUtils.isNull(queryUser)){
            throw new OptUserException(OptUserExceptionEnum.USER_NOT_EXIST);
        }
        if (!Md5Utils.verify(password , username , queryUser.getPassword())){
            throw new OptUserException(OptUserExceptionEnum.USER_PASSWORD_ERROR);
        }
        return RestResponseBo.ok();
    }

    @Override
    @Transactional
    public RestResponseBo userRegister(PartnerBsUser partnerBsUser) {
        String md5 = Md5Utils.md5(partnerBsUser.getPassword(), partnerBsUser.getUserName());
        partnerBsUser.setPassword(md5);
        int i = this.insertPartnerBsUser(partnerBsUser);
        if (i != 1){
            throw new OptUserException(OptUserExceptionEnum.USER_REGISTER_ERROR);
        }
        return RestResponseBo.ok();
    }

    @Override
    public PartnerBsUser selectPartnerBsUserByUserName(String userName) {
        if (StringUtils.isEmpty(userName)){
            throw new OptUserException(OptUserExceptionEnum.USER_NAME_NOT_NULL);
        }
        return this.selectPartnerBsUserByOne(new PartnerBsUser().setUserName(userName));
    }

    /**
     * 公共查询条件
     *
     * @param partnerBsUser
     * @return
     */
    private EntityWrapper<PartnerBsUser> getEntityWrapper(PartnerBsUser partnerBsUser) {
        EntityWrapper<PartnerBsUser> entityWrapper = new EntityWrapper<>();
        //条件拼接
        if (StringUtils.isNotBlank(partnerBsUser.getUserName())) {
            entityWrapper.eq("user_name" , partnerBsUser.getUserName());
        }
        if (StringUtils.isNotBlank(partnerBsUser.getPassword())) {
            entityWrapper.eq("password" , partnerBsUser.getPassword());
        }
        if (StringUtils.isNotBlank(partnerBsUser.getNickName())) {
            entityWrapper.eq("nick_name" , partnerBsUser.getNickName());
        }
        if (StringUtils.isNotBlank(partnerBsUser.getUserMobile())) {
            entityWrapper.eq("user_mobile" , partnerBsUser.getUserMobile());
        }
        if (StringUtils.isNotNull(partnerBsUser.getUserStatus())) {
            entityWrapper.eq("user_status" , partnerBsUser.getUserStatus());
        }
        if (StringUtils.isNotNull(partnerBsUser.getCreateTime())) {
            entityWrapper.eq("create_time" , partnerBsUser.getCreateTime());
        }
        if (StringUtils.isNotBlank(partnerBsUser.getUserType())) {
            entityWrapper.eq("user_type" , partnerBsUser.getUserType());
        }
        if (StringUtils.isNotBlank(partnerBsUser.getOpenId())) {
            entityWrapper.eq("open_id" , partnerBsUser.getOpenId());
        }
        if (StringUtils.isNotBlank(partnerBsUser.getUserSex())) {
            entityWrapper.eq("user_sex" , partnerBsUser.getUserSex());
        }
        if (StringUtils.isNotBlank(partnerBsUser.getUserCity())) {
            entityWrapper.eq("user_city" , partnerBsUser.getUserCity());
        }
        if (StringUtils.isNotBlank(partnerBsUser.getUserArea())) {
            entityWrapper.eq("user_area" , partnerBsUser.getUserArea());
        }
        if (StringUtils.isNotBlank(partnerBsUser.getUserProvince())) {
            entityWrapper.eq("user_province" , partnerBsUser.getUserProvince());
        }
        if (StringUtils.isNotBlank(partnerBsUser.getUnionid())) {
            entityWrapper.eq("unionid" , partnerBsUser.getUnionid());
        }
        if (StringUtils.isNotNull(partnerBsUser.getFailTimes())) {
            entityWrapper.eq("fail_times" , partnerBsUser.getFailTimes());
        }
        return entityWrapper;
    }
}
