package com.github.milk.gourmet.repo;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvUtil;
import com.github.milk.gourmet.config.GourmetProperties;
import com.github.milk.gourmet.domain.GourmetFacility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * Load restaurant data from the CSV file, and split it into corresponding elements.
 */
@Slf4j
@Component
public class FacilityCSVRepository implements CommandLineRunner {
    @Resource
    private GourmetProperties properties;

    private List<GourmetFacility> facilities = new ArrayList<>();


    @Override
    public void run(String... args) throws Exception {
        if (!"csv".equals(properties.getRepoType())) {
            return;
        }
        log.info("Start to load data from csv, location is {}", properties.getCsvLocation());
        CsvReader reader = CsvUtil.getReader();
        facilities = reader.read(ResourceUtil.getUtf8Reader(properties.getCsvLocation()), GourmetFacility.class);
    }

    public List<GourmetFacility> queryFacilities() {
        return facilities;
    }
}
