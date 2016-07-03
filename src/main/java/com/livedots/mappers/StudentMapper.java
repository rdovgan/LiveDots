package com.livedots.mappers;

import com.livedots.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.livedots.model.Student;

public interface StudentMapper {
	@Insert("INSERT INTO user(login, password, firstName,"
			+ "lastName, birth, emailAddress) VALUES"
			+ "(#{userName},#{password}, #{firstName}, #{lastName},"
			+ "#{dateOfBirth}, #{emailAddress})")
	@Options(useGeneratedKeys=true, keyProperty="id", flushCache=true, keyColumn="id")
	public void insertStudent(Student student);
		
	@Select("SELECT LOGIN as userName, PASSWORD as password, "
			+ "FIRSTNAME as firstName, LASTNAME as lastName, "
			+ "BIRTH as dateOfBirth, EMAILADDRESS as emailAddress "
			+ "FROM user WHERE login = #{userName}")
	public Student getStudentByUserName(String userName);


}
