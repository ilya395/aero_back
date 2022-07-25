package ru.pcs.store.manager.form;

import lombok.Value;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Value
public class BalanceForm {

    @NotEmpty
    Integer number;

    @NotEmpty
    BigDecimal totalPrice;

    @NotEmpty
    BigDecimal margin;
}
