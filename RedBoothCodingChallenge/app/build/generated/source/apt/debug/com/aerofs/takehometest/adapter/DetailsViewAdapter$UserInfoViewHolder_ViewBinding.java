// Generated code from Butter Knife. Do not modify!
package com.aerofs.takehometest.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aerofs.takehometest.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailsViewAdapter$UserInfoViewHolder_ViewBinding implements Unbinder {
  private DetailsViewAdapter.UserInfoViewHolder target;

  @UiThread
  public DetailsViewAdapter$UserInfoViewHolder_ViewBinding(DetailsViewAdapter.UserInfoViewHolder target,
      View source) {
    this.target = target;

    target.mMugShot = Utils.findRequiredViewAsType(source, R.id.mugshot, "field 'mMugShot'", CircleImageView.class);
    target.mUserName = Utils.findRequiredViewAsType(source, R.id.user_name, "field 'mUserName'", TextView.class);
    target.mLocation = Utils.findRequiredViewAsType(source, R.id.user_location, "field 'mLocation'", TextView.class);
    target.mPublicRepo = Utils.findRequiredViewAsType(source, R.id.user_public_repo, "field 'mPublicRepo'", TextView.class);
    target.mFollowers = Utils.findRequiredViewAsType(source, R.id.followers_tv, "field 'mFollowers'", TextView.class);
    target.mFollowing = Utils.findRequiredViewAsType(source, R.id.following_tv, "field 'mFollowing'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailsViewAdapter.UserInfoViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mMugShot = null;
    target.mUserName = null;
    target.mLocation = null;
    target.mPublicRepo = null;
    target.mFollowers = null;
    target.mFollowing = null;
  }
}
