package com.github.funthomas424242.domain;

/*-
 * #%L
 * rades-annotations
 * %%
 * Copyright (C) 2018 PIUG
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */
import javax.annotation.Generated;

@Generated(value="RadesAccessorProcessor"
, date="2018-04-06T20:36:46.750"
, comments="com.github.funthomas424242.domain.Auto")
public class CarAccessor {

    protected final Auto auto;

    public CarAccessor( final Auto auto ){
        this.auto = auto;
    }

    public Auto toAuto(){
        return this.auto;
    }

    public java.lang.String getHersteller( ) {
        return this.auto.hersteller;
    }

    public java.lang.String getTyp( ) {
        return this.auto.typ;
    }

    public java.lang.String getMotor( ) { 
        return this.auto.motor;
    }

}
