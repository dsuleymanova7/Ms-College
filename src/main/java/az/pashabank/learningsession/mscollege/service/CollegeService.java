package az.pashabank.learningsession.mscollege.service;

import az.pashabank.learningsession.mscollege.entity.College;

import java.util.List;

public interface CollegeService {
    boolean addCollege(College college);

    College getCollegeById(Integer id);

    List<College> getAllCollages();

    boolean update(College college);

    boolean delete(Integer id);
}
