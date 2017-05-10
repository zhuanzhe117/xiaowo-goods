package com.xiaowo.common.exception;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.concurrent.TimeoutException;

/* =======================================================
 * 小窝
 * 日 期：9/30/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：错误信息
 * ========================================================
 */
public class ErrorMsg implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(ErrorMsg.class);
    private static final long serialVersionUID = 417532393233574679L;

    private int code;
    private String message;
    private String detail = "";

    public ErrorMsg() {
    }

    public ErrorMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorMsg(int code, String message, String detail) {
        this.code = code;
        this.message = message;
        this.detail = detail;
    }

    public ErrorMsg(ErrorCode errorCode) {
        this.code = errorCode.value();
        this.message = errorCode.msg();
    }

    public ErrorMsg(ErrorCode errorCode, String detail) {
        this.code = errorCode.value();
        this.message = errorCode.msg();
        this.detail = detail;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public static ErrorMsg parse(Exception e) {
        String err = e.getCause().toString();

        try {
            if(e.getCause().getClass() == TimeoutException.class) {
                return new ErrorMsg(ErrorCode.SYS_ERROR_RPC_CONNECTION, "远程服务调用超时");
            } else if(err.split("content:").length < 2) {
                logger.debug("其他错误", e);
                return new ErrorMsg(ErrorCode.BIZ_ERROR.value(), e.getMessage());
            } else {
                return (ErrorMsg) JSON.parseObject(err.split("content:")[1], ErrorMsg.class);
            }
        } catch (Exception var3) {
            logger.error("从异常信息中解析ErrorMsg失败", var3);
            return new ErrorMsg(ErrorCode.SYS_ERROR, err);
        }
    }
}
