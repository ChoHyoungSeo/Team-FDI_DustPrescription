package com.cookandroid.registration;

import android.os.StrictMode;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.URL;

public class ApiParsing {

    boolean indataTime = false, inpm10Value = false, inpm25Value = false, inpm10Grade = false
            ,inpm25Grade = false, initem = false;

    String dataTime = null, pm10Value = null, pm25Value = null, pm10Grade = null,pm25Grade = null;

    public Item Apiupdate (){

        StrictMode.enableDefaults();
        Item item = new Item();

        try{
            URL url = new URL("http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?"
                    +"stationName=강서구&dataTerm=month&pageNo=1&numOfRows=10&ServiceKey="
                    +"4mAPrFWRnG4ZBGzWUvRRwCoJNTDotde8GxqUd3G1LaZvnlEK3G35JttF9SFiK0VNSV8p76itFIdkVLgjCIkFxg%3D%3D&ver=1.3"
            );
            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();
            parser.setInput(url.openStream(), null);

            int parserEvent = parser.getEventType();

            while (true){
                if (parserEvent == XmlPullParser.END_TAG && parser.getName().equals("item")){
                    break;
                }
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
                        break;
                    case XmlPullParser.TEXT:
                        if(indataTime){
                            dataTime = parser.getText();
                            item.setDataTime(dataTime);
                            indataTime = false;
                        }
                        if(inpm10Value){
                            pm10Value = parser.getText();
                            item.setPm10Value(pm10Value);
                            inpm10Value= false;
                        }
                        if(inpm25Value){
                            pm25Value = parser.getText();
                            item.setPm25Value(pm25Value);
                            inpm25Value = false;
                        }
                        if(inpm10Grade){
                            pm10Grade = parser.getText();
                            item.setPm10Grade(pm10Grade);
                            inpm10Grade = false;
                        }
                        if(inpm25Grade){
                            pm25Grade = parser.getText();
                            item.setPm25Grade(pm25Grade);
                            inpm25Grade = false;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if(parser.getName().equals("item")){
                            initem = false;
                        }
                        break;
                }
                parserEvent = parser.next();
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
        return item;
    }
}
