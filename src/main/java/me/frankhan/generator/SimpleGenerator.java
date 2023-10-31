package me.frankhan.generator;

import de.articdive.jnoise.generators.noise_parameters.interpolation.Interpolation;
import de.articdive.jnoise.generators.noisegen.perlin.PerlinNoiseGenerator;
import me.frankhan.Main;
import net.minestom.server.instance.block.Block;
import net.minestom.server.instance.generator.GenerationUnit;
import net.minestom.server.instance.generator.Generator;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class SimpleGenerator implements Generator {

    @Override
    public void generate(@NotNull GenerationUnit unit) {
        PerlinNoiseGenerator generator = PerlinNoiseGenerator.newBuilder().setSeed(Main.seed).setInterpolation(Interpolation.COSINE).build();
        for (int x = 0;x < unit.size().blockX();x++) {
            for (int z = 0;z < unit.size().blockY();z++) {
                int height = (int) (384*generator.evaluateNoise(x,z));
                unit.modifier().fillHeight(-64,height,Block.STONE);
            }
        }
    }

    @Override
    public void generateAll(@NotNull Collection<@NotNull GenerationUnit> units) {
        Generator.super.generateAll(units);
    }
}
