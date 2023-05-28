// Generated by view binder compiler. Do not edit!
package com.example.greenearth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.greenearth.R;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.slider.Slider;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCalculatorBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final CheckBox bin;

  @NonNull
  public final CheckBox burn;

  @NonNull
  public final FrameLayout calculator;

  @NonNull
  public final CheckBox compost;

  @NonNull
  public final CheckBox dairy;

  @NonNull
  public final CheckBox fruit;

  @NonNull
  public final CheckBox grains;

  @NonNull
  public final RangeSlider home;

  @NonNull
  public final CheckBox litter;

  @NonNull
  public final CheckBox meat;

  @NonNull
  public final EditText members;

  @NonNull
  public final CheckBox processed;

  @NonNull
  public final CheckBox threeR;

  @NonNull
  public final CheckBox veg;

  @NonNull
  public final Slider waste;

  @NonNull
  public final RangeSlider work;

  private ActivityCalculatorBinding(@NonNull FrameLayout rootView, @NonNull CheckBox bin,
      @NonNull CheckBox burn, @NonNull FrameLayout calculator, @NonNull CheckBox compost,
      @NonNull CheckBox dairy, @NonNull CheckBox fruit, @NonNull CheckBox grains,
      @NonNull RangeSlider home, @NonNull CheckBox litter, @NonNull CheckBox meat,
      @NonNull EditText members, @NonNull CheckBox processed, @NonNull CheckBox threeR,
      @NonNull CheckBox veg, @NonNull Slider waste, @NonNull RangeSlider work) {
    this.rootView = rootView;
    this.bin = bin;
    this.burn = burn;
    this.calculator = calculator;
    this.compost = compost;
    this.dairy = dairy;
    this.fruit = fruit;
    this.grains = grains;
    this.home = home;
    this.litter = litter;
    this.meat = meat;
    this.members = members;
    this.processed = processed;
    this.threeR = threeR;
    this.veg = veg;
    this.waste = waste;
    this.work = work;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCalculatorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCalculatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_calculator, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCalculatorBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bin;
      CheckBox bin = ViewBindings.findChildViewById(rootView, id);
      if (bin == null) {
        break missingId;
      }

      id = R.id.burn;
      CheckBox burn = ViewBindings.findChildViewById(rootView, id);
      if (burn == null) {
        break missingId;
      }

      FrameLayout calculator = (FrameLayout) rootView;

      id = R.id.compost;
      CheckBox compost = ViewBindings.findChildViewById(rootView, id);
      if (compost == null) {
        break missingId;
      }

      id = R.id.dairy;
      CheckBox dairy = ViewBindings.findChildViewById(rootView, id);
      if (dairy == null) {
        break missingId;
      }

      id = R.id.fruit;
      CheckBox fruit = ViewBindings.findChildViewById(rootView, id);
      if (fruit == null) {
        break missingId;
      }

      id = R.id.grains;
      CheckBox grains = ViewBindings.findChildViewById(rootView, id);
      if (grains == null) {
        break missingId;
      }

      id = R.id.home;
      RangeSlider home = ViewBindings.findChildViewById(rootView, id);
      if (home == null) {
        break missingId;
      }

      id = R.id.litter;
      CheckBox litter = ViewBindings.findChildViewById(rootView, id);
      if (litter == null) {
        break missingId;
      }

      id = R.id.meat;
      CheckBox meat = ViewBindings.findChildViewById(rootView, id);
      if (meat == null) {
        break missingId;
      }

      id = R.id.members;
      EditText members = ViewBindings.findChildViewById(rootView, id);
      if (members == null) {
        break missingId;
      }

      id = R.id.processed;
      CheckBox processed = ViewBindings.findChildViewById(rootView, id);
      if (processed == null) {
        break missingId;
      }

      id = R.id.three_r;
      CheckBox threeR = ViewBindings.findChildViewById(rootView, id);
      if (threeR == null) {
        break missingId;
      }

      id = R.id.veg;
      CheckBox veg = ViewBindings.findChildViewById(rootView, id);
      if (veg == null) {
        break missingId;
      }

      id = R.id.waste;
      Slider waste = ViewBindings.findChildViewById(rootView, id);
      if (waste == null) {
        break missingId;
      }

      id = R.id.work;
      RangeSlider work = ViewBindings.findChildViewById(rootView, id);
      if (work == null) {
        break missingId;
      }

      return new ActivityCalculatorBinding((FrameLayout) rootView, bin, burn, calculator, compost,
          dairy, fruit, grains, home, litter, meat, members, processed, threeR, veg, waste, work);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
