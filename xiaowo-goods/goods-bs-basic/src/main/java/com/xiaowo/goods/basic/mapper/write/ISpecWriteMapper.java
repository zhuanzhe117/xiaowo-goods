package com.xiaowo.goods.basic.mapper.write;

import com.xiaowo.goods.basicapi.spec.pojo.SpecPojo;

import java.util.List;
import java.util.Map;

/* =======================================================
 * 小窝
 * 日 期：10/10/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：TODO
 * ========================================================
 */
public interface ISpecWriteMapper extends BaseWriteMapper {
    int deleteByPrimaryKey(Long id);


    int insertSpec(SpecPojo record);

    int insertSpecAndCategory(List<Map<String,Object>> list);


    int updateSpecById(SpecPojo record);

    /**
     * 删除规格时，根据规格id删除规格与分类关联关系
     * @param id
     * @return
     */
    int delSpecAndCategoryById(Long id);

    /**
     * 删除分类时，根据分类id解除分类与规格的关联关系
     * @param categoryId
     * @throws Exception
     */
    void deleteSpecAndCategoryByCategoryId(long categoryId) throws Exception;

    /**
     * 修改状态
     * @param status
     * @param specId
     * @throws Exception
     */
    void updateStatus(int status, long specId) throws Exception;
}
