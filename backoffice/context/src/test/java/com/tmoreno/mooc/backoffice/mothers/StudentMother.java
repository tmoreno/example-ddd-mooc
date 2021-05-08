package com.tmoreno.mooc.backoffice.mothers;

import com.tmoreno.mooc.backoffice.courses.domain.CourseId;
import com.tmoreno.mooc.backoffice.courses.domain.ReviewId;
import com.tmoreno.mooc.backoffice.student.domain.Student;
import com.tmoreno.mooc.shared.mothers.EmailMother;
import com.tmoreno.mooc.shared.mothers.PersonNameMother;

import java.util.HashSet;
import java.util.Set;

public final class StudentMother {
    public static Student random() {
        return new Student(
            StudentIdMother.random(),
            PersonNameMother.random(),
            EmailMother.random()
        );
    }

    public static Student randomWithCourse(CourseId courseId) {
        Set<CourseId> courses = new HashSet<>();
        courses.add(courseId);

        return new Student(
            StudentIdMother.random(),
            PersonNameMother.random(),
            EmailMother.random(),
            courses,
            Set.of()
        );
    }

    public static Student randomWithReview(ReviewId reviewId) {
        Set<ReviewId> reviews = new HashSet<>();
        reviews.add(reviewId);

        return new Student(
            StudentIdMother.random(),
            PersonNameMother.random(),
            EmailMother.random(),
            Set.of(),
            reviews
        );
    }
}
