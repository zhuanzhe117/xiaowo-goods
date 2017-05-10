package com.xiaowo.goods.basic.mapper.read;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/* =======================================================
 * 小窝
 * 日 期：10/10/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：图文管理，读接口
 * ========================================================
 */
public interface IPicWordReadMapper extends BaseReadMapper {
    /**
     * 查询图文列表
     *
     * @return
     * @throws Exception
     */
//    List<PicWordListJson> getPicWordList(PicWordListParam picWordListParam) throws Exception;

    /**
     * 查询图文总数
     *
     * @return
     * @throws Exception
     */
//    long getPicWordListCount(PicWordListParam picWordListParam) throws Exception;

    /**
     * 获取图文详情
     * @return
     * @throws Exception
     */
//    PicWordDetailJson getPicWordById(long picWordId) throws Exception;

    /**
     * 根据图文id获取选中的分类ID
     * @return
     * @throws Exception
     */
    List<Long> getCategoryIdsByPicWordId(long picWordId) throws Exception;
    /**
     * 查询分类下的Id
     *
     * @return
     * @throws Exception
     */
//    List<PicWordListJson> getPicWordListByCategoryId(@Param("categoryId")long categoryId);
}
