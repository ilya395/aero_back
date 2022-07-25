package ru.pcs.store.manager.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductStatus {
    outOfStock("Нет на складе"),
    notEnough("Недостаточно"),
    enough("Достаточно");

    private final String alias;

    public String getAlias() {
        return alias;
    }
}
