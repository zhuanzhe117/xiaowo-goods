package com.xiaowo.goods.basic.mapper.write;

import com.xiaowo.goods.basicapi.biztype.pojo.BizTypePojo;
import org.apache.ibatis.annotations.Param;

/* =======================================================
 * 小窝
 * 日 期：10/9/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：业态管理，写接口
 * ========================================================
 */
public interface IBizTypeWriteMapper extends BaseWriteMapper {

    /**
     * 新增业态
     *
     * @param bizTypePojo
     * @return
     */
    int insertBizType(BizTypePojo bizTypePojo);

    /**
     * 更新业态
     *
     * @param bizTypePojo
     * @return
     */
    int updateBizType(BizTypePojo bizTypePojo);

    /**
     * 修改业态状态
     *
     * @param id
     * @return
     */
    int updateBizTypeState(@Param("id") long id);
}
