package com.kakao.mis.tire.webflux.reactor;

import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
class MonoZipCoreTest {

    @Test
    void test() throws InterruptedException {
        final List<String> list = List.of("1,2,3");

        final Mono<Void> mono = Mono.just(list)
                                    .map(it -> saveAll(it, 3000L))
                                    .then()
                                    .log();

        final Mono<Void> mono2 = Mono.just(list)
                                     .map(it -> saveAll(it, 4000L))
                                     .then()
                                     .log();

        Mono.zip(mono, mono2).block();
    }

    List<String> saveAll(final List<String> list, final long millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        log.info("save all");
        return list;
    }
}