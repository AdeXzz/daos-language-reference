package com.innovyze.aquaservice.platform.u202311334.shared.infrastructure.persistence.jpa.configuration.strategy;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import static io.github.encryptorcode.pluralize.Pluralize.pluralize;

public class SnakeCaseWithPluralizedTablePhysicalNamingStrategy implements PhysicalNamingStrategy {

    @Override
    public Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return toSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return toSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return toSnakeCase(toPlural(identifier));
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return toSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return toSnakeCase(identifier);
    }

    private Identifier toSnakeCase(Identifier identifier) {
        if (identifier == null) return null;
        String regex = "([a-z])([A-Z])";
        String replacement = "$1_$2";
        String newName = identifier.getText().replaceAll(regex, replacement).toLowerCase();
        return Identifier.toIdentifier(newName);
    }

    private Identifier toPlural(Identifier identifier) {
        String newName = pluralize(identifier.getText());
        return Identifier.toIdentifier(newName);
    }
}
