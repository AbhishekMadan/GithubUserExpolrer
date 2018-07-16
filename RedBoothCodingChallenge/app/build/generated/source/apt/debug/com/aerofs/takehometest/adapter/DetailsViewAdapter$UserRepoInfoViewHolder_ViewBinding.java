// Generated code from Butter Knife. Do not modify!
package com.aerofs.takehometest.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aerofs.takehometest.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailsViewAdapter$UserRepoInfoViewHolder_ViewBinding implements Unbinder {
  private DetailsViewAdapter.UserRepoInfoViewHolder target;

  @UiThread
  public DetailsViewAdapter$UserRepoInfoViewHolder_ViewBinding(DetailsViewAdapter.UserRepoInfoViewHolder target,
      View source) {
    this.target = target;

    target.mRepoLogo = Utils.findRequiredViewAsType(source, R.id.repo_placeholder_tv, "field 'mRepoLogo'", TextView.class);
    target.mRepoName = Utils.findRequiredViewAsType(source, R.id.repo_name_tv, "field 'mRepoName'", TextView.class);
    target.mRepoLang = Utils.findRequiredViewAsType(source, R.id.repo_lang_tv, "field 'mRepoLang'", TextView.class);
    target.mRepoStar = Utils.findRequiredViewAsType(source, R.id.star_iv, "field 'mRepoStar'", ImageView.class);
    target.mRepoStarCount = Utils.findRequiredViewAsType(source, R.id.star_cnt_tv, "field 'mRepoStarCount'", TextView.class);
    target.mRepoFork = Utils.findRequiredViewAsType(source, R.id.fork_cnt_tv, "field 'mRepoFork'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailsViewAdapter.UserRepoInfoViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRepoLogo = null;
    target.mRepoName = null;
    target.mRepoLang = null;
    target.mRepoStar = null;
    target.mRepoStarCount = null;
    target.mRepoFork = null;
  }
}
