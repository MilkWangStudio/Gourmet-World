package com.github.milk.gourmet.service;

import com.github.milk.gourmet.domain.GourmetFacility;
import com.github.milk.gourmet.domain.Result;
import com.github.milk.gourmet.repo.FacilityCSVRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class GourmetService {
    @Resource
    private FacilityCSVRepository repository;

    public Result<List<GourmetFacility>> queryFacilities() {
        return Result.success(repository.queryFacilities());
    }
}
