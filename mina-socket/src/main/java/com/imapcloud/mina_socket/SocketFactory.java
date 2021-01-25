package com.imapcloud.mina_socket;

import com.imapcloud.mina_socket.ads.ISocket;
import com.imapcloud.mina_socket.bean.Config;
import com.imapcloud.mina_socket.impl.socket.MulticastSocket;
import com.imapcloud.mina_socket.impl.socket.UdpClientSocket;
import com.imapcloud.mina_socket.mina.MinaTcpClientSocket;
import com.imapcloud.mina_socket.mina.MinaTcpServerSocket;
import com.imapcloud.mina_socket.mina.MinaUdpClientSocket;
import com.imapcloud.mina_socket.mina.MinaUdpServerSocket;
import com.imapcloud.mina_socket.type.Mode;

/**
 * Created by EthanCo on 2016/9/19.
 */
class SocketFactory {

    public static ISocket create(Config config) {
        ISocket haloImpl;
        Mode mode = config.mode;

        if (mode == Mode.MULTICAST) {
            haloImpl = new MulticastSocket(config);
        } else if(mode == Mode.UDP_CLIENT){
            haloImpl = new UdpClientSocket(config);
        } else {
            haloImpl = createByReflect(mode, config);
        }
        return haloImpl;
    }

    private static ISocket createByReflect(Mode mode, Config config) {
        ISocket haloImpl = null;
        switch (mode) {
            case MINA_NIO_TCP_CLIENT:
                haloImpl = new MinaTcpClientSocket(config);
                break;
            case MINA_NIO_TCP_SERVER:
                haloImpl = new MinaTcpServerSocket(config);
                break;
            case MINA_NIO_UDP_CLIENT:
                haloImpl = new MinaUdpClientSocket(config);
                break;
            case MINA_NIO_UDP_SERVER:
                haloImpl = new MinaUdpServerSocket(config);
                break;
        }
        return haloImpl;
    }
}
