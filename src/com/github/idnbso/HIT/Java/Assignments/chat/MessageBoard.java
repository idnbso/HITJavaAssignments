package com.github.idnbso.hit.java.assignments.chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class MessageBoard implements StringConsumer, StringProducer
{
    ArrayList<StringConsumer> consumers = new ArrayList<StringConsumer>();

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
        try
        {
            for (StringConsumer consumer : consumers)
            {
                boolean isCurrentConsumerDisconnected = false;
                ArrayList<StringConsumer> cpConsumers = ((ConnectionProxy) consumer).getConsumers();
                for (StringConsumer cpConsumer : cpConsumers)
                {
                    String test = "[SERVER]" + ((ClientDescriptor) cpConsumer).getNickname() + " has left."
                            + System.lineSeparator();
                    if (str.equals(test))
                    {
                        isCurrentConsumerDisconnected = true;
                        break;

                    }
                }

                if (isCurrentConsumerDisconnected)
                {
                    try
                    {
                        ((ConnectionProxy) consumer).closeConnection();
                        removeConsumer(consumer);
                        if (consumers.isEmpty())
                        {
                            break;
                        }
                    }
                    catch (IOException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
                else
                {
                    consumer.consume(str);
                }
            }
        }
        catch (ConcurrentModificationException e)
        {
            System.out.println("ConcurrentModificationException\n");
        }
    }

}