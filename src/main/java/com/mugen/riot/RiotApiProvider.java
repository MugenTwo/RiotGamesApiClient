package com.mugen.riot;

import com.mugen.riot.route.Continent;
import com.mugen.riot.route.Region;
import com.mugen.riot.route.Route;
import com.mugen.riot.service.AccountService;
import com.mugen.riot.service.MatchService;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ToString
@EqualsAndHashCode
public class RiotApiProvider {

    private static final String PROTOCOL_URL = "https://";
    private static final String LEAGUE_OF_LEGENDS_API_URL = ".api.riotgames.com";
    private static final Set<Class<?>> continentApis = Set.of(AccountService.class, MatchService.class);

    @Getter
    @ToString.Exclude
    private final String apiKey;
    private final OkHttpClient okHttpClient;
    private final Map<Route, Retrofit> retrofitByRoute;

    public RiotApiProvider(String apiKey) {
        this.apiKey = apiKey;
        this.okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new RiotApiHeaderInterceptor(apiKey))
                .build();
        this.retrofitByRoute = Stream.concat(Arrays.stream(Region.values()), Arrays.stream(Continent.values()))
                .collect(Collectors.toMap(Function.identity(), route -> buildRetrofit(route.getPath())));
    }

    public <T> Map<Route, T> generateApi(Class<T> api) {
        Class<? extends Route> routeClass = continentApis.contains(api) ? Continent.class : Region.class;

        return Arrays.stream(routeClass.getEnumConstants())
                .collect(Collectors.toMap(Function.identity(), route -> this.retrofitByRoute.get(route).create(api)));
    }

    private Retrofit buildRetrofit(String path) {
        return new Retrofit.Builder()
                .baseUrl(PROTOCOL_URL + path + LEAGUE_OF_LEGENDS_API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
