package com.rest.app.api.parser;

public interface Parser<Raw, Parsed> {
    Parsed parse(Raw data);
}
