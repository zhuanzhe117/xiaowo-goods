package com.xiaowo.goods.basicapi.util;

/* =======================================================
 * 小窝
 * 日 期：9/19/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：分页工具
 * ========================================================
 */
public class PageUtil {

    /**
     * 根据总条数和每页显示条数计算总页数
     * @param totalCount
     * @param pageSize
     * @return
     */
    public static int calTotalPage(long totalCount, int pageSize){
        if (pageSize <= 0 || totalCount==0){
            return 1;
        }
        int totalPage  = (int) ((totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1));
        if(0 == totalPage){
            return 1;
        }
        return totalPage;
    }
}
