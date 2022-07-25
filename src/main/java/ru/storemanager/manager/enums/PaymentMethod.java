package ru.storemanager.manager.enums;

public enum PaymentMethod {
    cash("наличные"),
    creditCard("банковская карта");

    private final String alias;

    PaymentMethod(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }
}
