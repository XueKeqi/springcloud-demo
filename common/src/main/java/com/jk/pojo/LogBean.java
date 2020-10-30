package com.jk.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LogBean {
    private String id;
    private String methodName;
    private String className;
    private String requestParam;
    private String responseParan;
}
