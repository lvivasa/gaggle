package com.gaggle.sdetassesment.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class RequestData {
    private String baseUri;
    private String basePath;
    private Map<String, String> pathParams;
    //private Map<String, ?> header;
    //private Map<String, ?> queryParams;
    //private Map<String, ?> formParams;
}
