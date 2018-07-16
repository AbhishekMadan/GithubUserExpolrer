// Generated code from Butter Knife. Do not modify!
package com.aerofs.takehometest.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aerofs.takehometest.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchFragment_ViewBinding implements Unbinder {
  private SearchFragment target;

  private View view2131296291;

  @UiThread
  public SearchFragment_ViewBinding(final SearchFragment target, View source) {
    this.target = target;

    View view;
    target.mUsername = Utils.findRequiredViewAsType(source, R.id.et_username, "field 'mUsername'", EditText.class);
    view = Utils.findRequiredView(source, R.id.bt_get_detail_button, "field 'mSubmitButton' and method 'onClickSubmit'");
    target.mSubmitButton = Utils.castView(view, R.id.bt_get_detail_button, "field 'mSubmitButton'", Button.class);
    view2131296291 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickSubmit();
      }
    });
    target.mProgressBar = Utils.findRequiredViewAsType(source, R.id.progress, "field 'mProgressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mUsername = null;
    target.mSubmitButton = null;
    target.mProgressBar = null;

    view2131296291.setOnClickListener(null);
    view2131296291 = null;
  }
}
