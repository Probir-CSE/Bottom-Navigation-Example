package com.probir.bottomnavigation_example.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.probir.bottomnavigation_example.Models.QModel;
import com.probir.bottomnavigation_example.PlayerDetailsActivity;
import com.probir.bottomnavigation_example.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Probir Bhowmik on 09-Feb-20. Soft BD Ltd. Email:probirbhowmikcse@gmail.com
 */
public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.MYViewHolder> {
    private ContextCompat ctxs;
    private Context ctx;
    private onVideoPlayListItemClickListener onVideoPlayListItemClickListener;
    private YouTubePlayerView youTubePlayerView;
    private Context context;

    private QModel[] qModels;
    private TextView playerNameTv;

    public DetailsAdapter(Context context, QModel[] qModels, TextView playerNameTv, YouTubePlayerView youTubePlayerView) {
        this.qModels = qModels;
        this.playerNameTv = playerNameTv;
        this.youTubePlayerView = youTubePlayerView;
        this.context = context;
    }

    @NonNull
    @Override
    public MYViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_name_list, parent, false);
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.)
        MYViewHolder myViewHolder = new MYViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MYViewHolder holder, final int position) {
        final QModel qModel = qModels[position];
        holder.subNameTv.setText(qModels[position].getSubjectName());
        holder.subIni.setText(qModels[position].getSubjectName());
        //------------------------------------
        String[] old = holder.subNameTv.getText().toString().split(" ");
        String add = "";
        for (String s : old)
            add += "" + s.charAt(0);
        holder.subIni.setText(add);
        //----------------------------------------------------------------
//        Random r = new Random();
//        int red=r.nextInt(255 - 0 + 1)+0;
//        int green=r.nextInt(255 - 0 + 1)+0;
//        int blue=r.nextInt(255 - 0 + 1)+0;
        List<String> colors;

        colors = new ArrayList<String>();

        colors.add("#5E97F6");
        colors.add("#9CCC65");
        colors.add("#FF8A65");
        colors.add("#9E9E9E");
        colors.add("#9FA8DA");
        colors.add("#90A4AE");
        colors.add("#AED581");
        colors.add("#F6BF26");
        colors.add("#FFA726");
        colors.add("#4DD0E1");
        colors.add("#BA68C8");
        colors.add("#A1887F");

// all colors used by gmail application :) may be,

        // genrating random num from 0 to 11 because you can add more or less

        Random r = new Random();
        int i1 = r.nextInt(11 - 0) + 0;

//genrating shape with colors

        GradientDrawable draw = new GradientDrawable();
//        draw.setShape(GradientDrawable.OVAL);
        draw.setColor(Color.parseColor(colors.get(i1)));

//        GradientDrawable draw = new GradientDrawable();
//        draw.setColor(Color.rgb(red,green,blue));
        draw.setCornerRadii(new float[]{20, 20, 20, 20, 20, 20, 20, 20});
        holder.cardView.setBackground(draw);
//        holder.cardView.setBackground(qModels[position].getCardView().getBackground());
        //-----------------------------------------------------------------
        holder.RV_mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(v.getContext(), "" + qModel.getSubjectName() + " " + position, Toast.LENGTH_SHORT).show();
                playerNameTv.setText(qModel.getSubjectName());
//                Context context = v.getContext();

                youTubePlayerView.release();
                youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(@NonNull YouTubePlayer youTubePlayer) {
//                        String videoId = "mWRsgZuwf_8";
                        String videoId = qModel.getSubjectName();
                        youTubePlayer.loadVideo(videoId, 0);
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return qModels.length;
    }

    public class MYViewHolder extends RecyclerView.ViewHolder {
        TextView subIni, subNameTv;
        LinearLayout RV_mainLayout;
        CardView cardView;

        public MYViewHolder(@NonNull View itemView) {
            super(itemView);
            RV_mainLayout = itemView.findViewById(R.id.RV_mainLayout);
            subIni = itemView.findViewById(R.id.TV_subIni);
            subNameTv = itemView.findViewById(R.id.TV_subName);
            cardView = itemView.findViewById(R.id.CardView);
        }
    }

    public interface onVideoPlayListItemClickListener {

        void callBack(int position);
    }
}

