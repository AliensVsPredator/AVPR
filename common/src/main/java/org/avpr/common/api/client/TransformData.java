package org.avpr.common.api.client;

public record TransformData(
    double originX,
    double originY,
    double originZ,
    double faceOffset,
    double headOffset
) {}
