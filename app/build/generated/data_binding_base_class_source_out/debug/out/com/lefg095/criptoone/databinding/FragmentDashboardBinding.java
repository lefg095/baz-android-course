// Generated by view binder compiler. Do not edit!
package com.lefg095.criptoone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.lefg095.criptoone.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentDashboardBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView et1;

  @NonNull
  public final ConstraintLayout fragmentBlank;

  @NonNull
  public final RecyclerView rvOne;

  private FragmentDashboardBinding(@NonNull ConstraintLayout rootView, @NonNull TextView et1,
      @NonNull ConstraintLayout fragmentBlank, @NonNull RecyclerView rvOne) {
    this.rootView = rootView;
    this.et1 = et1;
    this.fragmentBlank = fragmentBlank;
    this.rvOne = rvOne;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDashboardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDashboardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_dashboard, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDashboardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.et_1;
      TextView et1 = rootView.findViewById(id);
      if (et1 == null) {
        break missingId;
      }

      ConstraintLayout fragmentBlank = (ConstraintLayout) rootView;

      id = R.id.rv_one;
      RecyclerView rvOne = rootView.findViewById(id);
      if (rvOne == null) {
        break missingId;
      }

      return new FragmentDashboardBinding((ConstraintLayout) rootView, et1, fragmentBlank, rvOne);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
