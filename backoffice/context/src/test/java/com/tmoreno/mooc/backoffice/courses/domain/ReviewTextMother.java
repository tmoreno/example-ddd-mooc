package com.tmoreno.mooc.backoffice.courses.domain;

import org.apache.commons.lang3.RandomStringUtils;

public final class ReviewTextMother {
    public static ReviewText random() {
        return new ReviewText(RandomStringUtils.randomAlphabetic(100, 5000));
    }
}
