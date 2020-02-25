package com.example.project11_2;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Context;
        import android.graphics.Color;
        import android.media.Image;
        import android.os.Bundle;
        import android.view.MotionEvent;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Adapter;
        import android.widget.AdapterView;
        import android.widget.BaseAdapter;
        import android.widget.Gallery;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터");

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        MyGalleryAdapter galAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galAdapter);

    }


    public class MyGalleryAdapter extends BaseAdapter {
        Context context;
        Integer[] posterID = {R.drawable.mov11, R.drawable.mov12,
                R.drawable.mov13, R.drawable.mov14, R.drawable.mov15,
                R.drawable.mov16, R.drawable.mov17, R.drawable.mov18,
                R.drawable.mov19, R.drawable.mov20
        };
        String[] posterName = {"여인의 향기", "쥬라기 공원", "포레스트 검프",
                "사랑의 블랙홀", "혹성탈출", "아름다운 비행", "내 이름은 칸",
                "해리포터와 죽음의 성물 2", "마더", "킹콩을 들다"
        };

        public MyGalleryAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new Gallery.LayoutParams(100, 150));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5, 5, 5);

            imageview.setImageResource(posterID[position]);

            final int pos = position;
            imageview.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterID[pos]);

                    Toast toast = new Toast(MainActivity.this);
                    View toastView = (View) View.inflate(MainActivity.this,
                            R.layout.toast, null);
                    TextView toastText = (TextView) toastView.findViewById(R.id.toastTv1);
                    toastText.setText(posterName[pos]);
                    toastText.setTextColor(Color.WHITE);
                    toast.setView(toastView);
                    toast.show();
                    return false;
                }
            });

            return imageview;
        }
    }
}
