package com.mugen.riot.route;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Continent implements Route {

    AMERICAS("americas"),
    ASIA("asia"),
    EUROPE("europe");

    private final String path;

}
