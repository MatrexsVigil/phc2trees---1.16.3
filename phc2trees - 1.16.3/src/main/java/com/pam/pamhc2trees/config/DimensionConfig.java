package com.pam.pamhc2trees.config;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.ForgeConfigSpec;

public class DimensionConfig {
	public static ForgeConfigSpec.ConfigValue<List<? extends String>> whitelist;
	public static ForgeConfigSpec.ConfigValue<List<? extends String>> blacklist;

	public static void init(ForgeConfigSpec.Builder config) {

		whitelist = config.comment("Enter a dimension id to whitelist feature generation").defineList("white_dim",
				Arrays.asList("minecraft:overworld"), new Predicate<Object>() {
					@Override
					public boolean apply(@Nullable Object val) {
						return val instanceof String && ResourceLocation.tryCreate((String)val) != null;
					}
				});

		blacklist = config.comment("Enter a dimension id to blacklist feature generation").defineList("black_dim",
				Arrays.asList("minecraft:the_end", "minecraft:the_nether"), new Predicate<Object>() {
					@Override
					public boolean apply(@Nullable Object val) {
						return val instanceof String && ResourceLocation.tryCreate((String)val) != null;
					}
				});

	}

}