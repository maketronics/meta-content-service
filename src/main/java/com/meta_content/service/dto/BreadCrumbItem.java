package com.meta_content.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BreadCrumbItem {

    @JsonProperty("@type")
    private String type = "ListItem";

    private int position;

    private String name;

    private String item;
}
