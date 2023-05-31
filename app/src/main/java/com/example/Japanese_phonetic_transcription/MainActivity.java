package com.example.Japanese_phonetic_transcription;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tv,tv2;
    Button button,button2,button3;
    EditText editText;
    static String[] HIRAGANA = {"あ", "い", "う", "え", "お", "か", "き", "く", "け", "こ", "さ", "し", "す", "せ", "そ", "た", "ち", "つ", "て", "と", "な", "に", "ぬ", "ね", "の", "は", "ひ", "ふ", "へ", "ほ", "ま", "み", "む", "め", "も", "や", "ゆ", "よ", "ら", "り", "る", "れ", "ろ", "わ", "を", "ん"};
    static String[] KATAKANA = {"ア", "イ", "ウ", "エ", "オ", "カ", "キ", "ク", "ケ", "コ", "サ", "シ", "ス", "セ", "ソ", "タ", "チ", "ツ", "テ", "ト", "ナ", "ニ", "ヌ", "ネ", "ノ", "ハ", "ヒ", "フ", "ヘ", "ホ", "マ", "ミ", "ム", "メ", "モ", "ヤ", "ユ", "ヨ", "ラ", "リ", "ル", "レ", "ロ", "ワ", "ヲ", "ン"};
    static String[] ROMAJI = {"a", "i", "u", "e", "o", "ka", "ki", "ku", "ke", "ko", "sa", "shi", "su", "se", "so", "ta", "chi", "tsu", "te", "to", "na", "ni", "nu", "ne", "no", "ha", "hi", "fu", "he", "ho", "ma", "mi", "mu", "me", "mo", "ya", "yu", "yo", "ra", "ri", "ru", "re", "ro", "wa", "wo", "n"};
    static int kill = 0;
    int n = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        tv=findViewById(R.id.textView);
        tv2=findViewById(R.id.textView2);
        button3=findViewById(R.id.button3);
        editText=findViewById(R.id.editTextTextPersonName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInputa=editText.getText().toString();
                if(is_number(userInputa)&&!userInputa.isEmpty())
                {
                    try {
                        //这里的ROMAJI.length更改为根据玩家想要的音作为截至标位置
                        if (n >= 0 && n < kill) {
                            Random RANDOM = new Random();
                            int randomIndex = RANDOM.nextInt(kill);
                            tv.setText(ROMAJI[randomIndex]);
                            n = randomIndex;
                        } else {
                            Toast.makeText(MainActivity.this, "请输入有效的音标截至范围！"+kill, Toast.LENGTH_SHORT).show();
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "未知错误", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(HIRAGANA[n]);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(HIRAGANA[n]+KATAKANA[n]);
            }
        });
        Button button4=findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //这里的ROMAJI.length更改为根据玩家想要的音作为截至标位置
                    if (n >= 0 && n < kill) {
                        Random RANDOM = new Random();
                        int randomIndex = RANDOM.nextInt(kill);
                        tv2.setText(HIRAGANA[randomIndex]);
                        n = randomIndex;
                    } else {
                        Toast.makeText(MainActivity.this, "请输入有效的音标截至范围！"+kill, Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "未知错误", Toast.LENGTH_SHORT).show();

                }

            }
        });
        Button button5=findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //这里的ROMAJI.length更改为根据玩家想要的音作为截至标位置
                    if (n >= 0 && n < kill) {
                        Random RANDOM = new Random();
                        int randomIndex = RANDOM.nextInt(kill);
                        tv2.setText(KATAKANA[randomIndex]);
                        n = randomIndex;
                    } else {
                        Toast.makeText(MainActivity.this, "请输入有效的音标截至范围！"+kill, Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "未知错误", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
    static boolean is_number(String userInput) {
        boolean a = false;
        for (int m = 0; m < ROMAJI.length; m++) {
            if (userInput.equals(ROMAJI[m])) {
                kill = m;
                a = true;
                return a;
            }
        }
        return a;
    }
}