package com.github.stuartwdouglas.mavenproxy.resources;

import java.nio.file.Path;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Singleton
public class LocalCache {

    final Path path;
    final long outOfSpaceThreshold;

    public LocalCache(@ConfigProperty(name = "cache-path") Path path, @ConfigProperty(name = "cache-disk-percentage-allowed") double allowedPercentage) throws Exception {
        this.path = path;
        long totalSpace = path.getFileSystem().getFileStores().iterator().next().getUsableSpace();
        outOfSpaceThreshold = (long) (totalSpace * allowedPercentage);
    }

    public void doStuff() {

    }

}
