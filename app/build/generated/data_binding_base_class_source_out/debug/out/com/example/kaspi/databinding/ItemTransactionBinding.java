// Generated by view binder compiler. Do not edit!
package com.example.kaspi.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.kaspi.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemTransactionBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView transactionAmountTextView;

  @NonNull
  public final TextView transactionDateTextView;

  @NonNull
  public final TextView transactionTypeTextView;

  private ItemTransactionBinding(@NonNull CardView rootView,
      @NonNull TextView transactionAmountTextView, @NonNull TextView transactionDateTextView,
      @NonNull TextView transactionTypeTextView) {
    this.rootView = rootView;
    this.transactionAmountTextView = transactionAmountTextView;
    this.transactionDateTextView = transactionDateTextView;
    this.transactionTypeTextView = transactionTypeTextView;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemTransactionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemTransactionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_transaction, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemTransactionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.transactionAmountTextView;
      TextView transactionAmountTextView = ViewBindings.findChildViewById(rootView, id);
      if (transactionAmountTextView == null) {
        break missingId;
      }

      id = R.id.transactionDateTextView;
      TextView transactionDateTextView = ViewBindings.findChildViewById(rootView, id);
      if (transactionDateTextView == null) {
        break missingId;
      }

      id = R.id.transactionTypeTextView;
      TextView transactionTypeTextView = ViewBindings.findChildViewById(rootView, id);
      if (transactionTypeTextView == null) {
        break missingId;
      }

      return new ItemTransactionBinding((CardView) rootView, transactionAmountTextView,
          transactionDateTextView, transactionTypeTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
