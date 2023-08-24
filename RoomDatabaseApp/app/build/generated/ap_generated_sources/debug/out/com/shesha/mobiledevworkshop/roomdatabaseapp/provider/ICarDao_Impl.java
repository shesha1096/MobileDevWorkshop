package com.shesha.mobiledevworkshop.roomdatabaseapp.provider;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ICarDao_Impl implements ICarDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Car> __insertionAdapterOfCar;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCarsByMaker;

  private final SharedSQLiteStatement __preparedStmtOfRemoveOldCars;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllCars;

  public ICarDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCar = new EntityInsertionAdapter<Car>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `cars` (`id`,`maker`,`model`,`year`,`color`,`seats`,`price`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Car value) {
        stmt.bindLong(1, value.getId());
        if (value.getMaker() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMaker());
        }
        if (value.getModel() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getModel());
        }
        stmt.bindLong(4, value.getYear());
        if (value.getColor() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getColor());
        }
        stmt.bindLong(6, value.getSeats());
        stmt.bindDouble(7, value.getPrice());
      }
    };
    this.__preparedStmtOfDeleteCarsByMaker = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from cars where maker= ?";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveOldCars = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from cars where year<1970";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllCars = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete FROM cars";
        return _query;
      }
    };
  }

  @Override
  public void addCar(final Car car) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCar.insert(car);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCarsByMaker(final String maker) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCarsByMaker.acquire();
    int _argIndex = 1;
    if (maker == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, maker);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteCarsByMaker.release(_stmt);
    }
  }

  @Override
  public void removeOldCars() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveOldCars.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveOldCars.release(_stmt);
    }
  }

  @Override
  public void deleteAllCars() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllCars.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllCars.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Car>> getAllCustomer() {
    final String _sql = "select * from cars";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"cars"}, false, new Callable<List<Car>>() {
      @Override
      public List<Car> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfMaker = CursorUtil.getColumnIndexOrThrow(_cursor, "maker");
          final int _cursorIndexOfModel = CursorUtil.getColumnIndexOrThrow(_cursor, "model");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfSeats = CursorUtil.getColumnIndexOrThrow(_cursor, "seats");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final List<Car> _result = new ArrayList<Car>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Car _item;
            final String _tmpMaker;
            if (_cursor.isNull(_cursorIndexOfMaker)) {
              _tmpMaker = null;
            } else {
              _tmpMaker = _cursor.getString(_cursorIndexOfMaker);
            }
            final String _tmpModel;
            if (_cursor.isNull(_cursorIndexOfModel)) {
              _tmpModel = null;
            } else {
              _tmpModel = _cursor.getString(_cursorIndexOfModel);
            }
            final int _tmpYear;
            _tmpYear = _cursor.getInt(_cursorIndexOfYear);
            final String _tmpColor;
            if (_cursor.isNull(_cursorIndexOfColor)) {
              _tmpColor = null;
            } else {
              _tmpColor = _cursor.getString(_cursorIndexOfColor);
            }
            final int _tmpSeats;
            _tmpSeats = _cursor.getInt(_cursorIndexOfSeats);
            final double _tmpPrice;
            _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            _item = new Car(_tmpMaker,_tmpModel,_tmpYear,_tmpColor,_tmpSeats,_tmpPrice);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<Car> getCarsByMaker(final String maker) {
    final String _sql = "select * from cars where maker=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (maker == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, maker);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfMaker = CursorUtil.getColumnIndexOrThrow(_cursor, "maker");
      final int _cursorIndexOfModel = CursorUtil.getColumnIndexOrThrow(_cursor, "model");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
      final int _cursorIndexOfSeats = CursorUtil.getColumnIndexOrThrow(_cursor, "seats");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final List<Car> _result = new ArrayList<Car>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Car _item;
        final String _tmpMaker;
        if (_cursor.isNull(_cursorIndexOfMaker)) {
          _tmpMaker = null;
        } else {
          _tmpMaker = _cursor.getString(_cursorIndexOfMaker);
        }
        final String _tmpModel;
        if (_cursor.isNull(_cursorIndexOfModel)) {
          _tmpModel = null;
        } else {
          _tmpModel = _cursor.getString(_cursorIndexOfModel);
        }
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final String _tmpColor;
        if (_cursor.isNull(_cursorIndexOfColor)) {
          _tmpColor = null;
        } else {
          _tmpColor = _cursor.getString(_cursorIndexOfColor);
        }
        final int _tmpSeats;
        _tmpSeats = _cursor.getInt(_cursorIndexOfSeats);
        final double _tmpPrice;
        _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
        _item = new Car(_tmpMaker,_tmpModel,_tmpYear,_tmpColor,_tmpSeats,_tmpPrice);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getCarPrices() {
    final String _sql = "select sum(price) from cars";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
