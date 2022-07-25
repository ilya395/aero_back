package ru.pcs.store.manager.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderStatus {
    processing("Обрабатывается"),
    collecting("Собирается"),
    proofOfPayment("Подтверждение оплаты"),
    shipped("Доставлен");

    private final String alias;

    public String getAlias() {
        return alias;
    }
}
