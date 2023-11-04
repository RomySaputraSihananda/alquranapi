package org.alquranapi.payload.hit;

public record ElasticHit<Source>(String id, String index, Source source) {
}
