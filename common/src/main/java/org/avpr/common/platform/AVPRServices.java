package org.avpr.common.platform;

import java.util.ServiceLoader;

/**
 * The AVPRServices class is a utility class that provides access to various registry services. It offers a centralized
 * way to load services and register game elements. The COMMON_REGISTRY field is an instance of the CommonRegistry,
 * which provides a variety of methods for registering game-related components such as blocks, items, entities, and
 * more. The load method is used to load a service of the specified class type using the Java ServiceLoader mechanism.
 */
public class AVPRServices {

    public static final CommonRegistry COMMON_REGISTRY = load(CommonRegistry.class);

    private AVPRServices() {
        throw new UnsupportedOperationException();
    }

    public static <T> T load(Class<T> clazz) {
        return ServiceLoader.load(clazz)
            .findFirst()
            .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
    }
}
