package com.longyi.dist.client.Util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.longyi.dist.client.domain.Refrig;
import com.longyi.dist.client.domain.Temperature;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by chenglongwei on 9/20/15.
 */
public class HttpUtil {
    public static void sendPost(String path, Map<String, String> params) {
        try {
            URL url = new URL(path);
            StringBuilder postData = new StringBuilder("{");
            for (Map.Entry<String, String> param : params.entrySet()) {
                if (postData.length() > "{".length()) {
                    postData.append(",");
                }
                postData.append("\"").append(param.getKey()).append("\"");
                postData.append(":");
                postData.append("\"").append(param.getValue()).append("\"");
            }
            postData.append("}");

            byte[] postDataBytes = postData.toString().getBytes();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            for (int c = in.read(); c != -1; c = in.read())
                System.out.print((char) c);

            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Refrig httpBootStrap(String path) {
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
                sb.append(line);
            }

            rd.close();

            return new Gson().fromJson(sb.toString(), Refrig.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Refrig httpRegister(String path, Refrig info) {
        try {
            URL url = new URL(path);
            String postData = new Gson().toJson(info, Refrig.class);

            byte[] postDataBytes = postData.toString().getBytes();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
                sb.append(line);
            }
            return new Gson().fromJson(sb.toString(), Refrig.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Refrig httpUpdateRegister(String path, Refrig info) {
        try {
            URL url = new URL(path);
            String postData = new Gson().toJson(info, Refrig.class);

            byte[] postDataBytes = postData.toString().getBytes();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
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
            return new Gson().fromJson(sb.toString(), Refrig.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Refrig httpDeRegister(String path) {
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

            return new Gson().fromJson(sb.toString(), Refrig.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Temperature> httpSendData(String path, Temperature temperature) {
        try {
            URL url = new URL(path);
            String postData = new Gson().toJson(temperature, Temperature.class);

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
            return new Gson().fromJson(sb.toString(), new TypeToken<List<Temperature>>() {
            }.getType());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
