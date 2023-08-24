package com.shesha.mobiledevworkshop.roomdatabaseapp.provider;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CarsViewModel extends AndroidViewModel {
    private CarRepository mRepository;
    private LiveData<List<Car>> mAllCars;

    public CarsViewModel(@NonNull Application application) {
        super(application);
        mRepository = new CarRepository(application);
        mAllCars = mRepository.getAllCustomers();
    }

    public LiveData<List<Car>> getAllCars() {
        return mAllCars;
    }

    public void insert(Car car) {
        mRepository.insert(car);
    }
    public void deleteAll(){
        mRepository.deleteAll();
    }

    public int getCarPrices()
    {
        return mRepository.getCarPrices();
    }

}
