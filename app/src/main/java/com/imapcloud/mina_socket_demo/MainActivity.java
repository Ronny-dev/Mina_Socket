package com.imapcloud.mina_socket_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.imapcloud.mina_socket.Halo;
import com.imapcloud.mina_socket.ads.IHandlerAdapter;
import com.imapcloud.mina_socket.ads.ISession;
import com.imapcloud.mina_socket.impl.handler.StringLogHandler;
import com.imapcloud.mina_socket.type.Mode;

public class MainActivity extends AppCompatActivity {

    private ISession session;

    private Halo halo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                halo = new Halo.Builder()
                        .setMode(Mode.MINA_NIO_TCP_CLIENT)
                        .setBufferSize(2048)
                        .setTargetIP("192.168.50.168")
                        .setTargetPort(12345)
                        .addHandler(new StringLogHandler("Ronny"))
                        .addHandler(new DemoHandler())
                        .build();

                halo.start();
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        halo.stop();
        super.onDestroy();
    }

    class DemoHandler extends IHandlerAdapter {

        @Override
        public void sessionOpened(ISession session) {
            super.sessionOpened(session);
        }

        @Override
        public void messageReceived(ISession session, Object message) {
            super.messageReceived(session, message);
            Log.i("Ronny", "msg received: " + message);
        }
    }
}