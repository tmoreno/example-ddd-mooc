package com.tmoreno.mooc.backoffice.student.handlers;

import com.tmoreno.mooc.backoffice.course.domain.CourseId;
import com.tmoreno.mooc.backoffice.course.domain.events.CourseStudentDeletedDomainEvent;
import com.tmoreno.mooc.backoffice.student.domain.Student;
import com.tmoreno.mooc.backoffice.student.domain.StudentId;
import com.tmoreno.mooc.backoffice.student.domain.StudentRepository;
import com.tmoreno.mooc.backoffice.student.domain.exceptions.StudentNotFoundException;
import com.tmoreno.mooc.shared.events.EventHandler;

public final class CourseStudentDeletedDomainEventHandler implements EventHandler<CourseStudentDeletedDomainEvent> {

    private final StudentRepository repository;

    public CourseStudentDeletedDomainEventHandler(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(CourseStudentDeletedDomainEvent event) {
        CourseId courseId = event.getCourseId();
        StudentId studentId = event.getStudentId();

        Student student = repository.find(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));

        student.deleteCourse(courseId);

        repository.save(student);
    }
}
