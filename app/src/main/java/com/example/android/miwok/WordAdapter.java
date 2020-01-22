package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int ColorResourceId;
    private int AudioResourceID;
    MediaPlayer mediaPlayer=new MediaPlayer();

    public WordAdapter(Context context, ArrayList<Word> array,int colorid){
        super(context,0,array);
        ColorResourceId=colorid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word w=getItem(position);
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        if(w.hasImage()) {
            image.setImageResource(w.getImageResourceId());
        }
        else {
            image.setVisibility(View.GONE);
        }

        TextView defaultTrans=(TextView)listItemView.findViewById(R.id.default_text_view);
        defaultTrans.setText(""+w.getDefaultTranslation());

        TextView miwokTrans=(TextView)listItemView.findViewById(R.id.miwok_text_view);
        miwokTrans.setText(""+w.getMiwokTranslations());

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), ColorResourceId);
        textContainer.setBackgroundColor(color);
        View playButton = listItemView.findViewById(R.id.play_pause);
        playButton.setBackgroundColor(color);

        return listItemView;
    }
}
