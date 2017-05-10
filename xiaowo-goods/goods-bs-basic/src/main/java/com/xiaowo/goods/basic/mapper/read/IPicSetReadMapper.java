package com.xiaowo.goods.basic.mapper.read;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/* =======================================================
 * 小窝
 * 日 期：10/10/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：图片集管理，读接口
 * ========================================================
 */
public interface IPicSetReadMapper extends BaseReadMapper {
    /**
     * 查询图片集列表
     *
     * @return
     * @throws Exception
     */
//    List<PicSetListJson> getPicSetList(PicSetListParam picSetListParam) throws Exception;

    /**
     * 查询图片集总数
     *
     * @return
     * @throws Exception
     */
//    long getPicSetListCount(PicSetListParam picSetListParam) throws Exception;

    /**
     * 获取图片集详情
     * @param picSetId
     * @return
     * @throws Exception
     */
//    PicSetDetailJson getPicSetById(long picSetId) throws Exception;

    /**
     * 根据图片集id获取选中的分类ID
     * @param picSetId
     * @return
     * @throws Exception
     */
    List<Long> getCategoryIdsByPicSetId(long picSetId) throws Exception;
    /**
     * 根据分类ID图片集
     * @param categoryId
     * @return
     * @throws Exception
     */
//    List<PicSetListJson> getPicSetListByCategoryId(@Param("categoryId")long categoryId);
}
