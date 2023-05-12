package com.ibm.service.communication.falut;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;

@Path("/timeout")
public class TimeoutResource {
    @GET
    @Timeout(5000)
    @Fallback(fallbackMethod = "getFromCache")
    public String delay() throws InterruptedException {
        randomDelay();
        return "Hello";
    }

    private void randomDelay() throws InterruptedException {
        // introduce some artificial delay
        Thread.sleep(6000);
        //Thread.sleep(3000);
    }

    //fallback
    public String getFromCache() {
        return "Timeout Fallback  Response";
    }
}
