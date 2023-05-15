package org.acme;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.LinkedList;
import java.util.NoSuchElementException;

@Path("meter")
public class MicroMeterRegistryResource {

    private final MeterRegistry meterRegistry;

    LinkedList<Long> list = new LinkedList<>();

    MicroMeterRegistryResource(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        //collect metrics and store into linked list
        meterRegistry.gaugeCollectionSize("example.list.size", Tags.empty(), list);
    }
    //api to record metrics

    @GET
    @Path("gauge/{number}")
    public Long checkListSize(long number) {
        if (number == 2 || number % 2 == 0) {
            // add even numbers to the list
            list.add(number);
        } else {
            // remove items from the list for odd numbers
            try {
                number = list.removeFirst();
            } catch (NoSuchElementException nse) {
                number = 0;
            }
        }
        return number;
    }


}
