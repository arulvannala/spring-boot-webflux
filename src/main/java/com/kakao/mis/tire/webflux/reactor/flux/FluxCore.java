package com.kakao.mis.tire.webflux.reactor.flux;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

/**
 * @see Flux
 */
public class FluxCore<T> {

    /**
     * To be used by custom operators
     * Hooks.onEachOperatorHook / GLOBAL_TRACE apply
     * @see Flux#onAssembly(Flux)
     */
    protected static <T> Flux<T> onAssembly(final Flux<T> source) {
        return Flux.empty();
    }

    /**
     * @see Flux#share()
     */
    public final Flux<T> share() {
        return Flux.empty();
    }

    /**
     * @see Flux#publish()
     * @see Flux#publish(int)
     */
    public final ConnectableFlux<T> publish() {
        return null;
    }
}
