package com.eliteams.quick4j.core.entity;

public class JSONResult extends Result {

    private static final long serialVersionUID = 7880907731807860636L;

    /**
     * 数据
     */
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JSONResult() {
        super();
    }

    /**
     * 成功返回数据和消息
     *
     * @param data
     * @param message
     */
    public JSONResult(Object data, String message) {
        this.data = data;
        super.setMessage(message);
        super.setSuccess(true);
    }

    /**
     * 成功返回数据
     *
     * @param data
     */
    public JSONResult(Object data) {
        this.data = data;
        super.setSuccess(true);
    }

    /**
     * 成功返回
     *
     * @return
     */
    public static JSONResult success() {
        JSONResult result = new JSONResult();
        result.setSuccess(true);
        return result;
    }

    /**
     * 成功带数据返回
     *
     * @param data
     * @return
     */
    public static JSONResult success(Object data) {
        JSONResult result = new JSONResult(data);
        result.setSuccess(true);
        return result;
    }

    /**
     * 成功带数据消息返回
     *
     * @param data
     * @param message
     * @return
     */
    public static JSONResult success(Object data, String message) {
        JSONResult result = new JSONResult(data, message);
        result.setSuccess(true);
        return result;
    }

    /**
     * 失败返回
     *
     * @return
     */
    public static JSONResult failure() {
        JSONResult result = new JSONResult();
        result.setSuccess(false);
        return result;
    }

    /**
     * 失败带消息返回
     *
     * @param message
     * @return
     */
    public static JSONResult failure(String message) {
        JSONResult result = new JSONResult(message);
        result.setSuccess(false);
        return result;
    }
}

//
///**
// * JSONResult : Response JSONResult for RESTful,封装返回JSON格式的数据
// *
// * @author StarZou
// * @since 2014年5月26日 上午10:51:46
// */
//
//public class JSONResult<T> extends Result {
//
//    private static final long serialVersionUID = 7880907731807860636L;
//
//    /**
//     * 数据
//     */
//    private T data;
//
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//
//    public JSONResult() {
//        super();
//    }
//
//    /**
//     * 自定义返回的结果
//     *
//     * @param data
//     * @param message
//     * @param success
//     */
//    public JSONResult(T data, String message, boolean success) {
//        this.data = data;
//        super.setMessage(message);
//        super.setSuccess(success);
//    }
//
//    /**
//     * 成功返回数据和消息
//     *
//     * @param data
//     * @param message
//     */
//    public JSONResult(T data, String message) {
//        this.data = data;
//        super.setMessage(message);
//        super.setSuccess(true);
//    }
//
//    /**
//     * 成功返回数据
//     *
//     * @param data
//     */
//    public JSONResult(T data) {
//        this.data = data;
//        super.setSuccess(true);
//    }
//}