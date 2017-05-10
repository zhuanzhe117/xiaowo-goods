package com.xiaowo.goods.basic.mapper.read;

import java.util.List;

/* =======================================================
 * 小窝
 * 日 期：10/10/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：属性管理，读接口
 * ========================================================
 */
public interface IPropReadMapper extends BaseReadMapper {
    /**
     * 查询属性参数列表
     *
     * @param propListParam
     * @return
     * @throws Exception
     */
//    List<PropListJson> getPropList(PropListParam propListParam) throws Exception;

    /**
     * 查询属性参数总数
     *
     * @param propListParam
     * @return
     * @throws Exception
     */
//    long getPropListCount(PropListParam propListParam) throws Exception;

    /**
     * 查询属性参数详情
     *
     * @param propId
     * @return
     */
//    PropDetailJson getPropDetailById(long propId) throws Exception;

    /**
     * 获取属性参数的值
     *
     * @param propId
     * @return
     * @throws Exception
     */
//    List<PropValueDetailJson> getPropValuesByPropId(long propId) throws Exception;

    /**
     * 获取属性参数的值并根据sort的值进行排序
     *
     * @param propId
     * @return
     * @throws Exception
     */
//    List<PropValueDetailJson> getPropValuesByPropIdAndSort(long propId) throws Exception;

    /**
     * 根据属性参数id查询关联的分类的数量
     *
     * @param propId
     * @return
     */
    List<Long> getCategoryPropCountByPropId(long propId);

    /**
     * 根据分类ID查询此分类下的属性
     *
     * @param categoryId
     * @return
     */
//    List<PropAndValueJson> getPropsByCategoryId(long categoryId);
}
