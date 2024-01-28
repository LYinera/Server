package com.company.common;

import com.company.constant.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author LYinera
 * @version 1.0
 * @description: 结果泛型类(分页)
 * @date 2024/1/27 21:05
 */

@Getter
@ToString
@ApiModel(value = "通用返回结果")
public class ResultPage<T> {
    @ApiModelProperty(value = "响应码")
    private Integer status;
    @ApiModelProperty(value = "响应信息")
    private String msg;
    @ApiModelProperty(value = "响应数据")
    private T data;
    @ApiModelProperty(value = "总条数")
    private Long total;

    public ResultPage setTotal(Long total) {
        this.total = total;
        return this;
    }

    public ResultPage setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public ResultPage setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResultPage setData(T data) {
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
    public static ResultPage success() {
        return new ResultPage().setStatus(Status.SUCCESS_CODE);
    }

    /**
     * @description: 请求失败的相应结果
     * @param: null
     * @return: Result
     * @author LYinera
     * @date: 2024/1/27 21:02
     */
    public static ResultPage failure() {
        return new ResultPage().setStatus(Status.FAILURE_CODE);
    }
}

