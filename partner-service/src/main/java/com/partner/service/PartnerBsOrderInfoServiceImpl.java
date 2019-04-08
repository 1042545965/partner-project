package com.partner.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.partner.api.PartnerBsOrderInfoService;
import com.partner.dao.PartnerBsOrderInfoDao;
import com.partner.entity.PartnerBsOrderInfo;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单信息表 服务实现类
 * </p>
 *
 * @author conlon123
 * @since 2019-03-30
 */
@Service
public class PartnerBsOrderInfoServiceImpl implements PartnerBsOrderInfoService {


    @Autowired
    private PartnerBsOrderInfoDao partnerBsOrderInfoDao;

    /**
     * 查询订单信息表
     *
     * @param partnerBsOrderInfo
     * @return 结果
     */
    @Override
    public List<PartnerBsOrderInfo> selectList(PartnerBsOrderInfo partnerBsOrderInfo) {
        EntityWrapper<PartnerBsOrderInfo> entityWrapper = getEntityWrapper(partnerBsOrderInfo);
        return partnerBsOrderInfoDao.selectList(entityWrapper);
    }

    /**
     * 查询订单信息表
     *
     * @param  id 信息
     * @return 结果
     */
    @Override
    public PartnerBsOrderInfo selectPartnerBsOrderInfoById(Long id) {
        return partnerBsOrderInfoDao.selectById(id);
    }

    /**
     * 查询订单信息表
     *
     * @param partnerBsOrderInfo
     * @return 结果
     */
    @Override
    public PartnerBsOrderInfo selectPartnerBsOrderInfoByOne(PartnerBsOrderInfo partnerBsOrderInfo) {
        return partnerBsOrderInfoDao.selectOne(partnerBsOrderInfo);
    }

    /**
     * 修改订单信息表
     *
     * @param partnerBsOrderInfo
     * @return 结果
     */
    @Override
    public int updatePartnerBsOrderInfo(PartnerBsOrderInfo partnerBsOrderInfo) {
        return partnerBsOrderInfoDao.updateById(partnerBsOrderInfo);
    }

    /**
     * 新增订单信息表
     *
     * @param partnerBsOrderInfo
     * @return 结果
     */
    @Override
    public int insertPartnerBsOrderInfo(PartnerBsOrderInfo partnerBsOrderInfo) {
        return partnerBsOrderInfoDao.insert(partnerBsOrderInfo);
    }

    /**
     * 公共查询条件
     *
     * @param partnerBsOrderInfo
     * @return
     */
    @Override
    public EntityWrapper<PartnerBsOrderInfo> getEntityWrapper(PartnerBsOrderInfo partnerBsOrderInfo) {
        EntityWrapper<PartnerBsOrderInfo> entityWrapper = new EntityWrapper<>();
        //条件拼接
        if (StringUtils.isNotBlank(partnerBsOrderInfo.getVerificationCode())) {
            entityWrapper.eq("verification_code", partnerBsOrderInfo.getVerificationCode());
        }
        if (StringUtils.isNotBlank(partnerBsOrderInfo.getOrderNo())) {
            entityWrapper.eq("order_no", partnerBsOrderInfo.getOrderNo());
        }
        if (StringUtils.isNotNull(partnerBsOrderInfo.getAppointDate())) {
            entityWrapper.eq("appoint_date", partnerBsOrderInfo.getAppointDate());
        }
        if (StringUtils.isNotNull(partnerBsOrderInfo.getOrderScan())) {
            entityWrapper.eq("order_scan", partnerBsOrderInfo.getOrderScan());
        }
        if (StringUtils.isNotNull(partnerBsOrderInfo.getPublicHairId())) {
            entityWrapper.eq("public_hair_id", partnerBsOrderInfo.getPublicHairId());
        }
        if (StringUtils.isNotNull(partnerBsOrderInfo.getUserId())) {
            entityWrapper.eq("user_id", partnerBsOrderInfo.getUserId());
        }
        if (StringUtils.isNotNull(partnerBsOrderInfo.getGoodsId())) {
            entityWrapper.eq("goods_id", partnerBsOrderInfo.getGoodsId());
        }
        if (StringUtils.isNotNull(partnerBsOrderInfo.getStoreId())) {
            entityWrapper.eq("store_id", partnerBsOrderInfo.getStoreId());
        }
        if (StringUtils.isNotNull(partnerBsOrderInfo.getOrderStatus())) {
            entityWrapper.eq("order_status", partnerBsOrderInfo.getOrderStatus());
        }
        if (StringUtils.isNotNull(partnerBsOrderInfo.getChangeStatus())) {
            entityWrapper.eq("change_status", partnerBsOrderInfo.getChangeStatus());
        }
        if (StringUtils.isNotNull(partnerBsOrderInfo.getExpendStatus())) {
            entityWrapper.eq("expend_status", partnerBsOrderInfo.getExpendStatus());
        }
        if (StringUtils.isNotNull(partnerBsOrderInfo.getCommentStatus())) {
            entityWrapper.eq("comment_status", partnerBsOrderInfo.getCommentStatus());
        }
        if (StringUtils.isNotNull(partnerBsOrderInfo.getCreateTime())) {
            entityWrapper.eq("create_time", partnerBsOrderInfo.getCreateTime());
        }
        if (StringUtils.isNotNull(partnerBsOrderInfo.getUpdateTime())) {
            entityWrapper.eq("update_time", partnerBsOrderInfo.getUpdateTime());
        }
        if (StringUtils.isNotNull(partnerBsOrderInfo.getVersion())) {
            entityWrapper.eq("version", partnerBsOrderInfo.getVersion());
        }
        if (StringUtils.isNotNull(partnerBsOrderInfo.getOrderMoney())) {
            entityWrapper.eq("order_money", partnerBsOrderInfo.getOrderMoney());
        }
        if (StringUtils.isNotNull(partnerBsOrderInfo.getEmployeeId())) {
            entityWrapper.eq("employee_id", partnerBsOrderInfo.getEmployeeId());
        }
        if (StringUtils.isNotNull(partnerBsOrderInfo.getStationNum())) {
            entityWrapper.eq("station_num", partnerBsOrderInfo.getStationNum());
        }
        if (StringUtils.isNotNull(partnerBsOrderInfo.getChangeTime())) {
            entityWrapper.eq("change_time", partnerBsOrderInfo.getChangeTime());
        }
        if (StringUtils.isNotNull(partnerBsOrderInfo.getFinishTime())) {
            entityWrapper.eq("finish_time", partnerBsOrderInfo.getFinishTime());
        }
        if (StringUtils.isNotBlank(partnerBsOrderInfo.getRefundRemark())) {
            entityWrapper.eq("refund_remark", partnerBsOrderInfo.getRefundRemark());
        }
        if (StringUtils.isNotBlank(partnerBsOrderInfo.getRefundBy())) {
            entityWrapper.eq("refund_by", partnerBsOrderInfo.getRefundBy());
        }
        return entityWrapper;
    }
}
