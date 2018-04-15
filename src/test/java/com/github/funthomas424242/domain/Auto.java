package com.github.funthomas424242.domain;

import com.github.funthomas424242.rades.annotations.accessors.RadesAddAccessor;
import com.github.funthomas424242.rades.annotations.builder.RadesAddBuilder;

@RadesAddBuilder(simpleBuilderClassName = "CarBuilder")
@RadesAddAccessor(simpleAccessorClassName = "CarAccessor")
public class Auto {

    protected String typ;

    protected String motor;

    protected String hersteller;

}
