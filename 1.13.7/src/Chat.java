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

class Chat extends JFrame implements Runnable {
    JTextField message;
    JTextArea log;
    BufferedWriter aSend;
    BufferedWriter aReceive;
    public Chat() {
        super("I AM A");
        JTextField jTextField = new JTextField(20);
        JButton jButton = new JButton("发送数据");
        jButton.addActionListener(new ChatGo());
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
        File send = new File("a_send_log.txt");
        File receive = new File("a_receive_log.txt");
        try {
            aReceive = new BufferedWriter(new FileWriter(receive,true));
            aSend = new BufferedWriter(new FileWriter(send,true));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Thread thread = new Thread(this);
        thread.start();

    }

    class ChatGo implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String temp =  message.getText();
            try {
                byte[] s = temp.trim().getBytes();
                DatagramSocket datagramSocket = new DatagramSocket();
                InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
                DatagramPacket datagramPacket = new DatagramPacket(s,s.length,inetAddress,1234);
                datagramSocket.send(datagramPacket);
                aSend.write("发送:"+datagramPacket.getAddress()+"   时间:"+ LocalDate.now()+"  "+LocalTime.now()+"   内容:"+temp+"\n");
                aSend.flush();
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
            DatagramSocket datagramSocket = new DatagramSocket(5678);
            while (true){
                datagramSocket.receive(datagramPacket);
                String mes =new String(datagramPacket.getData());
                log.append("收到数据来自于:"+ datagramPacket.getAddress());
                log.append("\n收到数据是:"+mes+"\n");
                log.setCaretPosition(mes.length());
                aReceive.write("收到:"+datagramPacket.getAddress()+"   时间:"+LocalDate.now()+"  "+ LocalTime.now()+"    内容:"+mes+"\n");
                aReceive.flush();
            }
        }
        catch (Exception e){

        }
    }

    public static void main(String[]args){
        Chat chat = new Chat();
        chat.setVisible(true);
    }

}
