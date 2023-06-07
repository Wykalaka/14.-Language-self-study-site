package com.uep.wap.repository;

import com.uep.wap.model.Started_Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Started_CourseRepository extends CrudRepository<Started_Course, Integer> {
}
