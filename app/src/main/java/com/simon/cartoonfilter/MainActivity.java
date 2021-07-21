package com.simon.cartoonfilter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickCancel;
import com.vansuita.pickimage.listeners.IPickResult;
import com.zomato.photofilters.SampleFilters;
import com.zomato.photofilters.geometry.Point;
import com.zomato.photofilters.imageprocessors.Filter;
import com.zomato.photofilters.imageprocessors.subfilters.BrightnessSubFilter;
import com.zomato.photofilters.imageprocessors.subfilters.ContrastSubFilter;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    static
    {
        System.loadLibrary("NativeImageProcessor");
    }

    ImageView MainImage,share,download;
    CardView filter1,filter2,filter3,filter4,filter5,filter6;
    Bitmap originalBitmap;
    LinearLayout linearLayout;
    HorizontalScrollView horizontalScrollView;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainImage = findViewById(R.id.main_image);
        getSupportActionBar().hide();
        share =findViewById(R.id.share);
        download = findViewById(R.id.download);
        linearLayout = findViewById(R.id.MyLayout);
        linearLayout.setVisibility(View.INVISIBLE);
        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.Sumbua);
        horizontalScrollView.setVisibility(View.INVISIBLE);
        tv = findViewById(R.id.tv);


        filter1 = findViewById(R.id.filter1);
        filter2 = findViewById(R.id.filter2);
        filter3 = findViewById(R.id.filter3);
        filter4 = findViewById(R.id.filter4);
        filter5 = findViewById(R.id.filter5);
        filter6 = findViewById(R.id.filter6);

//        BitmapDrawable bitmapDrawable = (BitmapDrawable) MainImage.getDrawable();
//        originalBitmap = bitmapDrawable.getBitmap();



        filter1.setOnClickListener(this);
        filter2.setOnClickListener(this);
        filter3.setOnClickListener(this);
        filter4.setOnClickListener(this);
        filter5.setOnClickListener(this);
        filter6.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.filter1:
                Filter myFilter = new Filter();
                myFilter.addSubFilter(new BrightnessSubFilter(30));
                myFilter.addSubFilter(new ContrastSubFilter(1.1f));
                Bitmap image = originalBitmap.copy(Bitmap.Config.ARGB_8888,true);
                Bitmap outputImage = myFilter.processFilter(image);
                MainImage.setImageBitmap(outputImage);
                break;
            case R.id.filter2:
                Filter myFilter2 = SampleFilters.getBlueMessFilter();
                Bitmap image2 = originalBitmap.copy(Bitmap.Config.ARGB_8888,true);
                Bitmap outputImage2 = myFilter2.processFilter(image2);
                MainImage.setImageBitmap(outputImage2);
                break;
            case R.id.filter3:
                Filter myFilter3 = SampleFilters.getLimeStutterFilter();
                Bitmap image3 = originalBitmap.copy(Bitmap.Config.ARGB_8888,true);
                Bitmap outputImage3 = myFilter3.processFilter(image3);
                MainImage.setImageBitmap(outputImage3);
                break;
            case R.id.filter4:
                Filter myFilter4 = SampleFilters.getNightWhisperFilter();
                Bitmap image4 = originalBitmap.copy(Bitmap.Config.ARGB_8888,true);
                Bitmap outputImage4 = myFilter4.processFilter(image4);
                MainImage.setImageBitmap(outputImage4);
                break;
            case R.id.filter5:
                Filter myFilter5 = SampleFilters.getStarLitFilter();

                Bitmap image5 = originalBitmap.copy(Bitmap.Config.ARGB_8888,true);
                Bitmap outputImage5 = myFilter5.processFilter(image5);
                MainImage.setImageBitmap(outputImage5);
                break;
            case R.id.filter6:
                Filter myFilter6 = SampleFilters.getAweStruckVibeFilter();
                Bitmap image6 = originalBitmap.copy(Bitmap.Config.ARGB_8888,true);
                Bitmap outputImage6 = myFilter6.processFilter(image6);
                MainImage.setImageBitmap(outputImage6);
                break;



        }

    }

    public void Dialog(View view) {
        PickImageDialog.build(new PickSetup())
                .setOnPickResult(new IPickResult() {
                    @Override
                    public void onPickResult(PickResult r) {
                        //TODO: do what you have to...
                        //imageView.setImageBitmap();

                        MainImage.setImageBitmap(r.getBitmap());
                        BitmapDrawable bitmapDrawable = (BitmapDrawable) MainImage.getDrawable();
                        originalBitmap = bitmapDrawable.getBitmap();
                        linearLayout.setVisibility(View.VISIBLE);
                        tv.setVisibility(View.INVISIBLE);
                        horizontalScrollView.setVisibility(View.VISIBLE);
                        share.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Almost there", Toast.LENGTH_SHORT).show();
                            }
                        });
                        download.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Almost there", Toast.LENGTH_SHORT).show();
                            }
                        });
//

                    }
                })
                .setOnPickCancel(new IPickCancel() {
                    @Override
                    public void onCancelClick() {
                        //TODO: do what you have to if user clicked cancel
                    }
                }).show(getSupportFragmentManager());
    }
    private  void FanyaMeneno(){

        BitmapDrawable bitmapDrawable = (BitmapDrawable) MainImage.getDrawable();
        originalBitmap = bitmapDrawable.getBitmap();



    }
}