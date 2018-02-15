package task.com.formytrip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Daehwan.Kim on 2018-02-13.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
            Toast.makeText(context, " - Screen On - ", Toast.LENGTH_SHORT).show();
            Intent StartActivityIntent = new Intent(context, ScreenOnActivity.class);
            StartActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(StartActivityIntent);
        }
    }

}
