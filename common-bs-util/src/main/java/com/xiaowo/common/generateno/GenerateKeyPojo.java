package com.xiaowo.common.generateno;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 谷海燕 on 2017/3/20.
 */
public class GenerateKeyPojo implements Serializable {
    /**
     * 业务代码
     */
    private String tableKeyName;

    /**
     * 前缀
     */
    private String prefix;

    /**
     * 业务主键 长度  默认 -1
     */
    private int length = -1;

    /**
     * 每次递增数
     */
    private int increment;

    /**
     * 创建时间
     */
    private String createtime;

    public String getTableKeyName() {
        return tableKeyName;
    }

    public void setTableKeyName(String tableKeyName) {
        this.tableKeyName = tableKeyName;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getIncrement() {
        return increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
