package com.xiaowo.goods.basic.mapper.write;

import com.xiaowo.goods.basicapi.brand.pojo.BrandPojo;

/* =======================================================
 * 小窝
 * 日 期：10/10/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：品牌管理，写接口
 * ========================================================
 */
public interface IBrandWriteMapper extends BaseWriteMapper {
    /**
     * 新增品牌信息
     * @param brandPojo
     * @return
     * @throws Exception
     */
    void insertBrand(BrandPojo brandPojo) throws Exception;

    /**
     * 插入分类与品牌的关联关系
     * @param categoryId 分类ID
     * @param brandId 品牌ID
     * @throws Exception
     */
    void insertCategoryBrand(long categoryId, long brandId) throws Exception;

    /**
     * 删除品牌
     * @param brandId
     * @throws Exception
     */
    void deleteBrandById(long brandId) throws Exception;

    /**
     * 根据品牌ID删除分类、品牌关联关系
     * @param brandId
     * @throws Exception
     */
    void deleteCategoryBrandByBrandId(long brandId) throws Exception;

    /**
     * 根据分类ID删除分类、品牌关联关系
     * @param categoryId
     * @throws Exception
     */
    void deleteCategoryBrandByCategoryId(long categoryId) throws Exception;

    /**
     * 更新品牌信息
     * @throws Exception
     */
    void updateBrand(BrandPojo brandPojo) throws Exception;
}
