package com.xiaowo.goods.basic.mapper.read;

import com.xiaowo.goods.basicapi.spec.pojo.SpecValuePojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/* =======================================================
 * 小窝
 * 日 期：10/10/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：规格值管理，读接口
 * ========================================================
 */
public interface ISpecValueReadMapper extends BaseReadMapper {

    SpecValuePojo selectByPrimaryKey(Long id);

    List<SpecValuePojo> selectSpecValueBySpecId(Long id);

    List<SpecValuePojo> selectSpecValueBySpecIdAndValue(Long id, String value);

//    SpecAndSpecValueJson selectSpecBySpecId(long specId);


    int countSKUBySpecValueId(@Param("id")Long id);

    int countGoodsBySpecValueId(@Param("id")Long id);
}
