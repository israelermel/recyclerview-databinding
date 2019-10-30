package com.example.myapplication.components;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.recyclerview.OnItemClick;
import com.example.myapplication.recyclerview.SingleAdapterListenerRD;
import com.example.myapplication.recyclerview.base.OnItemClickRownRecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class BottomSheetRD<T> extends BottomSheetDialog implements View.OnClickListener {

    private OnItemClickRownRecyclerView onClickBottomSheetRD;
    private TextView titleView;
    private RecyclerView recyclerView;

    private OnItemClick<T> onItemClickBottomSheet;

    public BottomSheetRD(@NonNull Context context) {
        super(context, R.style.BottomSheetDialogTheme);
        setDialogView();
    }

    public BottomSheetRD(@NonNull Context context, OnItemClick<T> onItemClickBottomSheet) {
        super(context, R.style.BottomSheetDialogTheme);
        this.onItemClickBottomSheet = onItemClickBottomSheet;
        setDialogView();
    }

    public BottomSheetRD(@NonNull Context context, OnItemClickRownRecyclerView onClickBottomSheetRD) {
        super(context, R.style.BottomSheetDialogTheme);
        this.onClickBottomSheetRD = onClickBottomSheetRD;
        setDialogView();
    }

    private void setDialogView() {
        View bottomSheetView = getLayoutInflater().inflate(R.layout.view_bottom_sheet, null);
        setContentView(bottomSheetView);

        Button btnEntrar = findViewById(R.id.btn_entrar);
        Button btnSair = findViewById(R.id.btn_sair);
        ImageButton btnClose = findViewById(R.id.btn_close_bottom_sheet_rd);

        titleView = findViewById(R.id.txt_title_bottom_sheet);
        recyclerView = findViewById(R.id.rcv_bottom_sheet_custom);
        btnClose.setOnClickListener(this);

//        if (onClickBottomSheetRD != null) {
//            btnEntrar.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onClickBottomSheetRD.onSelected();
//                }
//            });
//
//            btnSair.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onClickBottomSheetRD.onClose();
//                }
//            });
//        }


    }


    public void setTitle(String title) {
        titleView.setText(title);
    }

    public void setRecyclerViewList(List<T> list) {
        SingleAdapterListenerRD singleAdapterRD = new SingleAdapterListenerRD(R.layout.item_textview_layout, list, onItemClickBottomSheet);
        recyclerView.setAdapter(singleAdapterRD);
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }
}
