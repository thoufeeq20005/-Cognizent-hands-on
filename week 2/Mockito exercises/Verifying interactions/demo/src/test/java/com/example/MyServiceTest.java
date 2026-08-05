package com.example;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {

        // Create Mock Object
        ExternalApi api = mock(ExternalApi.class);

        // Inject Mock
        MyService service = new MyService(api);

        // Call Method
        service.process();

        // Verify Interaction
        verify(api).sendData("Hello Mockito");
    }
}