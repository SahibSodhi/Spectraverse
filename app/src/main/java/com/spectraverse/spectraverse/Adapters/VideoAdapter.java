package com.spectraverse.spectraverse.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.spectraverse.spectraverse.R;
import com.spectraverse.spectraverse.models.VideosResponseModel;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<VideosResponseModel.VideosDataModel> List;


    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public VideoView mVideoView;


        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.video_txt);
            mVideoView = itemView.findViewById(R.id.video_view);

        }
    }

    public VideoAdapter(Context context) {
        mContext = context;

    }

    public void setDataValue(ArrayList<VideosResponseModel.VideosDataModel> list){
        this.List=list;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public VideoAdapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_video, viewGroup, false);
        VideoAdapter.ExampleViewHolder evh = new VideoAdapter.ExampleViewHolder(v);
        return evh;

    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ExampleViewHolder exampleViewHolder, int i) {
        VideosResponseModel.VideosDataModel currentItem = List.get(i);

        exampleViewHolder.mTextView.setText(""+ (i+1) + ". " + currentItem.getContent().getTitle());

        //Play video from url
        String videoPath = currentItem.getContent().getContent_path();
        Uri uri = Uri.parse(videoPath);
        exampleViewHolder.mVideoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(mContext);
        exampleViewHolder.mVideoView.setMediaController(mediaController);
        mediaController.setAnchorView(exampleViewHolder.mVideoView);
    }

    @Override
    public int getItemCount() {
        return List==null ? 0 : List.size();
    }
}
