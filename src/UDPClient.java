import java.io.*;
import java.net.*;

class UDPClient
{
    public static void main(String[] args) throws Exception {



        //Creating byte array and choosing size
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        //input from user. uses java.io
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        //converting our input string to byte
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();

        //HOST address
        InetAddress serverIP = InetAddress.getByName("localhost");
        //HOST port
        int serverPort = 9880;
        //UDP socket. uses java.net
        DatagramSocket clientSocket = new DatagramSocket();

        //sending packet with data, address and specifying server port
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIP, serverPort);
        clientSocket.send(sendPacket);

        //receiving from server
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("FROM SERVER:" + modifiedSentence);

        //Close socket
        clientSocket.close();
    }
}