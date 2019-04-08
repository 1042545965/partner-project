package com.partner.api;

import com.partner.entity.PartnerBsMessage;

import java.util.List;

/**
 * <p>
 * 即时通讯消息记录表 服务类
 * </p>
 *
 * @author conlon123
 * @since 2019-04-01
 */
public interface PartnerBsMessageService {

    /**
     * 查询${tableComment}
     *
     * @param partnerBsMessage 信息
     * @return 结果
     */
    public List<PartnerBsMessage> selectList(PartnerBsMessage partnerBsMessage);

    /**
     * 查询${tableComment}
     *
     * @param id 信息
     * @return 结果
     */
    public PartnerBsMessage selectPartnerBsMessageById(Long id);

    /**
     * 查询${tableComment}
     *
     * @param partnerBsMessage 信息
     * @return 结果
     */
    public PartnerBsMessage selectPartnerBsMessageByOne(PartnerBsMessage partnerBsMessage);

    /**
     * 修改${tableComment}
     *
     * @param partnerBsMessage 信息
     * @return 结果
     */
    public int updatePartnerBsMessage(PartnerBsMessage partnerBsMessage);

    /**
     * 新增${tableComment}
     *
     * @param partnerBsMessage 信息
     * @return 结果
     */
    public int insertPartnerBsMessage(PartnerBsMessage partnerBsMessage);

    /**
     * 异步保存
     * @param partnerBsMessage
     */
    void insertPartnerBsMessageAsyn(PartnerBsMessage partnerBsMessage);
}
