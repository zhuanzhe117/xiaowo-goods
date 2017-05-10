package com.xiaowo.goods.basic.mapper.write;

import com.xiaowo.goods.basicapi.prop.pojo.PropPojo;

/* =======================================================
 * 小窝
 * 日 期：10/10/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：TODO
 * ========================================================
 */
public interface IPropWriteMapper extends BaseWriteMapper {
    /**
     * 新增属性参数信息
     *
     * @return
     * @throws Exception
     */
    void insertProp(PropPojo propPojo) throws Exception;

    /**
     * 新增属性参数值
     *
     * @param propValuePojo
     * @throws Exception
     */
//    void insertPropValue(PropValuePojo propValuePojo) throws Exception;

    /**
     * 更新属性参数值
     *
     * @param propValuePojo
     * @throws Exception
     */
//    void updatePropValue(PropValuePojo propValuePojo) throws Exception;

    /**
     * 新增分类-属性关系
     *
     * @param categoryId
     * @param propId
     */
    void insertCategoryProp(long categoryId, long propId) throws Exception;

    /**
     * 删除属性参数
     *
     * @param propId
     * @throws Exception
     */
    void deletePropById(long propId) throws Exception;

    /**
     * 根据属性参数ID删除分类、属性参数的关联关系
     *
     * @param propId
     * @throws Exception
     */
    void deleteCategoryPropByPropId(long propId) throws Exception;

    /**
     * 根据分类ID删除分类、属性参数的关联关系
     *
     * @param categoryId
     * @throws Exception
     */
    void deleteCategoryPropByCategoryId(long categoryId) throws Exception;

    /**
     * 根据属性ID参数属性值
     *
     * @param propId
     * @throws Exception
     */
    void deletePropValue(long propId) throws Exception;

    /**
     * 根据属性值ID删除属性值
     *
     * @param id
     */
    void deletePropValueById(long id);

    /**
     * 更新属性参数
     *
     * @param propPojo
     * @throws Exception
     */
    void updateProp(PropPojo propPojo) throws Exception;

    /**
     * 修改状态
     * @param status
     * @param propId
     * @throws Exception
     */
    void updateStatus(int status, long propId) throws Exception;
}
