package com.github.idnbso.hit.java.assignments.threads.websitesconnectiontime;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

class ConnectionTime implements Comparable<ConnectionTime>
{
    long time;
    String website;

    ConnectionTime(long time, String website)
    {
        this.time = time;
        this.website = website;
    }

    public int compareTo(ConnectionTime other)
    {
        return (int) (time - other.time);
    }
}