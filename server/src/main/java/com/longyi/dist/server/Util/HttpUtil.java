package com.longyi.dist.server.Util;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by chenglongwei on 11/14/15.
 */
public class HttpUtil {
    public static String httpGet(String path) {
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                response.append(line);
            }
            rd.close();

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String httpPost(String path, Object obj) {
        try {
            URL url = new URL(path);
            String postData;
            if (obj instanceof String) {
                postData = (String) obj;
            } else {
                postData = new Gson().toJson(obj, Object.class);
            }
            System.out.println("httpSendData\n" + postData);

            byte[] postDataBytes = postData.toString().getBytes();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.getOutputStream().write(postDataBytes);

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
                sb.append(line);
            }
            rd.close();
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String httpDelete(String path) {
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
                sb.append(line);
            }

            rd.close();
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String httpPut(String path, Object obj) {
        try {
            URL url = new URL(path);
            String putData;
            if (obj instanceof String) {
                putData = (String) obj;
            } else {
                putData = new Gson().toJson(obj, Object.class);
            }

            byte[] putDataBytes = putData.toString().getBytes();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.getOutputStream().write(putDataBytes);

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
                sb.append(line);
            }

            rd.close();
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
