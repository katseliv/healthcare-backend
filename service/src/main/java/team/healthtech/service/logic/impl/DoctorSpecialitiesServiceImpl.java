package team.healthtech.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.healthtech.db.repository.DoctorsSpecialitiesRepository;
import team.healthtech.service.logic.DoctorSpecialitiesService;
import team.healthtech.service.mapper.DoctorSpecialitiesMapper;
import team.healthtech.service.model.DoctorSpecialitiesDto;

import java.util.List;

@Service
public class DoctorSpecialitiesServiceImpl implements DoctorSpecialitiesService {

    private final DoctorsSpecialitiesRepository repository;
    private final DoctorSpecialitiesMapper mapper;

    @Autowired
    public DoctorSpecialitiesServiceImpl(
        DoctorsSpecialitiesRepository doctorsSpecialitiesRepository,
        DoctorSpecialitiesMapper mapper) {
        this.repository = doctorsSpecialitiesRepository;
        this.mapper = mapper;
    }

    @Override
    public List<DoctorSpecialitiesDto> getAllSpecialitiesByDoctorId(Integer doctorId) {
        return mapper.fromEntities(repository.getDoctorsSpecialitiesEntitiesByDoctorId(doctorId));
    }

}
