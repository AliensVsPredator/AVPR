package org.avpr.common.api.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Utility class for appending labeled components to a tooltip.
 */
public record TooltipUtils() {

    /**
     * Appends a labeled component to the provided list of components. The label is styled with a dark green color and
     * the appended component is styled with a gray color.
     *
     * @param components The list to which the labeled component will be appended.
     * @param label      The label that will be translated and displayed in dark green color.
     * @param component  The component that will be appended and styled in gray color.
     */
    public static void appendLabel(@NotNull List<Component> components, String label, MutableComponent component) {
        components.add(
            Component.translatable(label)
                .withStyle(ChatFormatting.DARK_GREEN)
                .append(component.withStyle(ChatFormatting.GRAY))
        );
    }
}
