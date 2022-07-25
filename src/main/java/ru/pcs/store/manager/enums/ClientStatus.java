package ru.pcs.store.manager.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ClientStatus {
    active("Активный"),
    passive("Неактивный"),
    archive("В архиве");

    private final String alias;

    public String getAlias() {
        return alias;
    }
}
