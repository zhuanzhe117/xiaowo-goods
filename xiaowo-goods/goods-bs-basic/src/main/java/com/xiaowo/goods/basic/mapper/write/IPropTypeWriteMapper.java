package com.xiaowo.goods.basic.mapper.write;

import com.xiaowo.goods.basicapi.proptype.pojo.PropTypePojo;

import java.util.List;
import java.util.Map;

/* =======================================================
 * 小窝
 * 日 期：10/10/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：TODO
 * ========================================================
 */
public interface IPropTypeWriteMapper extends BaseWriteMapper {

    int deleteByPrimaryKey(Long id);

    int insertPropType(PropTypePojo record);


    /**
     * 新增 分类和属性分类 中间表数据
     * @param list
     * @return
     */
    int insertPropTypeAndCategory(List<Map<String,Object>> list);

    int updateByPrimaryKeySelective(PropTypePojo record);
}
