package ru.pcs.store.manager.form;

import lombok.Value;
import ru.pcs.store.manager.enums.ClientStatus;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
public class ClientForm {
    @NotEmpty
    String name;

    @NotEmpty
    String phone;

    @NotEmpty
    String address;

    @NotEmpty
    String email;

    @NotEmpty
    @NotNull
    ClientStatus status;
}
