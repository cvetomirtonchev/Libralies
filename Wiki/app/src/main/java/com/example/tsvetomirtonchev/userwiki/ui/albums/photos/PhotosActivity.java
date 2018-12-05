package com.example.tsvetomirtonchev.userwiki.ui.albums.photos;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tsvetomirtonchev.userwiki.R;
import com.example.tsvetomirtonchev.userwiki.data.model.response.photo.Photo;
import com.example.tsvetomirtonchev.userwiki.ui.base.BaseActivity;

import java.util.List;

public class PhotosActivity extends BaseActivity {
    //Const
    public static final String ALBUMS = "Photos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        List<Photo> photos = null;
        if (getIntent().getExtras().containsKey(ALBUMS)) {
            photos = getIntent().getParcelableArrayListExtra(ALBUMS);
        }
        RecyclerView recyclerView = findViewById(R.id.recycler_view_photos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (photos != null) {
            recyclerView.setAdapter(new PhotosAdapter(photos, this));
        }
    }

}
