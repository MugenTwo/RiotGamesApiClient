package com.mugen.riot;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class RiotApiHeaderInterceptor implements Interceptor {

    @Getter
    @ToString.Exclude
    private final String apiKey;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .addHeader("X-Riot-Token", this.apiKey)
                .build();

        return chain.proceed(request);
    }

}
