package com.tohu.tohumanagement.Services;

import com.google.gson.Gson;
import org.bukkit.Bukkit;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HttpReq {

    public static String Get(String sUrl) {
        HttpURLConnection conn = null;
        InputStream in = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(sUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int status = conn.getResponseCode();
            StringBuilder output = new StringBuilder();
            if (status == HttpURLConnection.HTTP_OK) {
                in = conn.getInputStream();
                reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line);
                }
            }
            return output.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String Post(String sUrl, Map<String, Object> hashMap) {
        Gson gson = new Gson();
        String json = gson.toJson(hashMap);
        HttpURLConnection connection = null;
        InputStream in = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(sUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-Length", String.valueOf(json.length()));

            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write(json);
            out.flush();
            connection.connect();
            int status = connection.getResponseCode();
            StringBuilder output = new StringBuilder();
            if (status == HttpURLConnection.HTTP_OK) {
                in = connection.getInputStream();
                reader = new BufferedReader(new java.io.InputStreamReader(in, java.nio.charset.StandardCharsets.UTF_8));
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line);
                }
            } else {
                System.out.println("status: " + status);
                Bukkit.getLogger().info("status: " + status);
                in = connection.getErrorStream();
                reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line);
                }
                System.out.println(output);
            }
            return output.toString();
        } catch (IOException err) {
            err.printStackTrace();
            return err.toString();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (connection != null) {
                    connection.disconnect();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException err) {
                err.printStackTrace();
            }
        }
    }
}
