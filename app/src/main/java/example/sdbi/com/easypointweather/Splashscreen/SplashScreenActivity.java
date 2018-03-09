package example.sdbi.com.easypointweather.Splashscreen;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

import example.sdbi.com.easypointweather.Login.MainActivity;
import example.sdbi.com.easypointweather.R;

/**
 * Created by Administrator on 2017/12/27.
 */

public class SplashScreenActivity extends Activity {
    private MyCountDownTimer mc;
    private   TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splashscreen_layout);
        View view = findViewById(R.id.mainactivity);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(3000);
        view.startAnimation(alphaAnimation);
        tv=(TextView) findViewById(R.id.timer);
        mc = new MyCountDownTimer(5000, 1000);
        mc.start();

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        new Handler().postDelayed(new Runnable() {//浠ヤ笅鏄牳蹇冧唬鐮�
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                SplashScreenActivity.this.finish();
            }
        }, 5000);
    }

    private Handler handler = new Handler();

    class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        public void onFinish() {
            tv.setText("跳过");
        }

        public void onTick(long millisUntilFinished) {
            tv.setText( millisUntilFinished / 1000 + " 秒跳过");
        }
    }
}
