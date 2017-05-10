package com.xiaowo.goods.basic.mapper.read;

import com.xiaowo.goods.basicapi.category.json.CategoryJson;
import com.xiaowo.goods.basicapi.category.param.CategoryListParam;
import com.xiaowo.goods.basicapi.category.pojo.CategoryPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/* =======================================================
 * 小窝
 * 日 期：9/27/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：分类管理，读接口
 * ========================================================
 */
public interface ICategoryReadMapper extends BaseReadMapper {
    /**
     * 根据分类id查询分类
     *
     * @param id
     * @return
     * @throws Exception
     */
    CategoryPojo getCategoryById(long id) throws Exception;

    /**
     * 根据业态id查询一级分类列表
     *
     * @param categoryListParam
     * @return
     * @throws Exception
     */
    List<CategoryJson> getCategoryList(CategoryListParam categoryListParam) throws Exception;

    /**
     * 根据分类名称模糊搜索分类列表
     *
     * @param param
     * @return
     * @throws Exception
     */
    List<CategoryJson> getCategoryListByName(CategoryListParam param) throws Exception;

    /**
     * 根据分类名称模糊搜索分类列表 总条数
     *
     * @param param
     * @return
     * @throws Exception
     */
    long getCategoryListByNameCount(CategoryListParam param) throws Exception;

    /**
     * 根据业态id查询一级类目,查询全部一级类目 列表 总条数
     *
     * @param categoryListParam
     * @return
     * @throws Exception
     */
    long getCategoryListCount(CategoryListParam categoryListParam) throws Exception;

    /**
     * 根据父id查询分类信息
     *
     * @param pid
     * @return
     * @throws Exception
     */
    List<CategoryJson> getCategoryByPid(@Param("pid") long pid) throws Exception;

    /**
     * 根据业态id查询对应分类数量
     *
     * @param bizId
     * @return
     */
    long getCategoryCount(@Param("bizId") long bizId) throws Exception;

    /**
     * 查询商品和分类的关联条数
     * @param categoryId
     * @return
     * @throws Exception
     */
    long getGoodsAndCategoryCount(long categoryId)throws Exception;

    /**
     * 查询分类的所有还节点
     * @param strLevel
     * @return
     * @throws Exception
     */
    List<CategoryJson> getCategoryAndAllChildByStrLevel(@Param("strLevel")String strLevel);

    /**
     * 根据业态id查询下面的所有分类
     * @param bizId
     * @return
     */
    List<CategoryPojo> getAllCategoryByBizId(long bizId) throws Exception;
}
