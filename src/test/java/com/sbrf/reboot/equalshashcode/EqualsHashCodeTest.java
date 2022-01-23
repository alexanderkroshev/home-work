package com.sbrf.reboot.equalshashcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class EqualsHashCodeTest {

     class Car {
        String model;
        String color;
        Calendar releaseDate;
        int maxSpeed;

        @Override
        public boolean equals(Object o) {
            //Рефлексивность: объект должен равняться самому себе
            if (o == this)
                return true;
            if(o == null)
                return false;
            if(getClass()!= o.getClass())
                return false;
            if(!((Car) o).model.equals(model))
                return false;
            if(!((Car) o).color.equals(color))
                return false;
            if(!((Car) o).releaseDate.equals(releaseDate))
                return false;
            if(maxSpeed != ((Car) o).maxSpeed)
                return false;
            return true;
        }

        @Override
         public int hashCode() {
            final int prime =31;//??? почему именно 31?
            int result =17;
            result = prime*result + (model == null ? 0 : model.hashCode());
            result = prime*result + (color == null ? 0 : color.hashCode());
            result = prime*result + (releaseDate == null ? 0 : releaseDate.hashCode());
            result = prime*result + maxSpeed;

            return result;
        }



     }

    @Test
    public  void assertTrueEquals() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Mercedes";
        car2.color = "black";
        car2.releaseDate = new GregorianCalendar(2020, 0, 25);
        car2.maxSpeed = 10;


        Assertions.assertTrue(car1.equals(car2));
    }

    @Test
    public void assertFalseEquals() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Audi";
        car2.color = "white";
        car2.releaseDate = new GregorianCalendar(2017, 0, 25);
        car2.maxSpeed = 10;

        Assertions.assertFalse(car1.equals(car2));
    }

    @Test
    public void successEqualsHashCode(){
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Mercedes";
        car2.color = "black";
        car2.releaseDate = new GregorianCalendar(2020, 0, 25);
        car2.maxSpeed = 10;

        Assertions.assertEquals(car1.hashCode(),car2.hashCode());

    }

    @Test
    public void failEqualsHashCode(){
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Audi";
        car2.color = "white";
        car2.releaseDate = new GregorianCalendar(2017, 0, 25);
        car2.maxSpeed = 10;

        Assertions.assertNotEquals(car1.hashCode(),car2.hashCode());

    }


}
