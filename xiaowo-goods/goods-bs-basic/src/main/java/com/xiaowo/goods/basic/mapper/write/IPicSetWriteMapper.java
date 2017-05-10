package com.xiaowo.goods.basic.mapper.write;

import com.xiaowo.goods.basicapi.pictureset.pojo.PicSetPojo;

/* =======================================================
 * 小窝
 * 日 期：10/10/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：TODO
 * ========================================================
 */
public interface IPicSetWriteMapper extends BaseWriteMapper {
    /**
     * 新增图片集
     * @return
     * @throws Exception
     */
    void insertPicSet(PicSetPojo picSetPojo) throws Exception;

    /**
     * 新增分类-图片集关联关系
     *
     */
    void insertCategoryPicSet(long categoryId, long picSetId) throws Exception;

    /**
     * 更新图片集
     * @throws Exception
     */
    void updatePicSet(PicSetPojo picSetPojo) throws Exception;

    /**
     * 根据图片集id删除分类-图片集关联信息
     * @param picSetId
     * @throws Exception
     */
    void deleteCategoryPicSet(long picSetId) throws Exception;
}
