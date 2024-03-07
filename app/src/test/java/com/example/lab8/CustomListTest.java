package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.countCities();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.countCities(),listSize + 1);
    }

    @Test
    void hasCityTest() {
        list = MockCityList();
        City city = new City("city2", "province2");
        assertEquals(false, list.hasCity(city));
        list.addCity(city);
        assertEquals(true, list.hasCity(city));
    }

    @Test
    void deleteTest() {
        list = MockCityList();
        City city = new City("city3", "province3");
        list.addCity(city);
        assertEquals(true, list.hasCity(city));
        list.deleteCity(city);
        assertEquals(false, list.hasCity(city));
    }

    @Test
    void countCitiesTest() {
        list = MockCityList();
        assertEquals(0, list.countCities());

        City city = new City("city3", "province3");
        list.addCity(city);
        assertEquals(1, list.countCities());

        list.deleteCity(city);
        assertEquals(0, list.countCities());
    }

}
