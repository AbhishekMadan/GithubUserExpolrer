// Generated code from Butter Knife. Do not modify!
package com.aerofs.takehometest.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aerofs.takehometest.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailsFragment_ViewBinding implements Unbinder {
  private DetailsFragment target;

  @UiThread
  public DetailsFragment_ViewBinding(DetailsFragment target, View source) {
    this.target = target;

    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.list_item, "field 'mRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
  }
}
