package com.xiaowo.goods.basic.mapper.write;

import com.xiaowo.goods.basicapi.pictureword.pojo.PicWordPojo;

/* =======================================================
 * 小窝
 * 日 期：10/10/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：TODO
 * ========================================================
 */
public interface IPicWordWriteMapper extends BaseWriteMapper {
    /**
     * 新增图文
     * @return
     * @throws Exception
     */
    void insertPicWord(PicWordPojo picWordPojo) throws Exception;

    /**
     * 新增分类-图文关联关系
     *
     */
    void insertCategoryPicWord(long categoryId, long picWordId) throws Exception;

    /**
     * 更新图文
     * @throws Exception
     */
    void updatePicWord(PicWordPojo picWordPojo) throws Exception;

    /**
     * 根据图文id删除分类-图文关联信息
     * @throws Exception
     */
    void deleteCategoryPicWord(long picWordId) throws Exception;
}
