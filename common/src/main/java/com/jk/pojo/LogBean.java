package com.jk.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "web_log")
public class LogBean {
    private String id;
    private String className;
    private String methodName;
    private String requestParam;
    private String responseParam;
}
