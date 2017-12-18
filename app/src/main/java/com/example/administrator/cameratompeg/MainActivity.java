package com.example.administrator.cameratompeg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.modle.CameraToMpegTest.CameraToMpegTest;

public class MainActivity extends AppCompatActivity {
    private Button mCameraRecord = null;
    CameraToMpegTest mCameraMpeg = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCameraRecord = (Button)findViewById(R.id.record_camera);
        mCameraRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (mCameraMpeg != null) {

                            try {
                                mCameraMpeg.testEncodeCameraToMp4();
                            } catch (Throwable throwable) {
                                throwable.printStackTrace();
                            }
                        }
                    }
                });
                thread.start();
            }

        });
        mCameraMpeg = new CameraToMpegTest();
    }

}
