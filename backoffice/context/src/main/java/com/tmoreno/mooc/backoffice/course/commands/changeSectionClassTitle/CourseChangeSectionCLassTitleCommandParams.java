package com.tmoreno.mooc.backoffice.course.commands.changeSectionClassTitle;

import com.tmoreno.mooc.shared.command.CommandParams;

public final class CourseChangeSectionCLassTitleCommandParams extends CommandParams {

    private String courseId;
    private String sectionId;
    private String sectionClassId;
    private String title;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionClassId() {
        return sectionClassId;
    }

    public void setSectionClassId(String sectionClassId) {
        this.sectionClassId = sectionClassId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
