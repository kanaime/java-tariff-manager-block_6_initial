package dev.wcs.nad.tariffmanager.customer.model;

import java.time.LocalDate;

public class VICustomer extends Customer {
    private int discountPercentage;

    public VICustomer(int discountPercentage, String id, String name, String email, LocalDate birthDate,
            LocalDate lastPurchase) {
        super(id, name, email, birthDate, lastPurchase);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculateDiscountedPrice(int value) {
        return value - (value / 10);
    }

    @Override
    public boolean isRelevantForMailing() {
        return true;
    }
}