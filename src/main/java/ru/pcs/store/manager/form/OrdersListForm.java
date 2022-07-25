package ru.pcs.store.manager.form;

import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
public class OrdersListForm {

    @NotEmpty
    @NotNull
    Integer number;
}
