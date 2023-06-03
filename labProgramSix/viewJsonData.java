package com.example.labprogramsix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;
import org.w3c.dom.Element;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class viewJsonData extends AppCompatActivity {
    String fileName="Input.json";
    String fileName2="Input.xml";
    String FinalData="";

    TextView textView;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_json_data);
        textView2=findViewById(R.id.txtJsonDataHolder);
        textView=findViewById(R.id.xmlDataHolder);
        Intent intent=getIntent();
        int type=intent.getIntExtra("Type",0);
        if(type==1){
            try{
                InputStream inputStream=getAssets().open(fileName2);
                // Load the XML file
                DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
                DocumentBuilder builder=factory.newDocumentBuilder();
                Document document=builder.parse(inputStream);

                // Load the XML file
                Element root = document.getDocumentElement();
                // Access the employee element
                Element employeeElement = (Element) root.getElementsByTagName("employee").item(0);

                FinalData+="City_Name : "+employeeElement.getElementsByTagName("City_Name").item(0).getTextContent()+"\n\n"+
                        "Latitude : "+employeeElement.getElementsByTagName("Latitude").item(0).getTextContent()+"\n\n"+
               "Longitude : "+employeeElement.getElementsByTagName("Longitude").item(0).getTextContent()+"\n\n"+
               "Temperature : "+ employeeElement.getElementsByTagName("Temperature").item(0).getTextContent()+"\n\n"+
                "Humidity : "+employeeElement.getElementsByTagName("Humidity").item(0).getTextContent();
                textView.setText(FinalData);
            }catch (Exception e){
                textView.setText(e.getMessage());
            }
        }

        //JSON DATA HANDLING
        if(type==2) {
            //trying to read theJSON DATA //
            try {
               //opening the json file
                InputStream inputStream = getAssets().open(fileName);
                //reading the Json
                int size = inputStream.available();
                byte[] buffer = new byte[size];
                inputStream.read(buffer);
                inputStream.close();

                String jsonData = new String(buffer, "UTF-8");
                JSONObject jsonObject = new JSONObject(jsonData);
                //creating an iterator
                Iterator<String> keys = jsonObject.getJSONObject("employee").keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    String value = jsonObject.getJSONObject("employee").getString(key);
                    FinalData += key + " : " + value + "\n\n";
                }
                textView2.setText(FinalData);
            } catch (Exception e) {
                textView2.setText(e.getMessage());
            }
        }
    }
}