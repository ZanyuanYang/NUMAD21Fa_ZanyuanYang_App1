package com.example.numad21fa_zanyuanyang;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebServiceActivity extends AppCompatActivity {

    TextView companyTV, priceTV, todayChangeTV, yearToDateTV;
    Button submitBtn, clearBtn;
    ImageView stockImg;
    EditText symbolInputET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_service);

        companyTV = (TextView) findViewById(R.id.company);
        submitBtn = (Button) findViewById(R.id.submit);
        priceTV = (TextView) findViewById(R.id.price);
        todayChangeTV = (TextView) findViewById(R.id.todayChange);
        yearToDateTV = (TextView) findViewById(R.id.yearToDate);
//        stockImg= (ImageView) findViewById(R.id.stockImg);
        symbolInputET = (EditText) findViewById(R.id.symbolInput);
        clearBtn = (Button) findViewById(R.id.clear);
        clearBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                symbolInputET.setText("");
            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String urlLink = symbolInputET.getText().toString();
                if(urlLink.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please Enter symbol!!!", Toast.LENGTH_SHORT).show();
                }else{
                    new webData(urlLink).execute();
                }
//                new ImageLoadTask("https://img1.baidu.com/it/u=1309084089,1051308921&fm=26&fmt=auto", stockImg).execute();

            }
        });
    }

    public class webData extends AsyncTask<Void, Void, Void> {
        String company, price, todayChange, yearToDate, stockImg1;

        private String symbol;

        public webData(String symbol) {
            this.symbol = symbol;
        }

        @Override
        protected Void doInBackground(Void... params){

            try{
                Document doc = Jsoup.connect("https://money.cnn.com/quote/quote.html?symb=" + this.symbol).get();

                Elements companyClass = doc.getElementsByClass("wsod_fLeft");
                String splitCompanyClass[] = companyClass.text().split("\\(", 2);
                company = splitCompanyClass[0];

                Elements priceClass = doc.getElementsByClass("wsod_last");
                String splitPriceClass[] = priceClass.text().split(" ", 2);
                price = splitPriceClass[0];

                Elements todayChangeClass = doc.getElementsByClass("wsod_change");
                String splitTodayChangeClass[] = todayChangeClass.text().split(" ", 5);
                todayChange = splitTodayChangeClass[0] + " " + splitTodayChangeClass[1] + " " + splitTodayChangeClass[2];

                Elements yearToDateClass = doc.getElementsByClass("wsod_ytd");
                String splitYTDChangeClass[] = yearToDateClass.text().split(" ", 2);
                yearToDate = splitYTDChangeClass[0];


                Element stockImgClass = doc.getElementById("wsod_companyChart");
                Elements stockImgLink = stockImgClass.getElementsByTag("img");
                Element image = stockImgLink.select("img").first();
                stockImg1 = image.attr("abs:src");



            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            companyTV.setText(company);
            priceTV.setText(price);
            todayChangeTV.setText(todayChange);
            yearToDateTV.setText(yearToDate);
//            stockImg.setImageBitmap(getBitmapFromURL(url));

        }


    }
}
