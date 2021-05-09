package com.tmoreno.mooc.backoffice.teacher.domain.events;

import com.tmoreno.mooc.shared.domain.PersonName;
import com.tmoreno.mooc.shared.events.DomainEvent;
import com.tmoreno.mooc.backoffice.teacher.domain.TeacherId;

public final class TeacherNameChangedDomainEvent extends DomainEvent {

    private final TeacherId teacherId;
    private final PersonName name;

    public TeacherNameChangedDomainEvent(TeacherId teacherId, PersonName name) {
        this.teacherId = teacherId;
        this.name = name;
    }

    @Override
    public String getEventName() {
        return "teacher.name.changed";
    }

    @Override
    public int getVersion() {
        return 1;
    }

    public TeacherId getTeacherId() {
        return teacherId;
    }

    public PersonName getName() {
        return name;
    }
}
