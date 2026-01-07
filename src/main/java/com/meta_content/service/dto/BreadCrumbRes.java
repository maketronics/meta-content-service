package com.meta_content.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BreadCrumbRes {
    @JsonProperty("@context")
    private String context = "https://schema.org/";

    @JsonProperty("@type")
    private String type = "BreadcrumbList";

    private List<BreadCrumbItem> itemListElement;
}
