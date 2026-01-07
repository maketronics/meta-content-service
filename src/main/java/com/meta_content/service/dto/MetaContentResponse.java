package com.meta_content.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class MetaContentResponse {
    private String slugName;
    private List<String> metaTags;
}
