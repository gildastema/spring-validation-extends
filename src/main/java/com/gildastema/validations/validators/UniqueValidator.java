package com.gildastema.validations.validators;

import com.gildastema.validations.constraints.Unique;

import javax.sql.DataSource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    private final DataSource dataSource;
    private String field;
    private String table;

    public UniqueValidator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void initialize(Unique constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        field = constraintAnnotation.field();
        table = constraintAnnotation.table();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        try {
            final Connection connection = dataSource.getConnection();
            final String query = String.format( "select count(%s) from %s where %s = '%s';", field, table, field,value.toString());
            final PreparedStatement statement =  connection.prepareStatement("select count("+ field+") as number_el from "+ table +" where "+ field +"= ?");
            statement.setString(1, value.toString());
            final ResultSet result = statement.executeQuery();
            return result.next() && result.getInt("number_el") == 0 ;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
