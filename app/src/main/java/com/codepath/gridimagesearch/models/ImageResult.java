package com.codepath.gridimagesearch.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;


public class ImageResult implements Serializable {

    public String fullUrl;
    public String thumbUrl;
    public String title;
    private static final long serialVersionUID = -203940993949039L;

    // new image result with raw json
    public ImageResult(JSONObject json)
    {
        try {
            fullUrl = json.getString("url");
            thumbUrl = json.getString("tbUrl");
            title = json.getString("title");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // take an array of json images and return array list of image results
    // new image results with json array
    public static ArrayList<ImageResult> fromJSONArray(JSONArray array) {
        ArrayList<ImageResult> results = new ArrayList<ImageResult>();
        for( int i=0; i < array.length(); i++)
        {
            try {
                results.add(new ImageResult(array.getJSONObject(i)));

            } catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
        return  results;

    }



}
