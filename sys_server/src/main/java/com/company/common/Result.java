package com.company.common;

import com.company.constant.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author LYinera
 * @version 1.0
 * @description: 结果泛型类
 * @date 2024/1/27 21:05
 */

@Getter
@ToString
@ApiModel(value = "通用返回结果")
public class Result<T> {
    @ApiModelProperty(value = "响应码")
    private Integer status;
    @ApiModelProperty(value = "响应信息")
    private String msg;
    @ApiModelProperty(value = "响应数据")
    private T data;

    public Result setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    /**
     * @description: 请求成功的相应结果
     * @param: null
     * @return: Result
     * @author LYinera
     * @date: 2024/1/27 21:02
     */
    public static Result success() {
        return new Result().setStatus(Status.SUCCESS_CODE);
    }

    /**
     * @description: 请求失败的相应结果
     * @param: null
     * @return: Result
     * @author LYinera
     * @date: 2024/1/27 21:02
     */
    public static Result failure() {
        return new Result().setStatus(Status.FAILURE_CODE);
    }
}
