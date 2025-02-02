package com.turkcell.turkcellcqrs.application.student.mapper;

import com.turkcell.turkcellcqrs.application.student.command.create.CreateStudentCommand;
import com.turkcell.turkcellcqrs.application.student.command.create.CreatedStudentResponse;
import com.turkcell.turkcellcqrs.domain.entity.Student;
import io.jsonwebtoken.security.Password;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {
    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Mapping(target = "studentNo", expression = "java(mapStudentNo())")
    @Mapping(target = "password", expression = "java(mapStudentPassword(CreateStudentCommand.getPassword()))")
    @Mapping(target = "email",expression = "java(createStudentCommand.getEmail())")
    public abstract Student createStudentFromCreateCommand(CreateStudentCommand createStudentCommand);

    @Mapping(target = "email", expression = "java(student.getEmail())")
    @Mapping(target = "studentNo", expression = "java(student.getStudentNo())")
    public abstract CreatedStudentResponse createCreatedResponseFromStudent(Student student);

    protected String mapStudentNo(){
        int randomNumber=(int)(Math.random()*100000);
        return String.valueOf(randomNumber);
    }

    protected String mapStudentPassword(String password)
    {
        return passwordEncoder.encode(password);
    }

}
