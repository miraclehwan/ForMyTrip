package task.com.formytrip;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Daehwan.Kim on 2018-02-13.
 */

public class ScreenOnService extends Service {

    private MyBroadcastReceiver myBroadcastReceiver;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("ScreenOnService", "onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("ScreenOnService", "onCreate");
        registerScreenOnReceiver();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("ScreenOnService", "onDestroy");
        unregisterScreenOnReceiver();
    }

    private void registerScreenOnReceiver(){
        myBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        registerReceiver(myBroadcastReceiver, intentFilter);

    }

    private void unregisterScreenOnReceiver(){
        if (myBroadcastReceiver != null){
            unregisterReceiver(myBroadcastReceiver);
        }
    }

}
