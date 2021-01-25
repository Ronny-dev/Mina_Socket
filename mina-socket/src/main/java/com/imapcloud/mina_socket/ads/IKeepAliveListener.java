package com.imapcloud.mina_socket.ads;

import com.imapcloud.mina_socket.bean.KeepAlive;

/**
 * 心跳 回调
 *
 * @author EthanCo
 * @since 2017/7/31
 * -     ┌─┐       ┌─┐
 * -  ┌──┘ ┴───────┘ ┴──┐
 * -  │                 │
 * -  │       ───       │
 * -  │  ─┬┘       └┬─  │
 * -  │                 │
 * -  │       ─┴─       │
 * -  │                 │
 * -  └───┐         ┌───┘
 * -      │         │
 * -      │         │
 * -      │         │
 * -      │         └──────────────┐
 * -      │                        │
 * -      │                        ├─┐
 * -      │                        ┌─┘
 * -      │                        │
 * -      └─┐  ┐  ┌───────┬──┐  ┌──┘
 * -        │ ─┤ ─┤       │ ─┤ ─┤
 * -        └──┴──┘       └──┴──┘
 * --------------- 神兽保佑 ---------------
 * --------------- 永无BUG! ---------------
 */

public interface IKeepAliveListener {
    void onKeepAliveRequestTimedOut(KeepAlive keepAlive, ISession iSession);

    boolean isKeepAliveMessage(ISession ioSession, Object message);

    Object getKeepAliveMessage(ISession ioSession, Object o);
}
