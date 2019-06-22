package com.cookandroid.registration;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.URL;

public class ApiParseEx extends AppCompatActivity {

    boolean indataTime = false, inpm10Value = false, inpm25Value = false, inpm10Grade = false
            ,inpm25Grade = false, initem = false;

    String dataTime = null, pm10Value = null, pm25Value = null, pm10Grade = null,pm25Grade = null;

    TextView status1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apiparseex);
        StrictMode.enableDefaults();

        status1 = (TextView)findViewById(R.id.result);

        try{
            URL url = new URL("http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?"
                    +"stationName=강서구&dataTerm=month&pageNo=1&numOfRows=10&ServiceKey="
                    +"4mAPrFWRnG4ZBGzWUvRRwCoJNTDotde8GxqUd3G1LaZvnlEK3G35JttF9SFiK0VNSV8p76itFIdkVLgjCIkFxg%3D%3D&ver=1.3"
            );
            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();
            parser.setInput(url.openStream(), null);

            int parserEvent = parser.getEventType();

            while (parserEvent != XmlPullParser.END_DOCUMENT){
                switch(parserEvent){
                    case XmlPullParser.START_TAG:
                        if(parser.getName().equals("dataTime")){
                            indataTime = true;
                        }
                        if(parser.getName().equals("pm10Value")){
                            inpm10Value = true;
                        }
                        if(parser.getName().equals("pm25Value")){
                            inpm25Value = true;
                        }
                        if(parser.getName().equals("pm10Grade")){
                            inpm10Grade = true;
                        }
                        if(parser.getName().equals("pm25Grade")){
                            inpm25Grade = true;
                        }
                        if(parser.getName().equals("message")){
                            status1.setText(status1.getText()+"에러");
                        }

                        break;
                    case XmlPullParser.TEXT:
                        if(indataTime){
                            dataTime = parser.getText();
                            indataTime = false;
                        }
                        if(inpm10Value){
                            pm10Value = parser.getText();
                            inpm10Value= false;
                        }
                        if(inpm25Value){
                            pm25Value = parser.getText();
                            inpm25Value = false;
                        }
                        if(inpm10Grade){
                            pm10Grade = parser.getText();
                            inpm10Grade = false;
                        }
                        if(inpm25Grade){
                            pm25Grade = parser.getText();
                            inpm25Grade = false;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if(parser.getName().equals("item")){
                           status1.setText(status1.getText()+"측정시 : " +dataTime +"\n 미세먼지 농도 : " + pm10Value
                                   +"\n 초미세먼지 농도 : " + pm25Value +  "\n 미세먼지 등급 : " +  pm10Grade+ "\n 초미세먼지 등급: " + pm25Grade+"\n");
                            initem = false;
                        }
                        break;
                }
                parserEvent = parser.next();
            }
        }catch (Exception e ){
            e.printStackTrace();
            status1.setText("에러가..났습니다...");
        }
    }
}
