package com.meta_content.service.dto;

import com.meta_content.service.model.MetaTagAttributes;
import lombok.Data;

import java.util.List;
@Data
public class MetaContentDto {
    private String slugName;
    private List<MetaTagAttributes> metaTagAttributesList;
}
