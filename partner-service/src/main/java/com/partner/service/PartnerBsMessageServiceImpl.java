package com.partner.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.partner.api.PartnerBsMessageService;
import com.partner.dao.PartnerBsMessageDao;
import com.partner.entity.PartnerBsMessage;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 即时通讯消息记录表 服务实现类
 * </p>
 *
 * @author conlon123
 * @since 2019-04-01
 */
@Service
public class PartnerBsMessageServiceImpl implements PartnerBsMessageService {


    @Resource
    private PartnerBsMessageDao partnerBsMessageDao;

    /**
     * 查询即时通讯消息记录表
     *
     * @param partnerBsMessage 信息
     * @return 结果
     */
    @Override
    public List<PartnerBsMessage> selectList(PartnerBsMessage partnerBsMessage) {
        EntityWrapper<PartnerBsMessage> entityWrapper = getEntityWrapper(partnerBsMessage);
        return partnerBsMessageDao.selectList(entityWrapper);
    }

    /**
     * 查询即时通讯消息记录表
     *
     * @param id 信息
     * @return 结果
     */
    @Override
    public PartnerBsMessage selectPartnerBsMessageById(Long id) {
        return partnerBsMessageDao.selectById(id);
    }

    /**
     * 查询即时通讯消息记录表
     *
     * @param partnerBsMessage 信息
     * @return 结果
     */
    @Override
    public PartnerBsMessage selectPartnerBsMessageByOne(PartnerBsMessage partnerBsMessage) {
        return partnerBsMessageDao.selectOne(partnerBsMessage);
    }

    /**
     * 修改即时通讯消息记录表
     *
     * @param partnerBsMessage 信息
     * @return 结果
     */
    @Override
    public int updatePartnerBsMessage(PartnerBsMessage partnerBsMessage) {
        return partnerBsMessageDao.updateById(partnerBsMessage);
    }

    /**
     * 新增即时通讯消息记录表
     *
     * @param partnerBsMessage 信息
     * @return 结果
     */
    @Override
    public int insertPartnerBsMessage(PartnerBsMessage partnerBsMessage) {
        return partnerBsMessageDao.insert(partnerBsMessage);
    }

    /**
     * 异步存储信息
     * @param partnerBsMessage
     */
    @Override
    @Async
    public void insertPartnerBsMessageAsyn(PartnerBsMessage partnerBsMessage) {
        this.insertPartnerBsMessage(partnerBsMessage);
    }

    /**
     * 公共查询条件
     *
     * @param partnerBsMessage
     * @return
     */
    private EntityWrapper<PartnerBsMessage> getEntityWrapper(PartnerBsMessage partnerBsMessage) {
        EntityWrapper<PartnerBsMessage> entityWrapper = new EntityWrapper<>();
        //条件拼接
        if (StringUtils.isNotNull(partnerBsMessage.getSendUserId())) {
            entityWrapper.eq("send_user_id" , partnerBsMessage.getSendUserId());
        }
        if (StringUtils.isNotNull(partnerBsMessage.getAccepterUserId())) {
            entityWrapper.eq("accepter_user_id" , partnerBsMessage.getAccepterUserId());
        }
        if (StringUtils.isNotBlank(partnerBsMessage.getNettyMessage())) {
            entityWrapper.eq("netty_message" , partnerBsMessage.getNettyMessage());
        }
        if (StringUtils.isNotNull(partnerBsMessage.getMessageRead())) {
            entityWrapper.eq("message_read" , partnerBsMessage.getMessageRead());
        }
        if (StringUtils.isNotNull(partnerBsMessage.getCreateTime())) {
            entityWrapper.eq("create_time" , partnerBsMessage.getCreateTime());
        }
        return entityWrapper;
    }
}
