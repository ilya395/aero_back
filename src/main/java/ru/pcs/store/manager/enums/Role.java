package ru.pcs.store.manager.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {
    ADMIN("Администратор"),
    OWNER("Владелец"),
    MANAGER("Менеджер"),
    CUSTOMER("Покупатель");

    private final String alias;

    public String getAlias() {
        return alias;
    }
}
