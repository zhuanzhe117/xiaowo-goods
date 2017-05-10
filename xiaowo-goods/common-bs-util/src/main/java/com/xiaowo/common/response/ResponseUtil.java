package com.xiaowo.common.response;

import com.xiaowo.common.exception.ErrorCode;
import com.xiaowo.common.exception.ErrorMsg;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.core.Response;

/* =======================================================
 * 小窝
 * 日 期：9/30/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：请求响应封装类
 * ========================================================
 */
public class ResponseUtil {
    private ResponseUtil() {
    }

    public static Response getResponse(int status, Object obj) {
        return Response.status(status).entity(obj).type("application/json").build();
    }

    public static Response getResponse(ResponseEntity<?> entity) {
        return Response.status(entity.getStatusCode().value()).entity(entity.getBody()).type("application/json").build();
    }

    public static Response getOkResponse(Object obj) {
        return Response.ok(obj).type("application/json").build();
    }

    public static Response getBizErrorResponse(int code, String msg) {
        return makeResponse(ErrorCode.BIZ_ERROR, new ErrorMsg(code, msg));
    }

    public static Response getBizErrorResponse(int code, String msg, String detail) {
        return makeResponse(ErrorCode.BIZ_ERROR, new ErrorMsg(code, msg, detail));
    }

    public static Response getBizErrorResponse(ErrorCode errorCode) {
        return makeResponse(ErrorCode.BIZ_ERROR, new ErrorMsg(errorCode.value(), errorCode.msg()));
    }

    public static Response getBizErrorResponse(ErrorMsg errorMsg) {
        return makeResponse(ErrorCode.BIZ_ERROR, errorMsg);
    }

    public static Response getBizErrorResponse(ErrorCode errorCode, String detail) {
        return makeResponse(ErrorCode.BIZ_ERROR, new ErrorMsg(errorCode.value(), errorCode.msg(), detail));
    }

    public static Response getSysErrorResponse(int code, String msg) {
        return makeResponse(ErrorCode.SYS_ERROR, new ErrorMsg(code, msg));
    }

    public static Response getSysErrorResponse(ErrorCode errorCode) {
        return makeResponse(ErrorCode.SYS_ERROR, new ErrorMsg(errorCode.value(), errorCode.msg()));
    }

    public static Response getSysErrorResponse(ErrorCode errorCode, String detail) {
        return makeResponse(ErrorCode.SYS_ERROR, new ErrorMsg(errorCode.value(), errorCode.msg(), detail));
    }

    public static Response getSysErrorResponse(int code, String msg, String detail) {
        return makeResponse(ErrorCode.SYS_ERROR, new ErrorMsg(code, msg, detail));
    }

    public static Response getSysErrorResponse(ErrorMsg errorMsg) {
        return makeResponse(ErrorCode.SYS_ERROR, errorMsg);
    }

    private static Response makeResponse(ErrorCode errorCode, Object entity) {
        return Response.status(errorCode.value()).entity(entity).type("application/json").build();
    }
}
