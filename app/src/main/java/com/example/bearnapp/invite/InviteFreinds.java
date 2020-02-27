package com.example.bearnapp.invite;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bearnapp.R;
import com.example.bearnapp.invite.adapter.InviteFriendsAdapter;
import com.example.bearnapp.invite.model.InviteFriendsItems;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class InviteFreinds extends AppCompatActivity implements InviteFriendsAdapter.OnClickLisitner1 {
    ImageView imgBackIcon;
    ImageView imgFilterMenu;
    ImageView imgMenuDashBoard;
    TextView txtCreate;
    MaterialButton btnInviteFriends;

    ArrayList<InviteFriendsItems> inviteFriendsItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_freinds);

        imgBackIcon = findViewById(R.id.imgBackIcon);
        imgFilterMenu = findViewById(R.id.imgFilterMenu);
        txtCreate = findViewById(R.id.txtCreate);
        imgMenuDashBoard = findViewById(R.id.imgMenuDashBoard);
        btnInviteFriends = findViewById(R.id.btnInviteFriends);

        RecyclerView recyclerViewInviteFriends = findViewById(R.id.inviteFriendsRecycle);
        inviteFriendsItems = new ArrayList<>();

        inviteFriendsItems.add(new InviteFriendsItems("Thomas Chandler", R.drawable.bg_person));
        inviteFriendsItems.add(new InviteFriendsItems("Harriett Burke", R.drawable.bg_peson));
        inviteFriendsItems.add(new InviteFriendsItems("Isabel Mathis", R.drawable.bg_person));
        inviteFriendsItems.add(new InviteFriendsItems("Victor Cobb", R.drawable.bg_peson));
        inviteFriendsItems.add(new InviteFriendsItems("Walter Flower", R.drawable.bg_person));
        inviteFriendsItems.add(new InviteFriendsItems("Thomas Chandler", R.drawable.bg_person));
        inviteFriendsItems.add(new InviteFriendsItems("Harriett Burke", R.drawable.bg_peson));
        inviteFriendsItems.add(new InviteFriendsItems("Isabel Mathis", R.drawable.bg_person));
        inviteFriendsItems.add(new InviteFriendsItems("Victor Cobb", R.drawable.bg_peson));
        inviteFriendsItems.add(new InviteFriendsItems("Walter Flower", R.drawable.bg_person));
        inviteFriendsItems.add(new InviteFriendsItems("Thomas Chandler", R.drawable.bg_person));
        inviteFriendsItems.add(new InviteFriendsItems("Harriett Burke", R.drawable.bg_peson));
        inviteFriendsItems.add(new InviteFriendsItems("Isabel Mathis", R.drawable.bg_person));
        inviteFriendsItems.add(new InviteFriendsItems("Victor Cobb", R.drawable.bg_peson));
        inviteFriendsItems.add(new InviteFriendsItems("Walter Flower", R.drawable.bg_person));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerViewInviteFriends.setLayoutManager(gridLayoutManager);
        ItemOffsetDecoration itemOffsetDecoration = new ItemOffsetDecoration(this, R.dimen.item_offset);
        recyclerViewInviteFriends.addItemDecoration(itemOffsetDecoration);
        InviteFriendsAdapter objCustomAdapter1 = new InviteFriendsAdapter(inviteFriendsItems, this);
        recyclerViewInviteFriends.setAdapter(objCustomAdapter1);

        imgBackIcon.setVisibility(View.VISIBLE);
        imgBackIcon.setColorFilter(getResources().getColor(R.color.Black));
        imgFilterMenu.setVisibility(View.GONE);
        txtCreate.setText("Invite Friends");
        imgMenuDashBoard.setVisibility(View.GONE);

        imgBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void selectedCount1(int count) {
        if (count > 0)
            btnInviteFriends.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.Green));
        else
            btnInviteFriends.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.Dark_Blue));
    }

    public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {
        private int mItemOffset;

        public ItemOffsetDecoration(int itemOffset) {
            mItemOffset = itemOffset;
        }

        public ItemOffsetDecoration(@NonNull Context context, @DimenRes int itemOffsetId) {
            this(context.getResources().getDimensionPixelSize(itemOffsetId));
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent,
                                   @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
        }
    }
}
