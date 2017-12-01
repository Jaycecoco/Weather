package com.huangxiao.weather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Abbey on 2017/11/30 0030.
 */
//
//public class HttpUtil {
//    public static void sendHttpRequest(final String address,final HttpCallbackListener listener){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                HttpURLConnection connection=null;
//                try{
//                    URL url=new URL(address);
//                    connection=(HttpURLConnection)url.openConnection();
//                    connection.setRequestMethod("GET");
//                    connection.setConnectTimeout(8000);
//                    String line;
//                    connection.setReadTimeout(8000);
//                    InputStream in=connection.getInputStream();
//                    BufferedReader reader=new BufferedReader(new InputStreamReader(in));
//                    StringBuilder response=new StringBuilder();
//                    while ((line=reader.readLine())!=null){
//                        response.append(line);
//                    }
//                    if (listener!=null){
//                        //回调onFinish()方法
//                        listener.onFinish(response.toString());
//                    }
//                }catch (Exception e){
//                    if (listener!=null){
//                        //回调onError()方法
//                        listener.onError(e);
//                    }
//                }finally {
//                    if (connection!=null){
//                        connection.disconnect();
//                    }
//                }
//            }
//        }).start();
//
//    }
//}
public class HttpUtil{
    public static void sendOKHttpRequest(String address, okhttp3. Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}