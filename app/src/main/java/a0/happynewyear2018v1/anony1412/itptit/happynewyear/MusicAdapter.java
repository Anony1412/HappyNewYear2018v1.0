package a0.happynewyear2018v1.anony1412.itptit.happynewyear;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Anony1412 on 2/2/2018.
 */

public class MusicAdapter extends ArrayAdapter<MusicModel> {

    private LayoutInflater inflater;
    private Context context;
    private List<MusicModel> musics;

    public MusicAdapter(@NonNull Context context, int resource, @NonNull List<MusicModel> objects) {
        super(context, resource, objects);
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.musics = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.music_item, parent, false);
            holder.txt_musicName = convertView.findViewById(R.id.txt_musicName);
            holder.txt_singerName = convertView.findViewById(R.id.txt_singerName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        MusicModel item = musics.get(position);
        holder.txt_musicName.setText(item.getMusicName());
        holder.txt_singerName.setText(item.getSingerName());
        return convertView;
    }

    class ViewHolder {
        private TextView txt_musicName;
        private TextView txt_singerName;
    }
}
