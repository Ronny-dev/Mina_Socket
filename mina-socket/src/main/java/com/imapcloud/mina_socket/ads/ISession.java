package com.imapcloud.mina_socket.ads;

/**
 * @author EthanCo
 * @since 2017/1/17
 */
public interface ISession {
    void write(Object message);

    void close();
}
