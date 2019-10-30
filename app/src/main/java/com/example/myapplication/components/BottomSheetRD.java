package com.example.myapplication.components;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.recyclerview.SingleAdapterRD;
import com.example.myapplication.recyclerview.base.OnItemClickRownRecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class BottomSheetRD extends BottomSheetDialog {

    private OnClickBottomSheetRD onClickBottomSheetRD;
    private TextView titleView;
    private RecyclerView recyclerView;

    private OnItemClickRownRecyclerView onItemClickBottomSheet;

    public BottomSheetRD(@NonNull Context context) {
        super(context, R.style.BottomSheetDialogTheme);
        setDialogView();
    }

    public BottomSheetRD(@NonNull Context context, OnItemClickRownRecyclerView onItemClickBottomSheet) {
        super(context, R.style.BottomSheetDialogTheme);
        this.onItemClickBottomSheet = onItemClickBottomSheet;
        setDialogView();
    }

    public BottomSheetRD(@NonNull Context context, OnClickBottomSheetRD onClickBottomSheetRD) {
        super(context, R.style.BottomSheetDialogTheme);
        this.onClickBottomSheetRD = onClickBottomSheetRD;
        setDialogView();
    }

    private void setDialogView() {
        View bottomSheetView = getLayoutInflater().inflate(R.layout.view_bottom_sheet, null);
        setContentView(bottomSheetView);

        Button btnEntrar = findViewById(R.id.btn_entrar);
        Button btnSair = findViewById(R.id.btn_sair);

        titleView = findViewById(R.id.txt_title_bottom_sheet);
        recyclerView = findViewById(R.id.rcv_bottom_sheet_custom);

        if (onClickBottomSheetRD != null) {
            btnEntrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickBottomSheetRD.onSelected();
                }
            });

            btnSair.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickBottomSheetRD.onClose();
                }
            });
        }

    }


    public void setTitle(String title) {
        titleView.setText(title);
    }

    public <T> void setRecyclerViewList(List<T> list) {
        SingleAdapterRD singleAdapterRD = new SingleAdapterRD(R.layout.item_textview_layout, list, onItemClickBottomSheet);
        recyclerView.setAdapter(singleAdapterRD);
    }

}
