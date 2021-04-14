package com.example.assigment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.assigment.adapter.NewsAdapter;
import com.example.assigment.model.News;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {
    List<News> danhsachList = new ArrayList<>();
    NewsAdapter newsAdapter;
    ListView lvList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle("NEWS");

        danhsachList = new ArrayList<>();
        lvList = findViewById(R.id.lvNews);
        final String name = "https://giaoducthoidai.vn/rss/giao-duc.rss";
        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try {

                    URL url = new URL(name);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    //khởi tạo dối tượng parser
                    XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
                    xmlPullParserFactory.setNamespaceAware(false);

                    XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();
                    xmlPullParser.setInput(inputStream,"utf-8");

                    int evenType = xmlPullParser.getEventType();
                    News news = null;
                    String Text ="";
                    while (evenType!= XmlPullParser.END_DOCUMENT){
                        String tag = xmlPullParser.getName();
                        switch (evenType){
                            case  XmlPullParser.START_TAG:
                                if (tag.equalsIgnoreCase("item")){
                                    news = new News();
                                }
                                break;
                            case XmlPullParser.TEXT:
                                Text = xmlPullParser.getText();

                                break;
                            case XmlPullParser.END_TAG:
                                if (news!= null){
                                    if (tag.equalsIgnoreCase("title")){
                                        news.title = Text;
                                    }
                                    if (tag.equalsIgnoreCase("description")){
                                        news.description = Text;

                                    }
                                    if (tag.equalsIgnoreCase("link")){
                                        news.link = Text;
                                    }
                                    if (tag.equalsIgnoreCase("item")){
                                        danhsachList.add(news);
                                    }
                                }
                                break;
                        }
                        evenType=xmlPullParser.next();

                    }

                }catch ( MalformedURLException e){
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();}
                catch (XmlPullParserException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                newsAdapter = new NewsAdapter(NewsActivity.this,danhsachList);
                lvList.setAdapter(newsAdapter);
                Log.e("Kích thước: ",""+danhsachList.size());
                super.onPostExecute(o);
            }
        };
        //start thread
        asyncTask.execute();
    }
}
