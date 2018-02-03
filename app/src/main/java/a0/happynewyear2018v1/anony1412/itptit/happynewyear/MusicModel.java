package a0.happynewyear2018v1.anony1412.itptit.happynewyear;

/**
 * Created by Anony1412 on 2/2/2018.
 */

public class MusicModel {
    private String musicName;
    private String singerName;

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public MusicModel(String musicName, String singerName) {

        this.musicName = musicName;
        this.singerName = singerName;
    }
}
