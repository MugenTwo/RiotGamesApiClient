package com.mugen.riot.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Region {

    RUSSIA("ru"),
    KOREA("kr"),
    BRAZIL("br1"),
    OCEANIA("oc1"),
    JAPAN("jp1"),
    NORTH_AMERICA("na1"),
    EUROPE_NORDIC_AND_EAST("eun1"),
    EUROPE_WEST("euw1"),
    TURKEY("tr1"),
    LATIN_AMERICA_NORTH("la1"),
    LATIN_AMERICA_SOUTH("la2");

    private final String acronym;

}
