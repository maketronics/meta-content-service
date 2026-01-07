package com.meta_content.service.service;

import com.meta_content.service.dto.*;
import com.meta_content.service.model.MetaContentEntity;
import com.meta_content.service.model.MetaTagAttributes;
import com.meta_content.service.repository.MetaContentRepo;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MetaContentService {
    @Autowired
    MetaContentRepo metaContentRepo;
    public MetaContentResponse storeMetaTag(MetaContentDto metaData) {
        MetaContentEntity metaContentEntity = new MetaContentEntity();
        metaContentEntity.setSlugName(metaData.getSlugName());

        List<MetaTagAttributes> metaTags = new ArrayList<>();

        for(MetaTagAttributes tags : metaData.getMetaTagAttributesList()){
            MetaTagAttributes metaTagAttributes = new MetaTagAttributes();
            metaTagAttributes.setPropertyName(tags.getPropertyName());
            metaTagAttributes.setPropertyValue(tags.getPropertyValue());
            metaTagAttributes.setContentName(tags.getContentName());
            metaTagAttributes.setContentValue(tags.getContentValue());
            metaTags.add(tags);
        }

        metaContentEntity.setMetaTagAttributesList(metaTags);
        MetaContentEntity metaContent = metaContentRepo.save(metaContentEntity);
       return createMetaTags(metaContent);

    }

    private MetaContentResponse createMetaTags(MetaContentEntity metaContent) {
        MetaContentResponse metaResponse = new MetaContentResponse();
        metaResponse.setSlugName(metaContent.getSlugName());
        List<String> metaTags = new ArrayList<>();
        for(MetaTagAttributes metaTag : metaContent.getMetaTagAttributesList()){
            String contentName = metaTag.getContentName();
            String contentValue = metaTag.getContentValue();
            String propertyName = metaTag.getPropertyName();
            String propertyValue = metaTag.getPropertyValue();
            String metaTagString = String.format(
                    "<meta %s=\"%s\" %s=\"%s\" />",
                    propertyName, propertyValue, contentName, contentValue
            );
            metaTags.add(metaTagString);
        }
        metaResponse.setMetaTags(metaTags);

        return metaResponse;
    }

    public BreadCrumbRes generateBreadcrumbs(List<BreadCrumbReq> crumbReq) {
        BreadCrumbRes response = new BreadCrumbRes();
        int position = 1;
        List<BreadCrumbItem> breadCrumbItemList = new ArrayList<>();
        for(BreadCrumbReq breadCrumbReq : crumbReq){
            BreadCrumbItem crumbItem = new BreadCrumbItem();
            crumbItem.setName(breadCrumbReq.getName());
            crumbItem.setItem(breadCrumbReq.getItem());
            crumbItem.setPosition(position++);
            breadCrumbItemList.add(crumbItem);
        }
        response.setItemListElement(breadCrumbItemList);
       return response;
    }
}
