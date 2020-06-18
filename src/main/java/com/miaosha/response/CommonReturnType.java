package com.miaosha.response;

public class CommonReturnType {
    //Status表明对应请求的返回处理结果 Success和fail
    private String status;
    //若Status=Success，则Data内返回前端所需要的json数据，
    //若Status=Fail，则Data内使用常用的错误码格式，
    private Object data;

    //定义一个通用的创建方法，
    public static CommonReturnType cteate(Object result) {
        return CommonReturnType.cteate(result, "success");
    }

    public static CommonReturnType cteate(Object result, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
