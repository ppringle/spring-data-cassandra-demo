package com.pringweb.cassandra.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@AllArgsConstructor
@Getter
@Setter
@Table
public class Employee {

    @PrimaryKey
    private @NonNull String id;

    private @NonNull String firstName;

    private @NonNull String lastName;

    private @NonNull String email;

}
