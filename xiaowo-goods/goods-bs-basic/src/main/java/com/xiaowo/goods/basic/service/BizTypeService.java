package com.xiaowo.goods.basic.service;

import com.xiaowo.goods.basic.mapper.read.IBizTypeReadMapper;
import com.xiaowo.goods.basic.mapper.read.ICategoryReadMapper;
import com.xiaowo.goods.basic.mapper.write.IBizTypeWriteMapper;
import com.xiaowo.goods.basicapi.biztype.pojo.BizTypePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/* =======================================================
 * 小窝
 * 日 期：10/9/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：业态业务逻辑
 * ========================================================
 */
@Service
public class BizTypeService {
    @Autowired
    private IBizTypeReadMapper bizTypeReadMapper;

    @Autowired
    private IBizTypeWriteMapper bizTypeWriteMapper;

    @Autowired
    private ICategoryReadMapper categoryReadMapper;

    /**
     * 新增业态
     *
     * @param bizName 业态名称
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertBizType(String bizName) throws Exception {
        BizTypePojo bizTypePojo = new BizTypePojo();
        bizTypePojo.setBizName(bizName);
        bizTypePojo.setState(1);
        Date nowDate = new Date();
        bizTypePojo.setUpdateTime(nowDate);
        bizTypePojo.setCreateTime(nowDate);
        this.bizTypeWriteMapper.insertBizType(bizTypePojo);

    }

    /**
     * 删除业态
     *
     * @param id
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public String deleteBizTypeById(long id) throws Exception {
        String message = "ok";
        long categoryListCount = this.categoryReadMapper.getCategoryCount(id);
        if (categoryListCount > 0) {
            message="该业态已经有关联的分类，不能删除";
            return message;
        }
        this.bizTypeWriteMapper.updateBizTypeState(id);
        return message;
    }

    /**
     * 更新业态
     *
     * @param bizName
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateBizType(String bizName) throws Exception {
        BizTypePojo bizTypePojo = new BizTypePojo();
        bizTypePojo.setBizName(bizName);
        bizTypePojo.setUpdateTime(new Date());
        this.bizTypeWriteMapper.updateBizType(bizTypePojo);
    }

    /**
     * 根据业态id查询业态信息
     *
     * @param id 业态id
     * @return
     */
    public BizTypePojo getBizTypeById(long id) {
        BizTypePojo bizTypePojo = this.bizTypeReadMapper.getBizTypeById(id);
        return bizTypePojo;
    }

    /**
     * 根据分类id查询业态信息
     *
     * @return
     */
    public BizTypePojo getBizTypeByCategoryId(long categoryId) {
        BizTypePojo bizTypePojo = this.bizTypeReadMapper.getBizTypeByCategoryId(categoryId);
        return bizTypePojo;
    }
}
