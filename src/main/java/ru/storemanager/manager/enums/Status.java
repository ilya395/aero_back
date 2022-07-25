package ru.storemanager.manager.enums;

public enum Status {
    processing("обрабатывается"),
    collecting("собирается"),
    shipping("доставляется"),
    shipped("доставлен");

    private final String alias;

    Status(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }
}
