package com.github.idnbso.hit.java.assignments.chat;

public interface StringProducer
{
    public void addConsumer(StringConsumer sc);
    public void removeConsumer(StringConsumer sc);
}