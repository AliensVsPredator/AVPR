package org.avpr.common.api.common;

/**
 * Enum representing the different firing modes for a gun. The gun can be set to one of the following modes: -
 * SEMI_AUTOMATIC: Fires one shot per trigger pull - AUTOMATIC: Continuously fires as long as the trigger is held -
 * BURST: Fires a set number of rounds with each trigger pull
 */
// TODO: Remove this, enums are terrible for modding.
public enum GunFireMode {
    SEMI_AUTOMATIC,
    AUTOMATIC,
    BURST
}
