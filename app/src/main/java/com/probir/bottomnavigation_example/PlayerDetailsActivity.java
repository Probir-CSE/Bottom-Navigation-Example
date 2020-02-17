package com.probir.bottomnavigation_example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.probir.bottomnavigation_example.Adapter.DetailsAdapter;
import com.probir.bottomnavigation_example.Adapter.QAdapter;
import com.probir.bottomnavigation_example.Models.QModel;
import com.probir.bottomnavigation_example.ui.home.HomeViewModel;

public class PlayerDetailsActivity extends AppCompatActivity implements DetailsAdapter.onVideoPlayListItemClickListener {
    TextView playerNameTv;
    private HomeViewModel homeViewModel;
    private QModel[] qModels;
    private RecyclerView recyclerView;
    private YouTubePlayerView youTubePlayerView;
    private String videoid;
    private DetailsAdapter adapter;
//    private YouTubePlayer youTubePlayer;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);
        playerNameTv = findViewById(R.id.TV_playerName);

        recyclerView = findViewById(R.id.RV_SubjectName);
        youTubePlayerView = findViewById(R.id.youtube_player_view);

        getIntentfromRecyclerView();
//        getLifecycle().addObserver(youTubePlayerView);
        /*getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "S0Q4gqBUs7c";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });*/
        getSubjectName();
    }

    private void getIntentfromRecyclerView() {
        if (getIntent().hasExtra("name")) {
            String PlayerName = getIntent().getStringExtra("name");

            setPlayerName(PlayerName);
            getSupportActionBar().setTitle(PlayerName);
        }

    }

    private void setPlayerName(String playerName) {
        playerNameTv.setText(playerName);

    }

    public void getSubjectName() {
        qModels = new QModel[]{
                new QModel("mWRsgZuwf_8"),
                new QModel("1G4isv_Fylg"),
                new QModel("VPRjCeoBqrI")
        };

        adapter = new DetailsAdapter(context, qModels, playerNameTv, youTubePlayerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void callBack(int position) {
        Toast.makeText(this, "Interface"+" "+position,Toast.LENGTH_SHORT).show();
    }

    public void playone(View view) {
//        youTubePlayerView.release();
        youTubePlayerView.notify();
//        youTubePlayerView.setEnableAutomaticInitialization(true);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                videoid = "mWRsgZuwf_8";
//                youTubePlayer.loadVideo(videoId, 0);

                YouTubePlayerUtils.loadOrCueVideo(youTubePlayer,getLifecycle(),videoid,0f);
            }
        });
    }

    public void vplayTwo(View view) {

//        youTubePlayerView = findViewById(R.id.youtube_player_view);
//        getLifecycle().addObserver(youTubePlayerView);

//        youTubePlayerView.release();
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                videoid = "XggxeuFDaDU";
//                youTubePlayer.loadVideo(videoId, 0);

                YouTubePlayerUtils.loadOrCueVideo(youTubePlayer,getLifecycle(),videoid,0f);
            }
        });
    }
}
