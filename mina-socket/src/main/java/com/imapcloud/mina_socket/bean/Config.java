package com.imapcloud.mina_socket.bean;

import android.content.Context;

import com.imapcloud.mina_socket.ads.IConvertor;
import com.imapcloud.mina_socket.ads.IHandler;
import com.imapcloud.mina_socket.type.Mode;

import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * Created by EthanCo on 2016/9/16.
 */
public class Config {
    //模式
    public Mode mode;
    //目标IP
    public String targetIP;
    //目标端口
    public int targetPort;
    //源IP
    //public String sourceIP;
    //源端口
    public int sourcePort;
    //缓存大小
    public int bufferSize;
    //线程池
    public ExecutorService threadPool;

    public List<IHandler> handlers;

    public List<IConvertor> convertors;

    public Object codec;

    public Context context;

    public KeepAlive keepAlive;
}
