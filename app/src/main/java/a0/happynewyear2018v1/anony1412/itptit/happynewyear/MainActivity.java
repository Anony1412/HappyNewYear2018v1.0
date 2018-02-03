package a0.happynewyear2018v1.anony1412.itptit.happynewyear;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer bg_song;
    private Button btn_showMusicList, btn_exit;
    private RelativeLayout rl_screen;
    private ArrayList<Integer> backgrounds;

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maps();
        setBackground();
        setSounds();
        setClicks();
    }

    private void setClicks() {
        btn_showMusicList.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
    }

    private void maps() {
        btn_showMusicList = findViewById(R.id.btn_showMusicList);
        btn_exit = findViewById(R.id.btn_exit);
        rl_screen = findViewById(R.id.rl_screen);
    }

    private void setSounds() {
        // setting background song
        setSoundBackGround();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_showMusicList: {
                bg_song.stop();
                Intent intent = new Intent(getApplicationContext(), Music.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_exit: {
                Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void setSoundBackGround() {
        bg_song = MediaPlayer.create(getApplicationContext(), R.raw.tayduky);
        bg_song.setLooping(true);
        bg_song.start();
    }

    private void addBackgroundImageList() {
        backgrounds = new ArrayList<>();
        backgrounds.add(R.drawable.background);
        backgrounds.add(R.drawable.background5);
        backgrounds.add(R.drawable.background1);
        backgrounds.add(R.drawable.background6);
        backgrounds.add(R.drawable.background2);
        backgrounds.add(R.drawable.background7);
        backgrounds.add(R.drawable.background3);
        backgrounds.add(R.drawable.background8);
        backgrounds.add(R.drawable.background4);
        backgrounds.add(R.drawable.background9);
        backgrounds.add(R.drawable.background10);
        backgrounds.add(R.drawable.background11);
        backgrounds.add(R.drawable.background12);
        backgrounds.add(R.drawable.background13);
        backgrounds.add(R.drawable.background14);
        backgrounds.add(R.drawable.background15);
        backgrounds.add(R.drawable.background16);
    }

    private void setBackground() {
        addBackgroundImageList();
        final CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                rl_screen.setBackgroundResource(backgrounds.get(random.nextInt(backgrounds.size())));
                this.start();
            }
        }.start();
    }
}
