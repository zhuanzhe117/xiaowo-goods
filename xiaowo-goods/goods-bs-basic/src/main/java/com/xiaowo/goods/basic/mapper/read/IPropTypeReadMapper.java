package com.xiaowo.goods.basic.mapper.read;

import com.xiaowo.goods.basicapi.proptype.pojo.PropTypePojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/* =======================================================
 * 小窝
 * 日 期：10/10/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：属性类型管理，读接口
 * ========================================================
 */
public interface IPropTypeReadMapper extends BaseReadMapper {
    /**
     * 根据param 条件 查询 展示类目信息
     *
     * @param param
     * @return
     */
//    List<PropTypePojo> selectPropType(PropTypeListParam param);

    /**
     * 返回查询总数
     * @return
     */
//    int selectCount(PropTypeListParam param);

    PropTypePojo selectPropTypeById(@Param("id") Long id);


    /**
     * 判断属性类型与属性参数是否关联
     * @param id
     * @return
     */
    int propTypeAndPropCount(@Param("id") Long id);
}
