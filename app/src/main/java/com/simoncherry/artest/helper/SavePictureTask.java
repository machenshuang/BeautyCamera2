package com.simoncherry.artest.helper;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by SeanMa on 2018/4/22.
 */
public class SavePictureTask extends AsyncTask<Bitmap, Integer, String> {
    private OnPictureSaveListener onPictureSaveListener;
    private File file;

    public SavePictureTask(File file, OnPictureSaveListener listener){
        this.onPictureSaveListener = listener;
        this.file = file;
    }


    @Override
    protected String doInBackground(Bitmap... bitmaps) {
        if(file == null)
            return null;
        return saveBitmap(bitmaps[0]);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    private String saveBitmap(Bitmap bitmap) {
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
            bitmap.recycle();
            return file.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public interface OnPictureSaveListener{
        void onSaved(String result);
    }
}
