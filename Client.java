import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

public class Client {
    private final InetAddress serverIp;
    private final int port;
    private final String login;
    private String password;
    Client(String serverIp,int port,String login){
        try {
            this.serverIp=InetAddress.getByName(serverIp);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        this.port=port;
        this.login=login;
        this.init();
    }

    private void init(){
        try(Socket socket =new Socket(this.serverIp,this.port)){
            OutputStream outputStream=socket.getOutputStream();
            PrintWriter writer =new PrintWriter(outputStream,true);
            InputStream inputStream =socket.getInputStream();
            BufferedReader reader =new BufferedReader(new InputStreamReader(inputStream));
            writer.println(login+" "+login);
            this.password = Arrays.stream(reader.readLine().split(":"))
                    .reduce((first, second) -> second)
                    .map(String::strip)
                    .orElse("");

            System.out.println("init successfully your password: "+password);
            inputStream.close();
            outputStream.close();
            socket.close();
            System.out.println(serverIp+" connection closed");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void run(){
        try(Socket socket =new Socket(this.serverIp,this.port);) {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            writer.println(this.login+" "+this.password);
            System.out.println("Login as "+ this.login+"\n");
            task1(reader,writer);
            task2(reader,writer);
            task3(reader,writer);
            task4(reader,writer);
            task5(reader,writer);
            socket.close();
            System.out.println(serverIp+" connection closed");
        }catch (IOException e) {throw new RuntimeException(e);}
    }
    private void task1(BufferedReader reader,PrintWriter writer) throws IOException{
        
    }
    private void task2(BufferedReader reader,PrintWriter writer) throws IOException{
       
    }
    private void task3(BufferedReader reader,PrintWriter writer) throws IOException{
        
    }
    private void task4(BufferedReader reader,PrintWriter writer) throws IOException{
        
    }
    private void task5(BufferedReader reader,PrintWriter writer) throws IOException{
       
    }

}
