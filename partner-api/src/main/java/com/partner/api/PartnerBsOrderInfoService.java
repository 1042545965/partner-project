package com.partner.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.partner.entity.PartnerBsOrderInfo;

import java.util.List;

/**
 * <p>
 * 订单信息表 服务类
 * </p>
 *
 * @author conlon123
 * @since 2019-03-30
 */
public interface PartnerBsOrderInfoService {

    /**
     * 查询${tableComment}
     *
     * @param partnerBsOrderInfo
     * @return 结果
     */
    public List<PartnerBsOrderInfo> selectList(PartnerBsOrderInfo partnerBsOrderInfo);

    /**
     * 查询${tableComment}
     *
     * @param  id 信息
     * @return 结果
     */
    public PartnerBsOrderInfo selectPartnerBsOrderInfoById(Long id);

    /**
     * 查询${tableComment}
     *
     * @param partnerBsOrderInfo
     * @return 结果
     */
    public PartnerBsOrderInfo selectPartnerBsOrderInfoByOne(PartnerBsOrderInfo partnerBsOrderInfo);

    /**
     * 修改${tableComment}
     *
     * @param partnerBsOrderInfo
     * @return 结果
     */
    public int updatePartnerBsOrderInfo(PartnerBsOrderInfo partnerBsOrderInfo);

    /**
     * 新增${tableComment}
     *
     * @param partnerBsOrderInfo
     * @return 结果
     */
    public int insertPartnerBsOrderInfo(PartnerBsOrderInfo partnerBsOrderInfo);

    /**
     * 公共查询条件
     *
     * @param partnerBsOrderInfo
     * @return
     */
    public EntityWrapper<PartnerBsOrderInfo> getEntityWrapper(PartnerBsOrderInfo partnerBsOrderInfo);

}
