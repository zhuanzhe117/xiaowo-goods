package com.xiaowo.goods.basic.mapper.write;

import com.xiaowo.goods.basicapi.spec.pojo.SpecValuePojo;

/* =======================================================
 * 小窝
 * 日 期：10/10/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：TODO
 * ========================================================
 */
public interface ISpecValueWriteMapper extends BaseWriteMapper {
    /**
     * 根据规格id删除规格属性值
     * @param specId
     * @return
     */
    int deleteBySpecId(long specId);

    int deleteByPrimaryKey(long specId);

    int insertSelective(SpecValuePojo record);



    int updateByPrimaryKeySelective(SpecValuePojo record);
}
