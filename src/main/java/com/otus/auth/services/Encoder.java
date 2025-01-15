package com.otus.auth.services;

public interface Encoder {

    byte[] encode(byte[] src) throws Exception;
}
