// Generated code from Butter Knife. Do not modify!
package com.aerofs.takehometest.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aerofs.takehometest.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.mCoordinatorLayout = Utils.findRequiredViewAsType(source, R.id.coordinator_layout, "field 'mCoordinatorLayout'", CoordinatorLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mCoordinatorLayout = null;
  }
}
