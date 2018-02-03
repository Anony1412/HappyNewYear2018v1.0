package a0.happynewyear2018v1.anony1412.itptit.happynewyear;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Anony1412 on 1/31/2018.
 */

public class Music extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private RelativeLayout rl_screenMusic;
    private ArrayList<Integer> backgrounds;
    private ImageButton ibtn_undo;

    private ListView lv_musics;
    private MusicAdapter adapter;
    private ArrayList<MusicModel> musics;

    private String[] musicNames = new String[]{
            "Câu Chuyện Đầu Năm",
            "Con Bướm Xuân",
            "Đoản Xuân Ca",
            "Đón Xuân",
            "Đón Xuân Này Nhớ Xuân Xưa",
            "Happy New Year",
            "Khúc Giao Mùa",
            "Lắng Nghe Mùa Xuân Về",
            "Một Năm Mới Bình An",
            "Mùa Xuân Ơi",
            "Ngày Tết Quê Em",
            "Ngày Xuân Long Phụng Xum Vầy",
            "Phố Xuân",
            "Thế Là Tết",
            "Xuân Đã Về",
            "Xuân Hà Nội",
            "Xuân Này Con Không Về"
    };

    private String[] singerNames = new String[]{
            "Hiền Thục",
            "Hồ Quang Hiếu",
            "Minh Vương M4U",
            "Như Quỳnh",
            "Jang Mi",
            "ABBA",
            "Trung Quân idol, Bảo Anh",
            "Hồng Nhung, Bằng Kiều",
            "Sơn Tùng M-TP",
            "Bích Phương",
            "V.A",
            "V.A",
            "Việt My",
            "Đức Phúc & Hòa Minzy",
            "Minh Hằng",
            "Thái Vũ",
            "Quang Lê"
    };

    private MediaPlayer current_song;
    private ArrayList<Integer> arrSongs = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        maps();
        setBackgroundImages();
        setupMusicList();
        setClicks();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // set background song
        current_song = MediaPlayer.create(getApplicationContext(), R.raw.wait);
        current_song.setLooping(true);
        current_song.start();
    }

    private void setBackgroundImages() {
        Random random = new Random();
        backgrounds = new ArrayList<>();
        backgrounds.add(R.drawable.background_music_activity);
        backgrounds.add(R.drawable.background_music_activity1);
        backgrounds.add(R.drawable.background_music_activity2);
        backgrounds.add(R.drawable.background_music_activity3);
        backgrounds.add(R.drawable.background_music_activity4);
        backgrounds.add(R.drawable.background_music_activity5);
        backgrounds.add(R.drawable.background_music_activity6);

        rl_screenMusic.setBackgroundResource(backgrounds.get(random.nextInt(backgrounds.size())));
    }

    private void setupMusicList() {
        // setup for listview song
        setListViewSongs();

        // setup to do play song
        addSongForList();
    }

    private void setListViewSongs() {
        musics = new ArrayList<>();
        MusicModel item;
        for (int i = 0; i < musicNames.length; i++) {
            item = new MusicModel(musicNames[i], singerNames[i]);
            musics.add(item);
        }
        adapter = new MusicAdapter(this, R.layout.music_item, musics);
        lv_musics.setAdapter(adapter);
    }

    private void addSongForList() {
        arrSongs.add(R.raw.cauchuyendaunam_hienthuc);
        arrSongs.add(R.raw.conbuomxuan_hoquanghieu);
        arrSongs.add(R.raw.doanxuanca_minhvuongm4u);
        arrSongs.add(R.raw.donxuan_nhuquynh);
        arrSongs.add(R.raw.donxuannaynhoxuanxua_jangmi);
        arrSongs.add(R.raw.happynewyear);
        arrSongs.add(R.raw.khucgiaomua_trungquan);
        arrSongs.add(R.raw.langnghemuaxuanve);
        arrSongs.add(R.raw.motnammoibinhan);
        arrSongs.add(R.raw.muaxuanoi);
        arrSongs.add(R.raw.ngaytetqueem);
        arrSongs.add(R.raw.ngayxuanlongphungxumvay);
        arrSongs.add(R.raw.phoxuan);
        arrSongs.add(R.raw.thelatet_ducphucfthoaminzi);
        arrSongs.add(R.raw.xuandave);
        arrSongs.add(R.raw.xuanhanoi);
        arrSongs.add(R.raw.xuannayconkhongve);
    }

    private void setClicks() {
        ibtn_undo.setOnClickListener(this);
       lv_musics.setOnItemClickListener(this);
    }

    private void maps() {
        // ánh xạ
        rl_screenMusic = findViewById(R.id.rl_screenMusic);
        ibtn_undo = findViewById(R.id.ibtn_undo);
        lv_musics = findViewById(R.id.lv_music);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ibtn_undo: {
                // change activity
                current_song.stop();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // do something with item of list song.
        current_song.stop();
        current_song = MediaPlayer.create(getApplicationContext(), arrSongs.get(position));
        current_song.start();
        Toast.makeText(this, musics.get(position).getMusicName() + " is playing", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Nghe hết bài hát để ngừng phát!", Toast.LENGTH_SHORT).show();
    }
}
