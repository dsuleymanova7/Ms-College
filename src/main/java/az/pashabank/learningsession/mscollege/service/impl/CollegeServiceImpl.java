package az.pashabank.learningsession.mscollege.service.impl;

import az.pashabank.learningsession.mscollege.entity.College;
import az.pashabank.learningsession.mscollege.repository.CollegeRepository;
import az.pashabank.learningsession.mscollege.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeRepository collegeDao;


    @Override
    public boolean addCollege(College college) {
        try {
            if (college.getId() == null || college.getName() == null || college.getCity() == null) {
                throw new Exception();
            }
            collegeDao.getColleges().add(college);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public College getCollegeById(Integer id) {
        List<College> result = collegeDao.getColleges().stream().filter(college -> college.getId().equals(id)).collect(Collectors.toList());
        return result.isEmpty() == false ? result.get(0) : null;
    }

    @Override
    public List<College> getAllCollages() {
        return collegeDao.getColleges().stream().sorted((o1, o2) -> o1.getId().compareTo(o2.getId())).collect(Collectors.toList());
    }

    @Override
    public boolean update(College college) {
        try {
            if (college.getId() == null || college.getName() == null || college.getCity() == null) {
                throw new Exception();
            }
            collegeDao.getColleges().removeIf(c -> c.getId().equals(college.getId()));
            collegeDao.getColleges().add(college);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try {
            if (id == null) {
                throw new Exception();
            }
            collegeDao.getColleges().removeIf(c -> c.getId().equals(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
