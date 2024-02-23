package com.github.milk.gourmet.domain;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

import java.io.Serializable;

@Data
public class GourmetFacility implements Serializable {
    private static final long serialVersionUID = 1L;


    @Alias("locationid")
    private String locationId;
    @Alias("Applicant")
    private String applicant;
    @Alias("FacilityType")
    private String facilityType;
    private String cnn;
    @Alias("LocationDescription")
    private String locationDescription;
    @Alias("Address")
    private String address;
    private String permit;
    @Alias("Status")
    private String status;
    @Alias("FoodItems")
    private String foodItems;
    @Alias("Latitude")
    private Double latitude;
    @Alias("Longitude")
    private Double longitude;
    @Alias("Zip Codes")
    private String zipCodes;
}
