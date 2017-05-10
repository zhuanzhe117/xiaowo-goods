package com.xiaowo.goods.basic.service;

import com.xiaowo.goods.basic.mapper.read.ICategoryReadMapper;
import com.xiaowo.goods.basic.mapper.write.IBrandWriteMapper;
import com.xiaowo.goods.basic.mapper.write.ICategoryWriteMapper;
import com.xiaowo.goods.basic.mapper.write.IPropWriteMapper;
import com.xiaowo.goods.basic.mapper.write.ISpecWriteMapper;
import com.xiaowo.goods.basicapi.category.json.CategoryJson;
import com.xiaowo.goods.basicapi.category.param.CategoryInsertParam;
import com.xiaowo.goods.basicapi.category.param.CategoryListParam;
import com.xiaowo.goods.basicapi.category.pojo.CategoryPojo;
import com.xiaowo.goods.basicapi.util.Constant;
import com.xiaowo.goods.basicapi.util.PageUtil;
import com.xiaowo.goods.basicapi.util.Pagination;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/* =======================================================
 * 小窝
 * 日 期：9/30/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：分类业务逻辑
 * ========================================================
 */
@Service
public class CategoryService {

    @Autowired
    private ICategoryWriteMapper categoryWriteMapper;

    @Autowired
    private ICategoryReadMapper categoryReadMapper;

    @Autowired
    private IBrandWriteMapper brandWriteMapper;

    @Autowired
    private IPropWriteMapper propWriteMapper;

    @Autowired
    private ISpecWriteMapper specWriteMapper;
    /**
     * 新增分类
     *
     * @param categoryInsertParam
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertCategory(CategoryInsertParam categoryInsertParam) throws Exception {
        CategoryPojo categoryPojo = new CategoryPojo();
        BeanUtils.copyProperties(categoryInsertParam, categoryPojo);
        categoryPojo.setState(1);
        categoryPojo.setCreateTime(new Date());
        categoryPojo.setUpdateTime(new Date());

        //一级分类：该分类的一级分类id=0
        if (categoryInsertParam.getPid1() == 0) {
            categoryPojo.setLevel(1);
            categoryPojo.setStrLevel("");
            categoryPojo.setPid(0);
        }
        //二级分类：该分类的二级分类id=0
        else if (categoryInsertParam.getPid2() == 0) {
            categoryPojo.setLevel(2);
            categoryPojo.setStrLevel(categoryInsertParam.getPid1() + "_");
            categoryPojo.setPid(categoryInsertParam.getPid1());
        }
        //三级分类：该分类的三级分类id=0
        else if (categoryInsertParam.getPid3() == 0) {
            categoryPojo.setLevel(3);
            categoryPojo.setStrLevel(categoryInsertParam.getPid1() + "_" + categoryInsertParam.getPid2() + "_");
            categoryPojo.setPid(categoryInsertParam.getPid2());
        }
        //四级分类：该分类的一级/二级/三级分类id都不=0
        else {
            categoryPojo.setLevel(4);
            categoryPojo.setStrLevel(categoryInsertParam.getPid1() + "_" + categoryInsertParam.getPid2() + "_" + categoryInsertParam.getPid3() + "_");
            categoryPojo.setPid(categoryInsertParam.getPid3());
        }
        //插入数据库
        this.categoryWriteMapper.insertCategory(categoryPojo);
        //更新strLevel字段
        String temp = categoryPojo.getStrLevel() + categoryPojo.getId() + "_";
        categoryPojo.setStrLevel(temp);
        this.categoryWriteMapper.updateStrLevel(categoryPojo);
    }

    /**
     * 删除分类
     *
     * @param categoryId
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public String deleteCategory(long categoryId) throws Exception {
        String message = "ok";
        //查询 pid=categoryId的分类
        List<CategoryJson> categoryJsonList = this.categoryReadMapper.getCategoryByPid(categoryId);
        // 分类下有子分类
        if (categoryJsonList != null && categoryJsonList.size() > 0) {
            message = "该分类有子分类，不能删除";
            return message;
        }
//todo 解开以下注释
        //分类下有商品的
//        Boolean bool1 = this.goodsSkuFeignClient.IsGoodsSkuExist("category.categoryId", categoryId, Constant.MongoTable.GOODS_SKU.toString()).getBody();
        // 分类下有商品组合的
//        Boolean bool2 = this.goodsSkuFeignClient.IsGoodsSkuExist("category.categoryId", categoryId, Constant.MongoTable.GOODS_GROUP.toString()).getBody();
        boolean bool1=false;
        boolean bool2=false;
        if (bool1 || bool2) {
            message = "该分类已经有关联商品或商品组合信息，不能删除";
            return message;
        }

        //解除与品牌的关联关系
        this.brandWriteMapper.deleteCategoryBrandByCategoryId(categoryId);
        //解除与属性参数的关联关系
        this.propWriteMapper.deleteCategoryPropByCategoryId(categoryId);
        //解除与展示分类的关联关系
        //this.showClassifyWriteMapper.delClassAndCategoryBycategoryId(categoryId);
        //解除与搜索标签的关联关系
        //this.searchTagWriteMapper.deleteCategoryAndSearchTagByCategoryId(categoryId);
        //解除与规格的关联关系
        this.specWriteMapper.deleteSpecAndCategoryByCategoryId(categoryId);
        //假删除分类
        this.categoryWriteMapper.deleteCategory(categoryId);

        return message;
    }

    /**
     * 更新分类
     *
     * @param param
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateCategory(CategoryInsertParam param) throws Exception {
        CategoryPojo categoryPojo = new CategoryPojo();
        BeanUtils.copyProperties(param, categoryPojo);
        categoryPojo.setUpdateTime(new Date());
        //目前需求是只能改分类名称
        this.categoryWriteMapper.updateCategory(categoryPojo);
    }

    /**
     * 根据业态id或分类名称查询一级分类 列表
     *
     * @param categoryListParam
     * @return
     * @throws Exception
     */
    public Pagination getCategoryList(CategoryListParam categoryListParam) throws Exception {
        Pagination page = new Pagination();
        page.setPageNo(categoryListParam.getPageNo());
        page.setPageSize(categoryListParam.getPageSize());
        categoryListParam.setCurrentCount((categoryListParam.getPageNo() - 1) * categoryListParam.getPageSize());
        List<CategoryJson> categoryJsonList = this.categoryReadMapper.getCategoryList(categoryListParam);

        //遍历实体集合，为实体设置isParent属性
        for (CategoryJson c : categoryJsonList) {
            //判断该实体是否还有下级分类
            List<CategoryJson> childList = this.categoryReadMapper.getCategoryByPid(c.getId());
            if (childList != null && childList.size() > 0) {
                c.setIsParent(true);
            } else {
                c.setIsParent(false);
                c.setNoCheck(true);//nocheck属性用于新增商品时，展示全部分类的树，只有叶子类目可以被选中

            }
        }
        page.setData(categoryJsonList);

        long totalCount = this.categoryReadMapper.getCategoryListCount(categoryListParam);
        page.setTotalCount(totalCount);
        page.setTotalPage(PageUtil.calTotalPage(totalCount, categoryListParam.getPageSize()));
        return page;
    }

    /**
     * 根据分类名称模糊搜索分类列表
     *
     * @param param
     * @return
     * @throws Exception
     */
    public Pagination getCategoryListByName(CategoryListParam param) throws Exception {
        Pagination page = new Pagination();
        page.setPageNo(param.getPageNo());
        page.setPageSize(param.getPageSize());
        param.setCurrentCount((param.getPageNo() - 1) * param.getPageSize());

        List<CategoryJson> categoryJsons = this.categoryReadMapper.getCategoryListByName(param);
        page.setData(categoryJsons);

        //根据分类名称模糊搜索分类列表 总条数
        long totalCount = this.categoryReadMapper.getCategoryListByNameCount(param);
        page.setTotalCount(totalCount);
        page.setTotalPage(PageUtil.calTotalPage(totalCount, param.getPageSize()));
        return page;
    }

    /**
     * 根据分类id查询分类
     *
     * @param categoryId
     * @return
     * @throws Exception
     */
    public CategoryPojo getCategoryById(long categoryId) throws Exception {
        CategoryPojo categoryPojo = this.categoryReadMapper.getCategoryById(categoryId);
        return categoryPojo;
    }


    /**
     * 更新京东商品价格上调比例
     *
     * @param upScale
     * @param id
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateUpScale(double upScale, long id) throws Exception {
        this.categoryWriteMapper.updateUpScale(upScale, id);
    }

    /**
     * 根据pid查询分类（分别查询一级/二级/三级分类）
     *
     * @param pid
     * @return
     * @throws Exception
     */
    public List<CategoryJson> getCategoryByPid(long pid) throws Exception {

        List<CategoryJson> categoryJsonList = this.categoryReadMapper.getCategoryByPid(pid);
        //遍历实体集合，为实体设置isParent属性
        for (CategoryJson categoryJson : categoryJsonList) {
            //判断该实体是否还有下级分类
            List<CategoryJson> childList = this.categoryReadMapper.getCategoryByPid(categoryJson.getId());
            if (childList != null && childList.size() > 0) {
                categoryJson.setIsParent(true);
            } else {
                categoryJson.setIsParent(false);
            }
        }
        return categoryJsonList;
    }

    /**
     * 查询该分类 以及所有子分类
     *
     * @param id
     * @return
     * @throws Exception
     */
    public List<CategoryJson> getCategoryAndChildsById(long id) throws Exception {
        CategoryPojo pojo = categoryReadMapper.getCategoryById(id);
        return this.categoryReadMapper.getCategoryAndAllChildByStrLevel(pojo.getStrLevel() + "%");
    }

    /**
     * 根据业态查询 一级分类
     *
     * @param id
     * @return
     * @throws Exception
     */
    public List<CategoryJson> getCategoryByBizId(long id) throws Exception {
        CategoryListParam param = new CategoryListParam();
        param.setBizId(id);
        param.setPageNo(1);
        param.setPageSize(9999);
        Pagination page = new Pagination();

        param.setCurrentCount((param.getPageNo() - 1) * param.getPageSize());

        List<CategoryJson> categoryJsonList = this.categoryReadMapper.getCategoryList(param);

        return categoryJsonList;
    }

    /**
     * 根据业态查询所有分类接口
     *
     * @param bizId
     * @return
     * @throws Exception
     */
    public List<CategoryPojo> getAllCategoryByBizId(long bizId) throws Exception {
        return this.categoryReadMapper.getAllCategoryByBizId(bizId);
    }
}
