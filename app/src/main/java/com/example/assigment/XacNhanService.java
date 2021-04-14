package com.example.assigment;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class XacNhanService extends Service {
    public XacNhanService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        Toast.makeText(this,"Đăng kí thành công",Toast.LENGTH_SHORT).show();
        String maMon = intent.getStringExtra("mamon");
        String monHoc = intent.getStringExtra("monhoc");
        Toast.makeText(this,"Mã Môn: \t" + maMon +"\nMôn Học: \t" +monHoc,Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
