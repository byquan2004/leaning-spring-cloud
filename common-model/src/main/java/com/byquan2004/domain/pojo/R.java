package com.byquan2004.domain.pojo;
import lombok.Data;

@Data
public class R<T> {
    private Integer code; // 响应状态码，例如 200 表示成功，500 表示服务器错误
    private String message; // 响应消息，用于描述结果或错误信息
    private T data; // 泛型数据对象，用于携带返回的具体数据

    // 成功时返回的数据
    public static <T> R<T> success(T data) {
        R<T> response = new R<>();
        response.setCode(200);
        response.setMessage("操作成功");
        response.setData(data);
        return response;
    }

    // 失败时返回的数据
    public static <T> R<T> error(Integer code, String message) {
        R<T> response = new R<>();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
}
