package org.jenkinsci.plugins.gogs;

import hudson.EnvVars;
import hudson.model.AbstractBuild;
import hudson.model.EnvironmentContributingAction;
import hudson.model.InvisibleAction;

import javax.annotation.Nonnull;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GogsPayload extends InvisibleAction implements EnvironmentContributingAction {
    private final @Nonnull String payload;

    public GogsPayload(@Nonnull String payload) {
        this.payload = payload;
    }

    @Nonnull
    public String getPayload() {
        return payload;
    }

    @Override
    public void buildEnvVars(AbstractBuild<?, ?> abstractBuild, EnvVars envVars) {
        final String payload = getPayload();
        LOGGER.log(Level.FINEST, "Injecting GOGS_PAYLOAD: {0}", payload);
        envVars.put("GOGS_PAYLOAD", payload);
    }

    private static final Logger LOGGER = Logger.getLogger(GogsPayload.class.getName());
} 
