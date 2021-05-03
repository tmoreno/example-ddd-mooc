package com.tmoreno.mooc.backoffice.courses.domain.events;

import com.tmoreno.mooc.backoffice.courses.domain.CourseId;
import com.tmoreno.mooc.backoffice.shared.events.DomainEvent;
import com.tmoreno.mooc.backoffice.teachers.domain.TeacherId;

public final class CourseTeacherAddedDomainEvent extends DomainEvent {
    private final TeacherId teacherId;

    public CourseTeacherAddedDomainEvent(CourseId courseId, TeacherId teacherId) {
        super(courseId);
        this.teacherId = teacherId;
    }

    @Override
    public String getEventName() {
        return "course.teacher.deleted";
    }

    @Override
    public int getVersion() {
        return 1;
    }

    public TeacherId getTeacherId() {
        return teacherId;
    }
}
