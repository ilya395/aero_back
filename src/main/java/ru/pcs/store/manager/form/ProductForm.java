package ru.pcs.store.manager.form;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Value
public class ProductForm {

    @NotEmpty
    String name;

    @NotEmpty
    String color;

    @NotEmpty
    String material;

    @NotEmpty
    Integer size;

    //todo private TYPE photo;
}
