// Generated by view binder compiler. Do not edit!
package com.example.kaspi.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.kaspi.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentDocumentsBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final Button btnAddDocument;

  @NonNull
  public final RecyclerView rvDocumentsList;

  @NonNull
  public final TextView tvDocumentsHeader;

  @NonNull
  public final TextView tvNoDocumentsMessage;

  private FragmentDocumentsBinding(@NonNull ScrollView rootView, @NonNull Button btnAddDocument,
      @NonNull RecyclerView rvDocumentsList, @NonNull TextView tvDocumentsHeader,
      @NonNull TextView tvNoDocumentsMessage) {
    this.rootView = rootView;
    this.btnAddDocument = btnAddDocument;
    this.rvDocumentsList = rvDocumentsList;
    this.tvDocumentsHeader = tvDocumentsHeader;
    this.tvNoDocumentsMessage = tvNoDocumentsMessage;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDocumentsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDocumentsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_documents, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDocumentsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAddDocument;
      Button btnAddDocument = ViewBindings.findChildViewById(rootView, id);
      if (btnAddDocument == null) {
        break missingId;
      }

      id = R.id.rvDocumentsList;
      RecyclerView rvDocumentsList = ViewBindings.findChildViewById(rootView, id);
      if (rvDocumentsList == null) {
        break missingId;
      }

      id = R.id.tvDocumentsHeader;
      TextView tvDocumentsHeader = ViewBindings.findChildViewById(rootView, id);
      if (tvDocumentsHeader == null) {
        break missingId;
      }

      id = R.id.tvNoDocumentsMessage;
      TextView tvNoDocumentsMessage = ViewBindings.findChildViewById(rootView, id);
      if (tvNoDocumentsMessage == null) {
        break missingId;
      }

      return new FragmentDocumentsBinding((ScrollView) rootView, btnAddDocument, rvDocumentsList,
          tvDocumentsHeader, tvNoDocumentsMessage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}