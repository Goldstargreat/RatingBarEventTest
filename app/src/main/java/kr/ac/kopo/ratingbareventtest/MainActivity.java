package kr.ac.kopo.ratingbareventtest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    // 전역 변수 선언
    RatingBar rating1, rating2, rating3;
    Button btnInc, btnDec;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. 뷰 바인딩 (앞에 'Button' 타입을 빼고 전역 변수에 그대로 대입)
        rating1 = findViewById(R.id.rating1);
        rating2 = findViewById(R.id.rating2);
        rating3 = findViewById(R.id.rating3);
        btnInc = findViewById(R.id.btn_inc);
        btnDec = findViewById(R.id.btn_dec);

        // 2. 증가 버튼 이벤트 설정 (람다식으로 깔끔하게 처리)
        btnInc.setOnClickListener(v -> {
            rating1.setRating(rating1.getRating() + rating1.getStepSize());
            rating2.setRating(rating2.getRating() + rating2.getStepSize());
            rating3.setRating(rating3.getRating() + rating3.getStepSize());
        });

        // 3. 감소 버튼 이벤트 설정 (btnDec로 올바르게 수정)
        btnDec.setOnClickListener(v -> {
            rating1.setRating(rating1.getRating() - rating1.getStepSize());
            rating2.setRating(rating2.getRating() - rating2.getStepSize());
            rating3.setRating(rating3.getRating() - rating3.getStepSize());
        });
    }
}