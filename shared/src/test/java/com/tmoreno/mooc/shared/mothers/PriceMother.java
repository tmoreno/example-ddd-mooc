package com.tmoreno.mooc.shared.mothers;

import com.tmoreno.mooc.shared.domain.Price;
import org.apache.commons.lang3.RandomUtils;

import java.util.Currency;
import java.util.Locale;

public final class PriceMother {
    public static Price random() {
        return new Price(RandomUtils.nextDouble(1, 50), Currency.getInstance(Locale.US));
    }
}
