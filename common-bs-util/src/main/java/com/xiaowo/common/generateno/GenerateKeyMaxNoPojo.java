package com.xiaowo.common.generateno;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 谷海燕 on 2017/3/20.
 */
public class GenerateKeyMaxNoPojo implements Serializable {

    private String tableKeyName;//业务代码

    private int maxNoValue;//当前业务代码最大号

    private String primaryKeyValue;//生成主键

    private String createtime;//生成时间

    public String getTableKeyName() {
        return tableKeyName;
    }

    public void setTableKeyName(String tableKeyName) {
        this.tableKeyName = tableKeyName;
    }

    public int getMaxNoValue() {
        return maxNoValue;
    }

    public void setMaxNoValue(int maxNoValue) {
        this.maxNoValue = maxNoValue;
    }

    public String getPrimaryKeyValue() {
        return primaryKeyValue;
    }

    public void setPrimaryKeyValue(String primaryKeyValue) {
        this.primaryKeyValue = primaryKeyValue;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
