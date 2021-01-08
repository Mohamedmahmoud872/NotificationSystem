package Notification;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main
{
    public static String MyGETRequest(String url) throws IOException
    {
        URL urlForGetRequest = new URL(url);
        String readLine = null;
        HttpURLConnection con = (HttpURLConnection) urlForGetRequest.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK)
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null)
            {
                response.append(readLine);
            }
            in .close();
            return response.toString();

        }
        else
        {
            return "GET NOT WORKED";
        }
    }


    public static void POSTRequest(String url) throws IOException {
        final String POST_PARAMS = url;
        System.out.println(POST_PARAMS);
        URL obj = new URL("http://localhost:8085/emailqueue/ADD");
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("POST");
        postConnection.setRequestProperty("Content-Type", "application/json");
        postConnection.setRequestProperty("Accept", "application/json");
        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        int responseCode = postConnection.getResponseCode();
        //System.out.println("POST Response Code :  " + responseCode);
        //System.out.println("POST Response Message : " + postConnection.getResponseMessage());
        if (responseCode == HttpURLConnection.HTTP_CREATED)
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in .readLine()) != null)
            {
                response.append(inputLine);
            }
            in .close();
            //return response.toString();
        } else {
            //return "POST NOT WORKED";
        }
    }

    public static void MyDeleteRequest(String url) throws IOException
    {
        URL object = new URL(url);
        String readLine = null;
        HttpURLConnection connect = (HttpURLConnection) object.openConnection();
        connect.setRequestMethod("DELETE");
        connect.setRequestProperty("Content-Type", "application/json; utf-8");
        connect.setRequestProperty("Accept", "application/json");
        int responseCode = connect.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK)
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null)
            {
                response.append(readLine);
            }
            in .close();

        }
        else
        {
            System.out.println("failed");;
        }
    }
    public static void main(String[] args) throws IOException
    {
        String receiver;
        String sender;
        String Format;
        boolean flag=false;
        Scanner inputInt=new Scanner(System.in);
        Scanner inputString=new Scanner(System.in);
        System.out.println("Enter the id of the template:");
        int id = inputInt.nextInt();
        String output = MyGETRequest("http://localhost:8085/search?id="+id);
        JSONObject jsonObject = new JSONObject(output);
        String content= (String) jsonObject.get("content");
        System.out.println(content);
        System.out.println("Enter your choice [by Email or Sms]");
        String choose=inputString.nextLine();
        System.out.println("enter the id ");
        int ID=inputInt.nextInt();
        if (choose.equals("sms"))
        {
            System.out.println("Enter the phone of Receiver:");
            receiver=inputString.nextLine();
            System.out.println("Enter your phone");
            sender=inputString.nextLine();
            Format="From:"+sender+" To:"+receiver+"'"+content+"'";
            String url="{\n" + "\"id\": "+ID+",\r\n" +
                    "    \"sender\": \""+sender+"\",\r\n" +
                    "    \"receiver\": \""+receiver+"\",\r\n" +
                    "    \"content\": \""+Format+"\"" + "\n}";

            POSTRequest(url);
            String result1 = MyGETRequest("http://localhost:8085/smsqueue/search?id="+ID);
            JSONObject jsonOb = new JSONObject(result1);
            String sms= (String) jsonOb.get("content");
            System.out.println(sms);
            while (!flag)
            {
                System.out.println("Enter the ids for dequeue");
                int ids =inputInt.nextInt();
                MyDeleteRequest("http://localhost:8085/smsqueue/delete?id="+ids);
                System.out.println("another dequeue ....!");
                String chose=inputString.nextLine();
                if(chose.equals("yes"))
                {
                    flag=false;
                }
                else
                    flag=true;
            }
        }
        else
        {
            System.out.println("Enter the Email of Receiver:");
            receiver=inputString.nextLine();
            System.out.println("Enter your Email");
            sender=inputString.nextLine();
            Format="From:"+sender+" To:"+receiver+"'"+content+"'";
            String url="{\n" + "\"id\": "+ID+",\r\n" +
                    "    \"sender\": \""+sender+"\",\r\n" +
                    "    \"receiver\": \""+receiver+"\",\r\n" +
                    "    \"content\": \""+Format+"\"" + "\n}";
            POSTRequest(url);
            String result2 = MyGETRequest("http://localhost:8085/emailqueue/search?id="+ID);
            JSONObject jsonObj = new JSONObject(result2);
            String email= (String) jsonObj.get("content");
            System.out.println(email);
            while (!flag)
            {
                System.out.println("Enter the ids for dequeue");
                int ids =inputInt.nextInt();
                MyDeleteRequest("http://localhost:8085/emailqueue/delete?id="+ids);
                System.out.println("another dequeue ....!");
                String chose=inputString.nextLine();
                if(chose.equals("yes"))
                {
                    flag=false;
                }
                else
                    flag=true;
            }
        }
    }

}