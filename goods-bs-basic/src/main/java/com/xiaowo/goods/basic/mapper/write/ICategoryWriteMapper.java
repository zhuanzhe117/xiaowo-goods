package com.xiaowo.goods.basic.mapper.write;

import com.xiaowo.goods.basicapi.category.pojo.CategoryPojo;
import org.apache.ibatis.annotations.Param;

/* =======================================================
 * 小窝
 * 日 期：9/27/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：分类管理，写接口
 * ========================================================
 */
public interface ICategoryWriteMapper extends BaseWriteMapper{

    /**
     *新增分类
     * @param categoryPojo
     * @throws Exception
     */
    void insertCategory(CategoryPojo categoryPojo) throws Exception;

    /**
     * 删除分类
     * @param categoryId
     * @throws Exception
     */
    void deleteCategory(long categoryId) throws Exception;

    /**
     * 更新分类
     * @param categoryPojo
     * @throws Exception
     */
    void updateCategory(CategoryPojo categoryPojo) throws Exception;

    /**
     * 更新strLevel字段
     * @param categoryPojo
     * @throws Exception
     */
    void updateStrLevel(CategoryPojo categoryPojo) throws Exception;

    /**
     * 更新京东商品价格上调比例
     * @param upScale
     * @param id
     * @throws Exception
     */
    void updateUpScale(@Param("upScale") double upScale, @Param("id")long id)throws Exception;
}
