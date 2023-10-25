package org.alquranapi.payload.response;

import java.util.ArrayList;

public record BodyResponse<Data>(
        String status,
        int code,
        String message,
        ArrayList<Data> data) {
}
