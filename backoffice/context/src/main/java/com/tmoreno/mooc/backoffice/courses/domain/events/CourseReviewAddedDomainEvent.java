package com.tmoreno.mooc.backoffice.courses.domain.events;

import com.tmoreno.mooc.backoffice.courses.domain.CourseId;
import com.tmoreno.mooc.backoffice.courses.domain.ReviewId;
import com.tmoreno.mooc.backoffice.courses.domain.ReviewRating;
import com.tmoreno.mooc.backoffice.courses.domain.ReviewText;
import com.tmoreno.mooc.backoffice.shared.domain.CreatedOn;
import com.tmoreno.mooc.backoffice.shared.events.DomainEvent;
import com.tmoreno.mooc.backoffice.students.domain.StudentId;

public final class CourseReviewAddedDomainEvent extends DomainEvent {
    private final ReviewId reviewId;
    private final StudentId studentId;
    private final ReviewRating rating;
    private final ReviewText text;
    private final CreatedOn createdOn;

    public CourseReviewAddedDomainEvent(
            CourseId courseId,
            ReviewId reviewId,
            StudentId studentId,
            ReviewRating rating,
            ReviewText text,
            CreatedOn createdOn
    ) {
        super(courseId);

        this.reviewId = reviewId;
        this.studentId = studentId;
        this.rating = rating;
        this.text = text;
        this.createdOn = createdOn;
    }

    @Override
    public String getEventName() {
        return "course.review.added";
    }

    @Override
    public int getVersion() {
        return 1;
    }

    public ReviewId getReviewId() {
        return reviewId;
    }

    public StudentId getStudentId() {
        return studentId;
    }

    public ReviewRating getRating() {
        return rating;
    }

    public ReviewText getText() {
        return text;
    }

    public CreatedOn getCreatedOn() {
        return createdOn;
    }
}
