package com.xiaowo.common.exception.handler;

/* =======================================================
 * 小窝
 * 日 期：10/2/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：异常处理父类
 * ========================================================
 */
public class BaseExceptionHandler {
    public BaseExceptionHandler() {
    }

    protected String getErrorStackTrace(Throwable ex) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ex).append("\r\n");
        StackTraceElement[] var3 = ex.getStackTrace();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            StackTraceElement element = var3[var5];
            stringBuilder.append("\tat ").append(element).append("\r\n");
        }

        return stringBuilder.toString();
    }
}
