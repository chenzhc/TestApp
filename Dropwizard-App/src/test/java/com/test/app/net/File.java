package com.test.app.net;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zc on 2015/6/10.
 */
public class File {

    @Test
    public void getFile() throws MalformedURLException {
        URL url = new URL("http://www.163.com");

        System.out.println(url.getRef());
    }

    @Test
    public void time() throws IOException {
        Socket socket = null;
        try {
            socket = new Socket("time.nist.gov",13);
            socket.setSoTimeout(15000);
            InputStream in = socket.getInputStream();
            StringBuffer sb = new StringBuffer();
            InputStreamReader reader = new InputStreamReader(in,"ASCII");
            for(int c=reader.read(); c!=-1; c=reader.read()){
                sb.append((char)c);
            }
            System.out.println(sb.toString());
            System.out.println(parseDate(sb.toString()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }

    private Date parseDate(String str) throws ParseException {
        String[] prices = str.split(" ");
        String dateTime = prices[1] + " " + prices[2] + " UTC";
        DateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        return  format.parse(dateTime);
    }
}
