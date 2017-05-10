package com.xiaowo.goods.basic.mapper.read;

import com.xiaowo.goods.basicapi.biztype.pojo.BizTypePojo;
import org.apache.ibatis.annotations.Param;

/* =======================================================
 * 小窝
 * 日 期：10/9/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：业态管理，读接口
 * ========================================================
 */
public interface IBizTypeReadMapper extends BaseReadMapper{
    /**
     * 根据业态id查询业态信息
     *
     * @param id
     * @return
     */
    BizTypePojo getBizTypeById(@Param("id") long id);

    /**
     * 根据分类id查询业态信息
     * @param categoryId
     * @return
     */
    BizTypePojo getBizTypeByCategoryId(@Param("categoryId") long categoryId);
}
