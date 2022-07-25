package ru.pcs.store.manager.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PaymentMethod {
    prepayment("Предоплата"),
    fullSettlement("Полный расчет"),
    compensation("Компенсация");

    private final String alias;

    public String getAlias() {
        return alias;
    }
}
