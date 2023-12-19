#!/usr/bin/env bash
./mvnw -DskipTests -Pnative clean package native:compile && ./target/gateway
