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
}
