package com.mugen.riot;

import com.mugen.riot.route.Continent;
import com.mugen.riot.route.Region;
import com.mugen.riot.service.AccountService;
import com.mugen.riot.service.ChampionMasteryService;
import com.mugen.riot.service.ChampionService;
import com.mugen.riot.service.ClashService;
import com.mugen.riot.service.LeagueExpService;
import com.mugen.riot.service.LeagueService;
import com.mugen.riot.service.LolStatusService;
import com.mugen.riot.service.SpectatorService;
import com.mugen.riot.service.SummonerService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RiotApiProviderTest {

    @ParameterizedTest
    @ValueSource(classes = {
            ChampionMasteryService.class,
            ChampionService.class,
            ClashService.class,
            LeagueExpService.class,
            LeagueService.class,
            LolStatusService.class,
            SpectatorService.class,
            SummonerService.class
    })
    <T> void createRegionApiByService(Class<T> clazz) {
        RiotApiProvider riotApiProvider = new RiotApiProvider("testApiKey");

        assertThat(riotApiProvider.generateApi(clazz)).containsOnlyKeys(Region.values());
    }

    @ParameterizedTest
    @ValueSource(classes = {
            AccountService.class
    })
    <T> void createContinentApiByService(Class<T> clazz) {
        RiotApiProvider riotApiProvider = new RiotApiProvider("testApiKey");

        assertThat(riotApiProvider.generateApi(clazz)).containsOnlyKeys(Continent.values());
    }

}