package com.anil.spring.boot.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.anil.spring.boot.api.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	/*
	 * //@
	 * Query("select d from Department d join d.students s where s.subject IN: subjects"
	 * ) //@
	 * Query("SELECT new com.anil.spring.boot.api.model(d FROM Department d JOIN d.students s WHERE s.subject IN :subjects"
	 * ) //@
	 * Query("SELECT new com.anil.spring.boot.api.model.Department(d.id, d.name, d.capacity) FROM Department d JOIN d.students s WHERE s.subject IN :subjects"
	 * )
	 * 
	 * @Query("SELECT s FROM Student s JOIN s.department d WHERE d.name = :departmentName AND s.subjects IN :subjects"
	 * ) List<Department> findByStudentSubject(@Param("subjects") String[]
	 * subjects);
	 * 
	 * @Query("SELECT s FROM Student s JOIN s.department d WHERE d.name = :departmentName AND s.subjects IN :subjects"
	 * ) List<Department> findByStudentSubject(@Param("departmentName") String
	 * departmentName, @Param("subjects") String[] subjects);
	 */

}
