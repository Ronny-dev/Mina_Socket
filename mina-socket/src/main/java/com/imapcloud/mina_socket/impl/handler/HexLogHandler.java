package com.imapcloud.mina_socket.impl.handler;

import com.imapcloud.mina_socket.ads.BaseLogHandler;
import com.imapcloud.mina_socket.utils.HexUtil;

/**
 * 16进制 日志处理
 *
 * @author EthanCo
 * @since 2017/1/18
 */

public class HexLogHandler extends BaseLogHandler {

    public HexLogHandler() {
    }

    public HexLogHandler(String tag) {
        super(tag);
    }

    @Override
    protected String convertToString(Object message) {
        if (message == null) {
            return "message is null";
        }

        String receive;
        if (message instanceof byte[] || message instanceof Byte[]) {
            receive = HexUtil.bytesToHexString((byte[]) message);
        } else if (message instanceof String) {
            receive = (String) message;
        } else {
            receive = message.toString();
        }
        return receive.trim();
    }
}
