package com.innomalist.taxi.rider.events;

import com.google.android.gms.maps.model.LatLng;
import com.innomalist.taxi.common.events.BaseRequestEvent;
import com.innomalist.taxi.common.utils.ServerResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class ServiceRequestEvent extends BaseRequestEvent {
    public JSONObject pickupPoint;
    public JSONObject destinationPoint;
    public String pickupLocation;
    public String dropOffLocation;
    public int serviceId;
    public int minutesFromNow;

    public ServiceRequestEvent(LatLng pickupPoint, LatLng destinationPoint, String pickupLocation, String dropOffLocation, int serviceId, int minutesFromNow) {
        super(new ServiceRequestErrorEvent(ServerResponse.REQUEST_TIMEOUT.getValue()));
        try {
            JSONObject arrayPickup = new JSONObject();
            arrayPickup.put("x",pickupPoint.longitude);
            arrayPickup.put("y",pickupPoint.latitude);
            this.pickupPoint = arrayPickup;
            JSONObject arrayDestination = new JSONObject();
            arrayDestination.put("x",destinationPoint.longitude);
            arrayDestination.put("y",destinationPoint.latitude);
            this.destinationPoint = arrayDestination;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.pickupLocation = pickupLocation;
        this.dropOffLocation = dropOffLocation;
        this.serviceId = serviceId;
        this.minutesFromNow = minutesFromNow;
    }
}
