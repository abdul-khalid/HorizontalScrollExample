package com.example.abdulkhalid.horizontalscrollexample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    LinearLayout myGallery;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.scrollView_layout);
        Button newButton1 = new Button(this);
        Button newButton2 = new Button(this);
        newButton1.setText("MyButton1");
        newButton2.setText("MyButton2");
        linearLayout.addView(newButton1, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(newButton2, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        LinearLayout row = new LinearLayout(this);
        row.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        Button btnTag = new Button(this);
        btnTag.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.WRAP_CONTENT, AbsListView.LayoutParams.WRAP_CONTENT));
        btnTag.setText("Button 1");
        //btnTag.setId(1);
        row.addView(btnTag);
        linearLayout.addView(row);


        Bitmap bitmapOrg = BitmapFactory.decodeResource(getResources(),
                R.drawable.profile);
        int width = bitmapOrg.getWidth();
        int height = bitmapOrg.getHeight();
        int newWidth = 500;
        int newHeight = 500;

        // calculate the scale - in this case = 0.4f
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        // createa matrix for the manipulation
        Matrix matrix = new Matrix();
        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);
        // rotate the Bitmap
        //matrix.postRotate(45);

        // recreate the new Bitmap
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmapOrg, 0, 0,
                width, height, matrix, true);

        // make a Drawable from Bitmap to allow to set the BitMap
        // to the ImageView, ImageButton or what ever
        BitmapDrawable bmd = new BitmapDrawable(resizedBitmap);

        ImageView imageView = new ImageView(this);

        // set the Drawable on the ImageView
        imageView.setImageDrawable(bmd);

        // center the Image
        imageView.setScaleType(ImageView.ScaleType.CENTER);

        // add ImageView to the Layout
        linearLayout.addView(imageView,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT
                )
        );


        // myGallery = (LinearLayout) findViewById(R.id.mygallery);

//
//        String targetPath = Environment.getExternalStorageDirectory().getAbsolutePath();
//
//        Toast.makeText(getApplicationContext(), targetPath, Toast.LENGTH_LONG).show();
//        File targetDirector = new File(targetPath);
        /*
        File[] files = targetDirector.listFiles();
        for (File file : files) {
            myGallery.addView(insertPhoto(file.getAbsolutePath()));
        }
//        */
//        myGallery.addView(insertPhoto(R.drawable.profile));
//        myGallery.addView(insertPhoto("R.drawable.profile1"));
//        myGallery.addView(insertPhoto("R.drawable.img1.jpg"));
//        myGallery.addView(insertPhoto("R.drawable.img3.jpg"));
//        myGallery.addView(insertPhoto("R.drawable.img2"));
//

    }

//    View insertPhoto(draw path) {
//        //Bitmap bm = decodeSampledBitmapFromUri(path, 220, 220);
//
//        LinearLayout layout = new LinearLayout(getApplicationContext());
//        layout.setLayoutParams(new LayoutParams(250, 250));
//        layout.setGravity(Gravity.CENTER);
//
//        ImageView imageView = new ImageView(getApplicationContext());
//        imageView.setLayoutParams(new LayoutParams(220, 220));
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        imageView.setImageDrawable(path);
//
//        layout.addView(imageView);
//        return layout;
//    }

//    public Bitmap decodeSampledBitmapFromUri(String path, int reqWidth, int reqHeight) {
//        Bitmap bm = null;
//
//        // First decode with inJustDecodeBounds=true to check dimensions
//        final BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeFile(path, options);
//
//        // Calculate inSampleSize
//        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
//
//        // Decode bitmap with inSampleSize set
//        options.inJustDecodeBounds = false;
//        bm = BitmapFactory.decodeFile(path, options);
//
//        return bm;
//    }
//
//    public int calculateInSampleSize(
//
//            BitmapFactory.Options options, int reqWidth, int reqHeight) {
//        // Raw height and width of image
//        final int height = options.outHeight;
//        final int width = options.outWidth;
//        int inSampleSize = 1;
//
//        if (height > reqHeight || width > reqWidth) {
//            if (width > height) {
//                inSampleSize = Math.round((float) height / (float) reqHeight);
//            } else {
//                inSampleSize = Math.round((float) width / (float) reqWidth);
//            }
//        }
//
//        return inSampleSize;
//    }

}