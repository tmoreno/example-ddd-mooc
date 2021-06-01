package com.tmoreno.mooc.backoffice.configuration;

import com.tmoreno.mooc.backoffice.course.domain.exceptions.ChangeCourseAttributeException;
import com.tmoreno.mooc.backoffice.course.domain.exceptions.CourseExistsException;
import com.tmoreno.mooc.backoffice.course.domain.exceptions.CourseNotFoundException;
import com.tmoreno.mooc.backoffice.course.domain.exceptions.CourseReviewNotFoundException;
import com.tmoreno.mooc.backoffice.course.domain.exceptions.CourseSectionClassNotFoundException;
import com.tmoreno.mooc.backoffice.course.domain.exceptions.CourseSectionNotFoundException;
import com.tmoreno.mooc.backoffice.course.domain.exceptions.CourseStudentNotFoundException;
import com.tmoreno.mooc.backoffice.course.domain.exceptions.CourseTeacherNotFoundException;
import com.tmoreno.mooc.backoffice.course.domain.exceptions.DiscardCourseException;
import com.tmoreno.mooc.backoffice.course.domain.exceptions.InvalidCourseDescriptionException;
import com.tmoreno.mooc.backoffice.course.domain.exceptions.InvalidCourseImageUrlException;
import com.tmoreno.mooc.backoffice.course.domain.exceptions.InvalidCourseSummaryException;
import com.tmoreno.mooc.backoffice.course.domain.exceptions.InvalidCourseTitleException;
import com.tmoreno.mooc.backoffice.course.domain.exceptions.InvalidSectionClassTitleException;
import com.tmoreno.mooc.backoffice.course.domain.exceptions.InvalidSectionTitleException;
import com.tmoreno.mooc.backoffice.course.domain.exceptions.PublishCourseException;
import com.tmoreno.mooc.backoffice.review.domain.exceptions.ReviewNotFoundException;
import com.tmoreno.mooc.backoffice.student.domain.exceptions.StudentCourseNotFoundException;
import com.tmoreno.mooc.backoffice.student.domain.exceptions.StudentNotFoundException;
import com.tmoreno.mooc.backoffice.student.domain.exceptions.StudentReviewNotFoundException;
import com.tmoreno.mooc.backoffice.teacher.domain.exceptions.TeacherCourseNotFoundException;
import com.tmoreno.mooc.backoffice.teacher.domain.exceptions.TeacherExistsException;
import com.tmoreno.mooc.backoffice.teacher.domain.exceptions.TeacherNotFoundException;
import com.tmoreno.mooc.shared.domain.ExceptionResponseBody;
import com.tmoreno.mooc.shared.domain.exceptions.InvalidDurationException;
import com.tmoreno.mooc.shared.domain.exceptions.InvalidEmailException;
import com.tmoreno.mooc.shared.domain.exceptions.InvalidIdentifierException;
import com.tmoreno.mooc.shared.domain.exceptions.InvalidPersonNameException;
import com.tmoreno.mooc.shared.domain.exceptions.MoneyValueIsNegativeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public final class ExceptionHelper {

    private final Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);

    @ExceptionHandler(value = {
        InvalidDurationException.class,
        InvalidEmailException.class,
        InvalidIdentifierException.class,
        InvalidPersonNameException.class,
        MoneyValueIsNegativeException.class,
        InvalidCourseDescriptionException.class,
        InvalidCourseImageUrlException.class,
        InvalidCourseSummaryException.class,
        InvalidCourseTitleException.class,
        InvalidSectionTitleException.class,
        InvalidSectionClassTitleException.class
    })
    public ResponseEntity<Object> badRequestHandler(RuntimeException e) {
        logger.error("Bad request", e);

        return new ResponseEntity<>(
                new ExceptionResponseBody(HttpStatus.BAD_REQUEST.value(), e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = {
        TeacherNotFoundException.class,
        TeacherCourseNotFoundException.class,
        StudentNotFoundException.class,
        StudentCourseNotFoundException.class,
        StudentReviewNotFoundException.class,
        ReviewNotFoundException.class,
        CourseNotFoundException.class,
        CourseReviewNotFoundException.class,
        CourseSectionClassNotFoundException.class,
        CourseSectionNotFoundException.class,
        CourseStudentNotFoundException.class,
        CourseTeacherNotFoundException.class
    })
    public ResponseEntity<Object> notFoundHandler(RuntimeException e) {
        logger.error("Not found", e);

        return new ResponseEntity<>(
                new ExceptionResponseBody(HttpStatus.NOT_FOUND.value(), e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(value = {
        TeacherExistsException.class,
        CourseExistsException.class,
        ChangeCourseAttributeException.class,
        DiscardCourseException.class,
        PublishCourseException.class
    })
    public ResponseEntity<Object> preconditionFailedHandler(RuntimeException e) {
        logger.error("Precondition failed", e);

        return new ResponseEntity<>(
                new ExceptionResponseBody(HttpStatus.PRECONDITION_FAILED.value(), e.getMessage()),
                HttpStatus.PRECONDITION_FAILED
        );
    }
}
