package com.github.idnbso.hit.java.assignments.chat;

import java.util.ArrayList;

public class ClientDescriptor implements StringConsumer, StringProducer
{
    private String nickname;
    public final String getNickname()
    {
        return nickname;
    }

    private boolean isNicknameExist = false;
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
        StringBuilder message;
        if (!isNicknameExist) // the first consume call only
        {
            nickname = str;
            message = new StringBuilder("[SERVER]");
            message.append(str);
            message.append(" has joined.");
            message.append(System.lineSeparator());
            isNicknameExist = !isNicknameExist;
        }
        else if (str.equals("This Client is Leaving!2%234%"))
        {
            message = new StringBuilder("[SERVER]");
            message.append(nickname);
            message.append(" has left.");
            message.append(System.lineSeparator());
        }
        else // its a normal message
        {
            // TODO: add a timestamp in the begining of the message
            // String timeStamp = ;
            StringBuilder messagePrefix = new StringBuilder();
            messagePrefix.append(" <");
            messagePrefix.append(nickname);
            messagePrefix.append("> ");
            message = new StringBuilder(messagePrefix);
            message.append(str);
            message.append(System.lineSeparator());
        }

        for (StringConsumer consumer : consumers)
        {
            consumer.consume(message.toString());
        }
    }

}