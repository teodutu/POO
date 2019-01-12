import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface Nic {
    /*
     * TODO:
     * Add methods here to implement double dispatch
     */
    void visit(UdpPacket udpPacket);
    void visit(TcpPacket tcpPacket);
}

class WirelessNic implements Nic {
    @Override
    public void visit(UdpPacket udpPacket) {
        System.out.println("WirelessNic sending UdpPacket");
    }

    @Override
    public void visit(TcpPacket tcpPacket) {
        System.out.println("WirelessNic sending TcpPacket");
    }
}

class EthernetNic implements Nic {
    @Override
    public void visit(UdpPacket udpPacket) {
        System.out.println("EthernetNic sending UdpPacket");
    }

    @Override
    public void visit(TcpPacket tcpPacket) {
        System.out.println("EthernetNic sending TcpPacket");
    }
}

class UsbNic implements Nic {
    @Override
    public void visit(UdpPacket udpPacket) {
        System.out.println("UsbNic sending UdpPacket");
    }

    @Override
    public void visit(TcpPacket tcpPacket) {
        System.out.println("UsbNic sending TcpPacket");
    }
}

/*
 * DO NOT MODIFY THIS INTERFACE !
 */
interface Packet {
    void dispatch(Nic nic);
}

class UdpPacket implements Packet {
    @Override
    public void dispatch(Nic nic) {
        nic.visit(this);
    }
}

class TcpPacket implements Packet {
    @Override
    public void dispatch(Nic nic) {
        nic.visit(this);
    }
}

/*
 * DO NOT MODIFY THIS CLASS !
 */
class Client {
    void send (Nic[] nics, Packet[] packets) {
        for (int i = 0; i < packets.length; i++) {
            Packet p = packets[i];
            for (int j = 0; j < nics.length; j++) {
                p.dispatch(nics[j]);
            }
        }
    }
}

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* TODO:
         * Read from stdin, parse the input and instatiate Packets and Nic.
         */
        Scanner sc = new Scanner(System.in);
        int numNics, numPackets;
        Nic[] nics;
        Packet[] packets;

        numNics = sc.nextInt();
        nics = new Nic[numNics];

        for (int i = 0; i < numNics; ++i) {
            String s = sc.next();

            switch (s) {
                case "WirelessNic":
                    nics[i] = new WirelessNic();
                    break;
                case "EthernetNic":
                    nics[i] = new EthernetNic();
                    break;
                case "UsbNic":
                    nics[i] = new UsbNic();
                    break;
            }
        }

        /* TODO:
         * Instantiate Client and call send with the input that you previously obtained
         */

        numPackets = sc.nextInt();
        packets = new Packet[numPackets];

        for (int i = 0; i < numPackets; ++i) {
            String s = sc.next();

            switch (s) {
                case "UdpPacket":
                    packets[i] = new UdpPacket();
                    break;
                case "TcpPacket":
                    packets[i] = new TcpPacket();
                    break;
            }
        }

        Client c = new Client();
        c.send(nics, packets);
    }
}