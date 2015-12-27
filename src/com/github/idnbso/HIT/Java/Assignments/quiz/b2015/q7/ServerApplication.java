package com.github.idnbso.hit.java.assignments.quiz.b2015.q7;

import java.io.*;
import java.net.*;

import com.github.idnbso.hit.java.assignments.chat.*;

public class ServerApplication implements Closeable
{
    private static ServerSocket server;

    public static void main(String args[])
    {

        MessageBoard mb = new MessageBoard();
        createServer();
        Socket socket = null;
        ClientDescriptor client = null;
        ConnectionProxy connection = null;

        while (true)
        {
            try
            {
                socket = server.accept();
                connection = new ConnectionProxy(socket);
                client = new ClientDescriptor();
                connection.addConsumer(client);
                client.addConsumer(mb);
                mb.addConsumer(connection);
                Thread connecitonThread = new Thread(connection);
                connecitonThread.start();
                System.out.println("A new connection was made.");
                
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close()
    {
        if (server != null)
        {
            try
            {
                server.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private static void createServer()
    {
        try
        {
            server = new ServerSocket(1300, 5);
            System.out.println("The server socket was created.");
            System.out.println("Waiting for new connections...");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}