package com.tmoreno.mooc.backoffice.course.domain.events;

import com.tmoreno.mooc.backoffice.course.domain.CourseId;
import com.tmoreno.mooc.backoffice.course.domain.SectionClassId;
import com.tmoreno.mooc.backoffice.course.domain.SectionId;
import com.tmoreno.mooc.shared.domain.DurationInSeconds;
import com.tmoreno.mooc.shared.events.DomainEvent;

public final class CourseSectionClassDurationChangedDomainEvent extends DomainEvent {
    private final SectionId sectionId;
    private final SectionClassId sectionClassId;
    private final DurationInSeconds duration;

    public CourseSectionClassDurationChangedDomainEvent(
            CourseId id,
            SectionId sectionId,
            SectionClassId sectionClassId,
            DurationInSeconds duration
    ) {
        super(id);

        this.sectionId = sectionId;
        this.sectionClassId = sectionClassId;
        this.duration = duration;
    }

    @Override
    public String getEventName() {
        return "course.section.class.duration.changed";
    }

    @Override
    public int getVersion() {
        return 1;
    }

    public SectionId getSectionId() {
        return sectionId;
    }

    public SectionClassId getSectionClassId() {
        return sectionClassId;
    }

    public DurationInSeconds getDuration() {
        return duration;
    }
}
