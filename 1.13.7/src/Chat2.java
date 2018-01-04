import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.time.LocalDate;
import java.time.LocalTime;

class Chat2 extends JFrame implements Runnable {
    JTextField message;
    JTextArea log;
    BufferedWriter bSend;
    BufferedWriter bReceive;
    public Chat2() {
        super("I AM B");
        JTextField jTextField = new JTextField(20);
        JButton jButton = new JButton("发送数据");
        jButton.addActionListener(new Chat2Go());
        JTextArea jTextArea = new JTextArea(10,30);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JPanel jPanel = new JPanel();
        jPanel.setPreferredSize(new Dimension(400,200));
        jPanel.add(jTextField);
        jPanel.add(jButton);
        jPanel.add(jScrollPane);
        message = jTextField;
        log = jTextArea;
        this.add(jPanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        File send = new File("b_send_log.txt");
        File receive = new File("b_receive_log.txt");
        try {
            bReceive = new BufferedWriter(new FileWriter(receive,true));
            bSend = new BufferedWriter(new FileWriter(send,true));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Thread thread = new Thread(this);
        thread.start();

    }

    class Chat2Go implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String temp =  message.getText();
            try {
                byte[] s = temp.trim().getBytes();
                DatagramSocket datagramSocket = new DatagramSocket();
                InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
                DatagramPacket datagramPacket = new DatagramPacket(s,s.length,inetAddress,5678);
                datagramSocket.send(datagramPacket);
                bSend.write("发送:"+datagramPacket.getAddress()+"   时间:"+LocalDate.now()+"  "+ LocalTime.now()+"   内容:"+temp+"\n");
                bSend.flush();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        try{
            byte b[] = new byte[8192];
            DatagramPacket datagramPacket = new DatagramPacket(b,8192);
            DatagramSocket datagramSocket = new DatagramSocket(1234);
            while (true){
                datagramSocket.receive(datagramPacket);
                String mes =new String(datagramPacket.getData());
                log.append("收到数据来自于:"+ datagramPacket.getAddress());
                log.append("\n收到数据是:"+mes+"\n");
                log.setCaretPosition(mes.length());
                bReceive.write("收到:"+datagramPacket.getAddress()+"   时间:"+ LocalDate.now()+"  "+LocalTime.now()+"    内容:"+mes+"\n");
                bReceive.flush();
            }
        }
        catch (Exception e){

        }
    }

    public static void main(String[]args){
        Chat2 chat = new Chat2();
        chat.setVisible(true);
    }

}
