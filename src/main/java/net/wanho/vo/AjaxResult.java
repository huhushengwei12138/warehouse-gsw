package net.wanho.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjaxResult {
    private Boolean success;
    private Integer code;
    private String message;
    private Object data;

    public static AjaxResult success(){
        AjaxResult result = new AjaxResult();
        result.setSuccess(true);
        result.setCode(200);

        return result;
    }

    public static AjaxResult success(Object data){
        AjaxResult result = new AjaxResult();
        result.setSuccess(true);
        result.setCode(200);
        result.setData(data);

        return result;
    }
    public static AjaxResult success(String msg){
        AjaxResult result = new AjaxResult();
        result.setSuccess(true);
        result.setMessage(msg);
        result.setCode(200);


        return result;
    }

    public static AjaxResult success(String msg,Object data){
        AjaxResult result = new AjaxResult();
        result.setSuccess(true);
        result.setMessage(msg);
        result.setCode(200);
        result.setData(data);

        return result;
    }

    public static AjaxResult fail(){
        AjaxResult result = new AjaxResult();
        result.setSuccess(false);
        result.setCode(500);

        return result;
    }

    public static AjaxResult fail(String msg){
        AjaxResult result = new AjaxResult();
        result.setSuccess(false);
        result.setCode(500);
        result.setMessage(msg);
        return result;
    }

    public static AjaxResult fail(Object data){
        AjaxResult result = new AjaxResult();
        result.setSuccess(false);
        result.setCode(500);
        result.setData(data);
        return result;
    }



}
