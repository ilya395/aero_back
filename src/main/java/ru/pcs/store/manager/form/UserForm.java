package ru.pcs.store.manager.form;

import lombok.Value;
import ru.pcs.store.manager.enums.Role;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
public class UserForm {
    @NotEmpty
    String name;

    @NotEmpty
    String phone;

    @NotEmpty
    String email;

    @NotEmpty
    @NotNull
    Role role;
}
