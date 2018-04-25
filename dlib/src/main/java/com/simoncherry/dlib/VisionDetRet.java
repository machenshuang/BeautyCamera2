/*
*  Copyright (C) 2015 TzuTaLin
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.simoncherry.dlib;

/**
 * Created by Tzutalin on 2015/10/20.
 */

import android.graphics.Point;

import java.util.ArrayList;

/**
 * A VisionDetRet contains all the information identifying the location and confidence value of the detected object in a bitmap.
 */
public final class VisionDetRet {
    private String mLabel;
    private float mConfidence;
    private int mLeft;
    private int mTop;
    private int mRight;
    private int mBottom;
    private ArrayList<Point> mLandmarkPoints = new ArrayList<>();
    // TODO add by simon at 2017/05/01
    private ArrayList<Point> mPosePoints = new ArrayList<>();
    // TODO add by simon at 2017/05/04
    private ArrayList<Float> mRotate = new ArrayList<>();
    // TODO add by simon at 2017/05/07
    private ArrayList<Float> mTrans = new ArrayList<>();
    private ArrayList<Double> mRotation = new ArrayList<>();

    VisionDetRet() {
    }

    /**
     * @param label      Label name
     * @param confidence A confidence factor between 0 and 1. This indicates how certain what has been found is actually the label.
     * @param l          The X coordinate of the left side of the result
     * @param t          The Y coordinate of the top of the result
     * @param r          The X coordinate of the right side of the result
     * @param b          The Y coordinate of the bottom of the result
     */
    public VisionDetRet(String label, float confidence, int l, int t, int r, int b) {
        mLabel = label;
        mLeft = l;
        mTop = t;
        mRight = r;
        mBottom = b;
        mConfidence = confidence;
    }

    /**
     * @return The X coordinate of the left side of the result
     */
    public int getLeft() {
        return mLeft;
    }

    /**
     * @return The Y coordinate of the top of the result
     */
    public int getTop() {
        return mTop;
    }

    /**
     * @return The X coordinate of the right side of the result
     */
    public int getRight() {
        return mRight;
    }

    /**
     * @return The Y coordinate of the bottom of the result
     */
    public int getBottom() {
        return mBottom;
    }

    /**
     * @return A confidence factor between 0 and 1. This indicates how certain what has been found is actually the label.
     */
    public float getConfidence() {
        return mConfidence;
    }

    /**
     * @return The label of the result
     */
    public String getLabel() {
        return mLabel;
    }

    /**
     * Add landmark to the list. Usually, call by jni
     * @param x Point x
     * @param y Point y
     * @return true if adding landmark successfully
     */
    public boolean addLandmark(int x, int y) {
        return mLandmarkPoints.add(new Point(x, y));
    }

    /**
     * Return the list of landmark points
     * @return ArrayList of android.graphics.Point
     */
    public ArrayList<Point> getFaceLandmarks() {
        return mLandmarkPoints;
    }

    public boolean addPosePoint(int x, int y) {
        return  mPosePoints.add(new Point(x, y));
    }

    public ArrayList<Point> getPosePoints() {
        return mPosePoints;
    }

    public boolean addRotate(float r) {
        return mRotate.add(r);
    }

    public ArrayList<Float> getRotate() {
        return mRotate;
    }

    public boolean addTrans(float t) {
        return mTrans.add(t);
    }

    public ArrayList<Float> getTrans() {
        return mTrans;
    }

    public boolean addRotation(double d) {
        return mRotation.add(d);
    }

    public ArrayList<Double> getRotation() {
        return mRotation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Left:");
        sb.append(mLeft);
        sb.append(", Top:");
        sb.append(mTop);
        sb.append(", Right:");
        sb.append(mRight);
        sb.append(", Bottom:");
        sb.append(mBottom);
        sb.append(", Label:");
        sb.append(mLabel);
        return sb.toString();
    }
}
