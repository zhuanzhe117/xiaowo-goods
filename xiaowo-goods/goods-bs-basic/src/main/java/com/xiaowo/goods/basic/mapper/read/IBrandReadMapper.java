package com.xiaowo.goods.basic.mapper.read;

import com.xiaowo.goods.basicapi.brand.pojo.BrandPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/* =======================================================
 * 小窝
 * 日 期：10/10/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：品牌管理，读接口
 * ========================================================
 */
public interface IBrandReadMapper extends BaseReadMapper{
    /**
     * 根据品牌ID查询品牌
     * @param brandId
     * @return
     * @throws Exception
     */
    BrandPojo getBrandById(long brandId) throws Exception;

    /**
     * 根据品牌ID查询相关联的分类ID
     * @param brandId
     * @return
     * @throws Exception
     */
    List<Long> getCategoryIdsByBrandId(long brandId) throws Exception;

    /**
     * 分页查询品牌信息
     * @param brandListParam
     * @return
     * @throws Exception
     */
//    List<BrandPojo> getBrandList(BrandListParam brandListParam) throws Exception;

    /**
     * 查询品牌的总条数
     * @param brandListParam
     * @return
     * @throws Exception
     */
//    long getBrandListCount(BrandListParam brandListParam) throws Exception;

    /**
     * 查询指定分类下的所有后代分类ID
     * @param categoryId
     * @return
     * @throws Exception
     */
    List<Long> getClildCategoryIdsByCategoryId(long categoryId) throws Exception;

    /**
     * 根据分类id查询品牌
     * @param categoryId
     * @return
     * @throws Exception
     */
    List<BrandPojo> getBrandsByCategoryId(long categoryId) throws Exception;

    /**
     * 根据品牌名称模糊查询品牌
     * @param brandName
     * @return
     * @throws Exception
     */
    List<BrandPojo> getBrandsByName(@Param("brandName") String brandName) throws Exception;
}
