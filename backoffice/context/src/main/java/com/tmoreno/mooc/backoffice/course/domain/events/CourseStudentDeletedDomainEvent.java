package com.tmoreno.mooc.backoffice.course.domain.events;

import com.tmoreno.mooc.backoffice.course.domain.CourseId;
import com.tmoreno.mooc.shared.events.DomainEvent;
import com.tmoreno.mooc.backoffice.student.domain.StudentId;

public final class CourseStudentDeletedDomainEvent extends DomainEvent {

    private final CourseId courseId;
    private final StudentId studentId;

    public CourseStudentDeletedDomainEvent(CourseId courseId, StudentId studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    @Override
    public String getEventName() {
        return "course.student.deleted";
    }

    @Override
    public int getVersion() {
        return 1;
    }

    public CourseId getCourseId() {
        return courseId;
    }

    public StudentId getStudentId() {
        return studentId;
    }
}
