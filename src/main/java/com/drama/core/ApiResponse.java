package com.drama.core;

import java.util.HashMap;

public class ApiResponse extends HashMap<String, Object> {

    /**
     * 默认错误码
     */
    public static final String CODE_FAIL_DEFAULT = "0";
    public static final String CODE_SUCCESS = "1";
    public static final String CODE_UNKNOWN = "500";

    private ApiResponse(String code, Object data, String message) {
        this.put("code", code);
        this.put("success", CODE_SUCCESS.equals(code));
        this.put("message", message);
        this.put("data", data);
    }

    @Override
    public Object put(String key, Object value) {
        return super.put(key, value == null ? "" : value);
    }

    public String getMessage() {
        return this.get("message") == null ? "" : (String) this.get("message");
    }

    public Object getData() {
        return this.get("data") == null ? "" : this.get("data");
    }

    public boolean isSuccess() {
        return CODE_SUCCESS.equals(this.get("code"));
    }

    public String getCode() {
        return (String) this.get("code");
    }

    public static final ApiResponse success() {
        return new ApiResponse(CODE_SUCCESS, null, null);
    }

    public static final ApiResponse success(Object data) {
        return new ApiResponse(CODE_SUCCESS, data, null);
    }

    public static final ApiResponse success(Object data, String message) {
        return new ApiResponse(CODE_SUCCESS, data, message);
    }

    public static final ApiResponse failed(Exception e, String message) {
        return new ApiResponse(CODE_UNKNOWN, null, message);
    }

    public static final ApiResponse failed(String code, String message) {
        return new ApiResponse(code, null, message);
    }

    public static final ApiResponse failed(String code, Exception e) {
        return new ApiResponse(code, null, e.getMessage());
    }
}