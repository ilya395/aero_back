package ru.pcs.store.manager.form;

import lombok.Value;
import ru.pcs.store.manager.enums.OrderStatus;
import ru.pcs.store.manager.enums.PaymentMethod;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Value
public class OrderForm {

    @NotEmpty
    String address;

    @NotEmpty
    @NotNull
    Date date;

    @NotEmpty
    OrderStatus status;

    @NotEmpty
    BigDecimal price;

    PaymentMethod paymentMethod;
}
