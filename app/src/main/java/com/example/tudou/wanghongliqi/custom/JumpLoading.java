package com.example.tudou.wanghongliqi.custom;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

/**
 * 加载中控件 圆点跳跃
 */
public class JumpLoading extends BaseLoad {

    private Paint mPaint;

    private float mWidth = 0f;
    private float mHigh = 0f;
    private float mMaxRadius = 6;
    private int circularCount = 5;
    private float mAnimatedValue = 0f;
    private int mJumpValue = 0;

    public JumpLoading(Context context) {
        super(context);
    }

    public JumpLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public JumpLoading(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHigh = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float circularX = mWidth / circularCount;

        for (int i = 0; i < circularCount; i++) {
            if (i == mJumpValue % circularCount) {
                canvas.drawCircle(i * circularX + circularX / 2f,
                        mHigh * 2 / 3 - mHigh * 2 / 3 * mAnimatedValue, mMaxRadius, mPaint);
            } else {
                canvas.drawCircle(i * circularX + circularX / 2f,
                        mHigh * 2 / 3, mMaxRadius, mPaint);
            }
        }
    }

    @Override
    protected void InitPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
    }

    public void setViewColor(int color) {
        mPaint.setColor(color);
        postInvalidate();
    }

    @Override
    protected void OnAnimationUpdate(ValueAnimator valueAnimator) {
        mAnimatedValue = (float) valueAnimator.getAnimatedValue();
        if (mAnimatedValue > 0.5) {
            mAnimatedValue = 1 - mAnimatedValue;
        }
        invalidate();
    }

    @Override
    protected void OnAnimationRepeat(Animator animation) {
        mJumpValue++;
    }

    @Override
    protected int SetAnimRepeatMode() {
        return ValueAnimator.RESTART;
    }

    @Override
    protected int SetAnimRepeatCount() {
        return ValueAnimator.INFINITE;
    }

    @Override
    protected int OnStopAnim() {
        mAnimatedValue = 0f;
        mJumpValue = 0;
        return 0;
    }

    @Override
    protected void AnimIsRunning() {}
}
