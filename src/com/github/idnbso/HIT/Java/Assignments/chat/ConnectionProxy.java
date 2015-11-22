package com.github.idnbso.hit.java.assignments.chat;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class ConnectionProxy extends Thread implements StringConsumer, StringProducer
{
    private Socket socket;
    private StringConsumer consumer;
    private boolean isRunning = false, isStarted = false;
    // private boolean isClientRecieving = true;
    private boolean isServerHandshaked;
    private String serverHandshakeCode;
    // private String nickname;
    // private boolean isNicknameSet = false;
    private ArrayList<StringConsumer> consumers = new ArrayList<StringConsumer>();

    public final ArrayList<StringConsumer> getConsumers()
    {
        return consumers;
    }

    // public String getNickname()
    // {
    // return nickname;
    // }
    //
    // public void setNickname(String nickname)
    // {
    // this.nickname = nickname;
    // isNicknameSet = true;
    // }

    public ConnectionProxy()
    {
        this(null);
    }

    public ConnectionProxy(Socket socket)
    {
        setSocket(socket);
    }

    public void connect(String serverName, int serverPortNumber)
            throws UnknownHostException, IOException
    {
        disconnect();
        Socket newSocket = new Socket(serverName, serverPortNumber);
        setSocket(newSocket);
        startConnection();
    }

    public void startConnection()
    {
        isRunning = true;
        if (!isStarted)
        {
            start();
            isStarted = true;
        }

        System.out.println("connection started.");
    }

    public void disconnect() throws IOException
    {

        if (socket != null && isRunning)
        {
            OutputStream os = null;
            DataOutputStream dos = null;
            os = socket.getOutputStream();
            dos = new DataOutputStream(os);
            dos.writeUTF("This Client is Leaving!2%234%");
            closeConnection();
        }

    }

    public void closeConnection() throws IOException
    {

        isRunning = false;
        socket.close();
        socket = null;

    }

    public Socket getSocket()
    {
        return socket;
    }

    public void setSocket(Socket socket)
    {
        this.socket = socket;
    }

    public StringConsumer getConsumer()
    {
        return consumer;
    }

    public void setConsumer(StringConsumer consumer)
    {
        this.consumer = consumer;
    }

    @Override
    public void addConsumer(StringConsumer sc)
    {

        consumers.add(sc);
    }

    @Override
    public void removeConsumer(StringConsumer sc)
    {
        consumers.remove(sc);
    }

    @Override
    public void consume(String str)
    {
        // for (StringConsumer consumer : consumers)
        // {
        // if (consumer.equals(ClientDescriptor.class) && !isClientSent)
        // {
        //// consumer.consume(str);
        // }
        // else if (consumer.equals(ClientGUI.class))
        // }
        OutputStream os = null;
        DataOutputStream dos = null;

        // if (!isNicknameSet)
        // {
        // setNickname(str);
        // }

        try
        {
            // TODO: if two messages are being shown then set a boolean
            // at the first time the nickname was sent to server
            if (socket != null)
            {
                os = socket.getOutputStream();
                dos = new DataOutputStream(os);
                dos.writeUTF(str);
                // isClientRecieving = false;
            }
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //
        // }
        // }
    }

    @Override
    public void run()
    {
        InputStream is = null;
        DataInputStream dis = null;
        try
        {
            while (isRunning && !socket.isClosed())
            {
                is = socket.getInputStream();
                dis = new DataInputStream(is);
                String str = null;
                str = dis.readUTF();
                // if (!str.equals(nickname + " has left.\n"))
                // {

                // this has value is sent from the server only after all of
                // the
                // clients got
                // a message that this particular user has been disconnected
                // which means update the GUI accordingly
                int i = consumers.size();
                if (str != null && i > 0)
                {
                    // if (!isNicknameSet)
                    // {
                    // setNickname(str);
                    // }

                    // if (isClientRecieving)
                    // {
                    for (StringConsumer consumer : consumers)
                    {

                        consumer.consume(str);

                    }
                    // }
                    // else
                    // {
                    // isClientRecieving = true;
                    // }
                    // isClientSent = !isClientSent;
                }
                System.out.println(str);
            }

            // }
        }
        catch (SocketException e)
        {
            System.out.println("disconnected from server.");
            isStarted = false;
        }
        catch (EOFException e)
        {
            // e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (is != null)
            {
                try
                {
                    is.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (dis != null)
            {
                try
                {
                    dis.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            // if (socket != null)
            // {
            // try
            // {
            // socket.close();
            // }
            // catch (IOException e)
            // {
            // e.printStackTrace();
            // }
            // }
        }
    }
}