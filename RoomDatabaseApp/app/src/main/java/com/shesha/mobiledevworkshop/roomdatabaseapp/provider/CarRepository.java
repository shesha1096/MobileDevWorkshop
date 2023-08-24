package com.shesha.mobiledevworkshop.roomdatabaseapp.provider;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CarRepository {
    private ICarDao mCarsDao;
    private LiveData<List<Car>> mAllCars;

    CarRepository(Application application) {
        CarDatabase db = CarDatabase.getDatabase(application);
        mCarsDao = db.customerDao();
        mAllCars = mCarsDao.getAllCustomer();
    }
    LiveData<List<Car>> getAllCustomers() {
        return mAllCars;
    }
    void insert(Car car) {
        CarDatabase.databaseWriteExecutor.execute(() -> mCarsDao.addCar(car));
    }

    void deleteAll(){
        CarDatabase.databaseWriteExecutor.execute(()->{
            mCarsDao.deleteAllCars();
        });
    }

    int getCarPrices()
    {
        AtomicInteger price = new AtomicInteger();
        CarDatabase.databaseWriteExecutor.execute(()->{
            price.set(mCarsDao.getCarPrices());
        });

        return price.get();
    }

}
