package com.innovyze.aquaservice.platform.u202311334.incidents.domain.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record AssetCode(UUID code) {

    public AssetCode {
        if (code == null) {
            throw new IllegalArgumentException("Asset code must not be null.");
        }
    }

    public static AssetCode from(String raw) {
        try {
            return new AssetCode(UUID.fromString(raw));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Asset code must be a valid UUID.");
        }
    }

    @Override
    public String toString() {
        return code.toString();
    }
}
