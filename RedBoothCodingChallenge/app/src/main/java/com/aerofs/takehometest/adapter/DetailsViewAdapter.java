package com.aerofs.takehometest.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aerofs.takehometest.R;
import com.aerofs.takehometest.network.pojo.Repo;
import com.aerofs.takehometest.network.pojo.User;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.ArrayList;


public class DetailsViewAdapter extends RecyclerView.Adapter {

    private ArrayList mList;
    private Context mContext;

    public DetailsViewAdapter(Context context, ArrayList li) {
            mList = li;
            mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType==0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_info_view,parent,false);
            return new UserInfoViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_repo_info_view,parent,false);
            return new UserRepoInfoViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType()==0) {
            initUserInfoView((UserInfoViewHolder) holder, (User) mList.get(position));
        } else {
            initUserRepoInfoView((UserRepoInfoViewHolder) holder,(Repo) mList.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position) instanceof User) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }

    private void initUserInfoView(UserInfoViewHolder holder, User user) {
        holder.mUserName.setText(user.getName());
        holder.mLocation.setText(user.getLocation());
        holder.mPublicRepo.setText("Public repo: "+user.getPublicRepos());
        holder.mFollowing.setText(String.valueOf(user.getFollowing()));
        holder.mFollowers.setText(String.valueOf(user.getFollowers()));
        //Picasso for loading avatar
        Picasso.with(holder.mMugShot.getContext()).load(user.getAvatarUrl()).into(holder.mMugShot);
    }

    private void initUserRepoInfoView(UserRepoInfoViewHolder holder, Repo repo) {
        holder.mRepoLogo.setText(String.valueOf(repo.getName().charAt(0)));
        holder.mRepoLogo.setBackgroundColor(getRandomMaterialColor("400"));
        holder.mRepoName.setText(repo.getName());
        holder.mRepoLang.setText(TextUtils.isEmpty(repo.getLanguage())?holder.mRepoLang.getContext().getString(R.string.no_value):
                                    repo.getLanguage());
        if (repo.getStargazersCount()>0) {
            holder.mRepoStar.setImageResource(R.drawable.ic_star);
        } else {
            holder.mRepoStar.setImageResource(R.drawable.ic_no_star);
        }
        holder.mRepoStarCount.setText(String.valueOf(repo.getStargazersCount()));
        holder.mRepoFork.setText(String.valueOf(repo.getForksCount()));
    }

    public int getRandomMaterialColor(String type) {
        int returnColor = 0;
        int arrayId = mContext.getResources().getIdentifier("mdcolor_" + type, "array", mContext.getPackageName());

        if (arrayId != 0) {
            TypedArray colors = mContext.getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.GRAY);
            colors.recycle();
        }
        return returnColor;
    }

    class UserInfoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.mugshot)
        CircleImageView mMugShot;
        @BindView(R.id.user_name)
        TextView mUserName;
        @BindView(R.id.user_location)
        TextView mLocation;
        @BindView(R.id.user_public_repo)
        TextView mPublicRepo;
        @BindView(R.id.followers_tv)
        TextView mFollowers;
        @BindView(R.id.following_tv)
        TextView mFollowing;

        public UserInfoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    class UserRepoInfoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.repo_placeholder_tv)
        TextView mRepoLogo;
        @BindView(R.id.repo_name_tv)
        TextView mRepoName;
        @BindView(R.id.repo_lang_tv)
        TextView mRepoLang;
        @BindView(R.id.star_iv)
        ImageView mRepoStar;
        @BindView(R.id.star_cnt_tv)
        TextView mRepoStarCount;
        @BindView(R.id.fork_cnt_tv)
        TextView mRepoFork;

        public UserRepoInfoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
