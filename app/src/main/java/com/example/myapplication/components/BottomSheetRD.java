package com.example.myapplication.components;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.example.myapplication.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BottomSheetRD extends BottomSheetDialog {

    private OnClickBottomSheetRD onClickBottomSheetRD;

    public BottomSheetRD(@NonNull Context context) {
        super(context, R.style.BottomSheetDialogTheme);
        setDialogView();
    }

    public BottomSheetRD(@NonNull Context context, OnClickBottomSheetRD onClickBottomSheetRD) {
        super(context, R.style.BottomSheetDialogTheme);
        this.onClickBottomSheetRD = onClickBottomSheetRD;
        setDialogView();
    }

    public BottomSheetRD(@NonNull Context context, int theme) {
        super(context, theme);
        setDialogView();
    }

    protected BottomSheetRD(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        setDialogView();
    }


    private void setDialogView() {
        View bottomSheetView = getLayoutInflater().inflate(R.layout.view_bottom_sheet, null);
        setContentView(bottomSheetView);

        Button btnEntrar = findViewById(R.id.btn_entrar);
        Button btnSair = findViewById(R.id.btn_sair);

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
