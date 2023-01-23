package net.kyori.adventure.platform.forge.impl.service;

import java.util.function.Consumer;
import net.kyori.adventure.platform.forge.impl.NBTLegacyHoverEventSerializer;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.jetbrains.annotations.NotNull;

public class GsonComponentSerializerProviderImpl implements GsonComponentSerializer.Provider {
    @Override
    public @NotNull GsonComponentSerializer gson() {
        return GsonComponentSerializer.builder()
            .legacyHoverEventSerializer(NBTLegacyHoverEventSerializer.INSTANCE)
            .build();
    }

    @Override
    public @NotNull GsonComponentSerializer gsonLegacy() {
        return GsonComponentSerializer.builder()
            .legacyHoverEventSerializer(NBTLegacyHoverEventSerializer.INSTANCE)
            .downsampleColors()
            .emitLegacyHoverEvent()
            .build();
    }

    @Override
    public @NotNull Consumer<GsonComponentSerializer.Builder> builder() {
        return builder -> builder.legacyHoverEventSerializer(NBTLegacyHoverEventSerializer.INSTANCE);
    }
}
