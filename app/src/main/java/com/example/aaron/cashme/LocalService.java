package com.example.aaron.cashme;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by Aaron on 26/04/17.
 */

public class LocalService extends Service {

    private final IBinder mBinder = new LocalBinder();
    DBHelper mydb = new DBHelper(LocalService.this);

    public class LocalBinder extends Binder {
        LocalService getService() {
            return LocalService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /** method to call database to calculate net income */
    public double calcNetIncome() {
        return mydb.calculateNetIncome();
    }
}