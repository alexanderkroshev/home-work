package com.sbrf.reboot.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLUtils {

    private static final XmlMapper xmlMapper = new XmlMapper();

    public static String toXML(Request request) throws JsonProcessingException {
        return xmlMapper.writeValueAsString(request);
    }

    public static String toXML(Response response) throws JsonProcessingException {
        return xmlMapper.writeValueAsString(response);
    }

    public static Request XMLtoRequest(String json) throws JsonProcessingException {
        return xmlMapper.readValue(json, Request.class);
    }

    public static Response XMLtoResponse(String json) throws JsonProcessingException {
        return xmlMapper.readValue(json, Response.class);
    }


}
