#!/usr/bin/env bash
mvn clean package
java -jar ./target/sales-tax-calculator-1.0-SNAPSHOT-jar-with-dependencies.jar ./input3.txt
