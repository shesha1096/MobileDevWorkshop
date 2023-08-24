package com.shesha.mobiledevworkshop.roomdatabaseapp.provider;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ICarDao {

    @Query("select * from cars")
    LiveData<List<Car>> getAllCustomer();

    @Query("select * from cars where maker=:maker")
    List<Car> getCarsByMaker(String maker);

    @Insert
    void addCar(Car car);

    @Query("delete from cars where maker= :maker")
    void deleteCarsByMaker(String maker);

    @Query("delete from cars where year<1970")
    void removeOldCars();

    @Query("delete FROM cars")
    void deleteAllCars();

    @Query("select sum(price) from cars")
    int getCarPrices();
}
