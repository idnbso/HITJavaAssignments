package com.github.idnbso.hit.java.assignments.chat;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientGUI implements StringConsumer, StringProducer
{
    private JFrame frame;
    private JPanel panelTop, panelMiddle, panelBottom;
    private JTextField textFieldNickname, textFieldNewMessage;
    private JTextField textFieldServerAddress, textFieldPort;
    private JTextArea textAreaMessageBoard, textAreaUsersList;
    private JScrollPane scrollPaneMessageBoard, scrollPaneUsersList;
    private JLabel labelNickname, labelServerAddress, labelPort;
    private JButton buttonConnectDisconnect, buttonSend;
    private ActionListener listener;
    private final Color colorLightRed;
    private final Color colorLigtGreen;
    private boolean isConnected = false;
    private String serverName = "127.0.0.1";
    private int serverPortNumber = 1300;
    private ConnectionProxy connection;
    private ArrayList<StringConsumer> consumers = new ArrayList<StringConsumer>();
    private final int numberOfMessageBoardRows = 17;
    private final int numberOfMessageBoardColumns = 38;
    private final int numberOfUsersListRows = 17;
    private final int numberOfUsersListColumns = 10;

    public ClientGUI() throws UnknownHostException, IOException
    {
        frame = new JFrame("Chat Client by Idan Busso & Shani Kahila");
        frame.setResizable(false);
        panelTop = new JPanel(new FlowLayout(8, 8, 6));
        panelMiddle = new JPanel(new FlowLayout());
        panelBottom = new JPanel(new FlowLayout());
        labelNickname = new JLabel("Nickname:");
        labelServerAddress = new JLabel("Server Address:");
        labelPort = new JLabel("Port:");
        textFieldNickname = new JTextField(8);
        textFieldNewMessage = new JTextField(37);

        textFieldServerAddress = new JTextField(serverName, 9);
        textFieldPort = new JTextField(String.valueOf(serverPortNumber), 4);

        colorLightRed = new Color(220, 0, 70);
        colorLigtGreen = new Color(0, 220, 100);

        textAreaMessageBoard = new JTextArea("Welcome to the chat room.\n",
                numberOfMessageBoardRows, numberOfMessageBoardColumns);
        textAreaMessageBoard.setEditable(false);
        scrollPaneMessageBoard = new JScrollPane(textAreaMessageBoard);
        scrollPaneMessageBoard.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener()
        {
            public void adjustmentValueChanged(AdjustmentEvent e)
            {
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
            }
        });
        scrollPaneMessageBoard
                .setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneMessageBoard.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        textAreaUsersList = new JTextArea("         Users List" + System.lineSeparator(),
                numberOfUsersListRows, numberOfUsersListColumns);
        textAreaUsersList.setEditable(false);
        scrollPaneUsersList = new JScrollPane(textAreaUsersList);
        scrollPaneUsersList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneUsersList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        buttonConnectDisconnect = new JButton("Connect");
        buttonConnectDisconnect.setPreferredSize(new Dimension(100, 25));
        // set the connect button with a default color of red
        buttonConnectDisconnect.setBackground(colorLightRed);
        buttonSend = new JButton("Send");
        frame.setLayout(new BorderLayout());
        listener = new ButtonsListener();

    }

    private void setupNewConnectionProxy()
    {
        try
        {
            // TODO: check that the server address is a proper ip address
            connection = new ConnectionProxy();
            connection.addConsumer(this);
            this.addConsumer(connection);
            connection.connect(textFieldServerAddress.getText(),
                    Integer.parseInt(textFieldPort.getText()));
            isConnected = true;
        }
        catch (ConnectException e)
        {
            JOptionPane.showMessageDialog(null, "Connection refused by the server which could be offline.");
        }
        catch (NumberFormatException | IOException e)
        {
            e.printStackTrace();
        }
    }

    private void disconnectFromConnectionProxy() throws IOException
    {
        connection.disconnect();
        isConnected = false;
        connection.removeConsumer(this);
        this.removeConsumer(connection);
        connection = null;
    }

    class ButtonsListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            try
            {
                String inputString = null;

                if (event.getSource() == buttonConnectDisconnect)
                {
                    inputString = textFieldNickname.getText();
                    if (!isConnected)
                    {
                        boolean isServerAddressValid = false;
                        boolean isServerPortValid = false;

                        String serverAddress = textFieldServerAddress.getText();
                        if (IPAddressValidator.validate(serverAddress))
                        {
                            isServerAddressValid = true;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Invalid server address input.");
                        }

                        int port = Integer.parseInt(textFieldPort.getText());
                        if (1024 < port && port < 65536)
                        {
                            isServerPortValid = true;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,
                                    "Invalid server port number input.");
                        }

                        if (isServerAddressValid && isServerPortValid)
                        {
                            buttonConnectDisconnect.setText("Disconnect");
                            buttonConnectDisconnect.setBackground(colorLigtGreen);
                            setupNewConnectionProxy();
                        }
                        else
                        {
                            inputString = null;
                        }
                    }
                    else
                    {
                        buttonConnectDisconnect.setText("Connect");
                        buttonConnectDisconnect.setBackground(colorLightRed);

                        disconnectFromConnectionProxy();

                        textAreaMessageBoard.append("Disconnected from server.\n");
                        textAreaUsersList.removeAll();
                    }
                }
                else if (event.getSource() == buttonSend)
                {

                    if (isConnected)
                    {
                        inputString = textFieldNewMessage.getText();
                        textFieldNewMessage.setText("");
                    }
                }

                if (inputString != null && connection != null)
                {
                    connection.consume(inputString);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void consume(String str)
    {
        if (str.startsWith("[SERVER]"))
        {
            str = str.replace("[SERVER]", "");
            textAreaMessageBoard.append(str);
            str = str.replace("has joined.", "");
            str = str.replace("has left.", "");
            textAreaUsersList.append(str);
        }
        else
        {
            textAreaMessageBoard.append(str);
        }
    }

    public void start()
    {
        panelTop.setBackground(Color.LIGHT_GRAY);
        panelBottom.setBackground(Color.LIGHT_GRAY);
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        // top section of nickname text field and connect/disconnect button
        buttonConnectDisconnect.addActionListener(listener);
        panelTop.add(labelNickname);
        panelTop.add(textFieldNickname);
        panelTop.add(labelServerAddress);
        panelTop.add(textFieldServerAddress);
        panelTop.add(labelPort);
        panelTop.add(textFieldPort);
        panelTop.add(buttonConnectDisconnect);
        frame.add(panelTop, BorderLayout.NORTH);

        // middle section of message text area and users list
        panelMiddle.add(scrollPaneMessageBoard);
        panelMiddle.add(scrollPaneUsersList);
        frame.add(panelMiddle, BorderLayout.CENTER);

        // bottom section of message field and send button
        buttonSend.addActionListener(listener);
        panelBottom.add(textFieldNewMessage);
        panelBottom.add(buttonSend);
        frame.add(panelBottom, BorderLayout.SOUTH);
        frame.setSize(600, 400);

        // place the window in the center of the screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getRootPane().setDefaultButton(buttonSend);
        buttonSend.requestFocus();
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                ClientGUI guiChatClient;
                try
                {
                    guiChatClient = new ClientGUI();
                    guiChatClient.start();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

            }
        });
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

    public static class IPAddressValidator
    {

        private static Pattern pattern;
        private static Matcher matcher;

        private static final String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

        public IPAddressValidator()
        {

        }

        /**
         * Validate ip address with regular expression
         * 
         * @param ip
         *            address for validation
         * @return true valid ip address, false invalid ip address
         */
        public static boolean validate(final String ip)
        {
            pattern = Pattern.compile(IPADDRESS_PATTERN);
            matcher = pattern.matcher(ip);
            return matcher.matches();
        }
    }
}