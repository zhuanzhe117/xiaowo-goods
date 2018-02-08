package com.xiaowo.common.exception;

/* =======================================================
 * 小窝
 * 日 期：9/30/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：错误代码
 * ========================================================
 */
public enum ErrorCode {
    OK(0,"成功"),
    BIZ_ERROR(1,"业务错误"),
    SYS_ERROR(2,"系统错误"),
    SYS_ERROR_RPC_CONNECTION(3,"远程服务调用超时"),
    BIZ_ERROR_PARAMETER_NULL(4,"POST请求未包含任何数据");


    private final int value;
    private final String msg;

    private ErrorCode(int value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public int value() {
        return this.value;
    }

    public String msg() {
        return this.msg;
    }

    public static ErrorCode valueOf(int value) {
        ErrorCode[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ErrorCode instance = var1[var3];
            if(instance.value == value) {
                return instance;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + value + "]");
    }
}