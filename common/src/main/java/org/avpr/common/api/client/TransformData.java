package org.avpr.common.api.client;

/**
 * A record representing the transformation data. This record stores the origin coordinates (X, Y, Z) and offset values
 * for face and head.
 *
 * @param originX    The X coordinate of the origin.
 * @param originY    The Y coordinate of the origin.
 * @param originZ    The Z coordinate of the origin.
 * @param faceOffset The offset value for the face.
 * @param headOffset The offset value for the head.
 */
public record TransformData(
    double originX,
    double originY,
    double originZ,
    double faceOffset,
    double headOffset
) {}
