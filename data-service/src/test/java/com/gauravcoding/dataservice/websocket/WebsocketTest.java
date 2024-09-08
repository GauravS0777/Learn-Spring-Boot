package com.gauravcoding.dataservice.websocket;

import com.gauravcoding.dataservice.Connection;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class WebsocketTest {

    @Test
    void testConnection(){
        Connection connection = new Connection();
        connection.connect();
    }
}
