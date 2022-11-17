#!/bin/bash

if [[ -z "${CASSANDRA_USER}" ]]
  echo "<CASSANDRA_USER> already set..."
then
  CASSANDRA_USER="cassandra"
fi

if [[ -z "${CASSANDRA_PASSWORD}" ]]
  echo "<CASSANDRA_PASSWORD> already set..."
then
  CASSANDRA_PASSWORD="cassandra"
fi

create_demo_keyspace()
{
  CQL="CREATE KEYSPACE IF NOT EXISTS demo WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};"
  echo "The sql statement is $CQL"
  echo "$CQL" | cqlsh -u ${CASSANDRA_USER} -p ${CASSANDRA_PASSWORD}
}

create_demo_keyspace

