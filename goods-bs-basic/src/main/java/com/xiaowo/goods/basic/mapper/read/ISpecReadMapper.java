package com.xiaowo.goods.basic.mapper.read;

import com.xiaowo.goods.basicapi.spec.pojo.SpecPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/* =======================================================
 * 小窝
 * 日 期：10/10/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：规格管理，读接口
 * ========================================================
 */
public interface ISpecReadMapper extends BaseReadMapper {
    /**
     * 根据param 条件 查询 展示类目信息
     * @param param
     * @return
     */
//    List<SpecPojo> selectSpec(SpecListParam param);

    /**
     * 返回模糊搜索查询总数
     * @return
     */
//    int selectCount(SpecListParam param);


    SpecPojo selectSpecById(Long id);

    /**
     * 根据规格id查询 分类与规格关联关系 总条数
     * @param
     * @return
     */
    int selectCategoryCountBySpecId(@Param("id") long id);

    /**
     * 根据 showClassId 查询对应的 分类Id
     * @param id
     * @return
     */
    List<Long> selectCategoryIdBySpecId(@Param("id") long id);

    /**
     * 根据分类查询所有规格
     * @param categoryId
     * @return
     * @throws Exception
     */
    List<SpecPojo> getSpecsByCategoryId(long categoryId) throws Exception;

    /**
     * 根据规格名称查询规格
     * @return
     * @throws Exception
     */
    List<SpecPojo> getSpecsBySpecName(String specName) throws Exception;

    int countSKUBySpecId(@Param("id")Long id);

    int countGoodsBySpecId(@Param("id")Long id);

    /**
     * 根据ID查找值
     * @param valueId
     * @return
     */
//    SpecAndValueNameJson getNamesByValueId(long valueId);
}
