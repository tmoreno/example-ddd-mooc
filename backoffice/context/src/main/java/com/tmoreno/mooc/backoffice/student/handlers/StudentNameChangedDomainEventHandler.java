package com.tmoreno.mooc.backoffice.student.handlers;

import com.tmoreno.mooc.backoffice.student.domain.Student;
import com.tmoreno.mooc.backoffice.student.domain.StudentId;
import com.tmoreno.mooc.backoffice.student.domain.StudentRepository;
import com.tmoreno.mooc.backoffice.student.domain.events.StudentNameChangedDomainEvent;
import com.tmoreno.mooc.backoffice.student.domain.exceptions.StudentNotFoundException;
import com.tmoreno.mooc.shared.domain.PersonName;
import com.tmoreno.mooc.shared.events.EventHandler;

public class StudentNameChangedDomainEventHandler implements EventHandler<StudentNameChangedDomainEvent> {

    private final StudentRepository repository;

    public StudentNameChangedDomainEventHandler(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(StudentNameChangedDomainEvent event) {
        StudentId studentId = new StudentId(event.getAggregateId());
        PersonName name = event.getName();

        Student student = repository.find(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));

        student.changeName(name);

        repository.save(student);
    }
}
