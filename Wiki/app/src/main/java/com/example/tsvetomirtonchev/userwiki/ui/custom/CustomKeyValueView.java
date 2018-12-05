package com.example.tsvetomirtonchev.userwiki.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.tsvetomirtonchev.userwiki.R;

/**
 * Created by tsvetomir.tonchev on 20,Ноември,2018
 */
public class CustomKeyValueView extends ConstraintLayout {

    private TextView mTitleTextView;
    private TextView mValueTextView;
    private int mStyle;
    private float mKeyTextSize;
    private float mValueTextSize;
    private String mTextConfigTag;

    public CustomKeyValueView(Context context) {
        super(context);
        initViews(context);
    }

    public CustomKeyValueView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttributes(context, attrs);
        initViews(context);
    }

    public CustomKeyValueView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttributes(context, attrs);
        initViews(context);
    }

    private void initViews(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View rootView = inflater.inflate(R.layout.view_custom_key_value, this, true);
        mTitleTextView = rootView.findViewById(R.id.title_text_view);
        mValueTextView = rootView.findViewById(R.id.value_text_view);
    }

    private void initAttributes(Context context, AttributeSet attrs) {
        TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.CustomKeyValueView);
        mStyle = values.getInt(R.styleable.CustomKeyValueView_style, 0);
        mKeyTextSize = values.getDimension(R.styleable.CustomKeyValueView_key_text_size, getResources().getDimension(R.dimen.activity_horizontal_margin))
                / getResources().getDisplayMetrics().density;
        mValueTextSize = values.getDimension(R.styleable.CustomKeyValueView_value_text_size, getResources().getDimension(R.dimen.activity_horizontal_margin))
                / getResources().getDisplayMetrics().density;
        mTextConfigTag = values.getString(R.styleable.CustomKeyValueView_text_config_tag);
        values.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mTitleTextView.setTextSize(mKeyTextSize);
        mValueTextView.setTextSize(mValueTextSize);
    }

    public void hideValue() {
        mValueTextView.setVisibility(GONE);
    }

    public void changeTextColor(int color) {
        mTitleTextView.setTextColor(color);
        mValueTextView.setTextColor(color);
    }

    public void changeTitleColor(int color) {
        mTitleTextView.setTextColor(color);
    }

    public String getTitle() {
        return mTitleTextView.getText().toString();
    }

    public void setTitle(CharSequence title) {
        if (!TextUtils.isEmpty(title))
            mTitleTextView.setText(title);
    }

    public String getValue() {
        return mValueTextView.getText().toString();
    }

    public void setValue(CharSequence value) {
        if (!TextUtils.isEmpty(value))
            mValueTextView.setText(value);
    }

    public String getTextConfigTag() {
        return mTextConfigTag;
    }
}