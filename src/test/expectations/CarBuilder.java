package com.github.funthomas424242.domain;

import com.github.funthomas424242.rades.annotations.accessors.InvalidAccessorException;
import javax.annotation.Generated;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Generated(value="RadesBuilderProcessor"
, date="2018-04-06T20:36:46.750"
, comments="com.github.funthomas424242.domain.Auto")
public class CarBuilder {

    private Auto auto;

    public CarBuilder(){
        this(new Auto());
    }

    public CarBuilder( final Auto auto ){
        this.auto = auto;
    }

    public Auto build() {
        final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        final java.util.Set<ConstraintViolation<Auto>> constraintViolations = validator.validate(this.auto);

        if (constraintViolations.size() > 0) {
            java.util.Set<String> violationMessages = new java.util.HashSet<String>();

            for (ConstraintViolation<?> constraintViolation : constraintViolations) {
                violationMessages.add(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
            }

            final StringBuffer buf = new StringBuffer();
            buf.append("Auto is not valid:\n");
            violationMessages.forEach(message -> buf.append(message + "\n"));
            throw new ValidationException(buf.toString());
        }
        final Auto value = this.auto;
        this.auto = null;
        return value;
    }

    public <A> A build(Class<A> accessorClass) {
        final Auto auto = this.build();
        this.auto=auto;
        try{
            final Constructor<A> constructor=accessorClass.getDeclaredConstructor(Auto.class);
            final A accessor = constructor.newInstance(auto);
            this.auto=null;
            return accessor;
        }catch(NoSuchMethodException | IllegalAccessException|  InstantiationException|  InvocationTargetException ex){
            throw new InvalidAccessorException("ungültige Accessorklasse übergeben",ex);
        }
    }

    public CarBuilder withHersteller( final java.lang.String hersteller ) {
        this.auto.hersteller = hersteller;
        return this;
    }

    public CarBuilder withTyp( final java.lang.String typ ) {
        this.auto.typ = typ;
        return this;
    }

    public CarBuilder withMotor( final java.lang.String motor ) {
        this.auto.motor = motor;
        return this;
    }

}
