# Point-of-sale tool
This is a point of sale tool for a store that rents big tools.

# Motivation
This is a programming demonstration for an interview process.

# Language
This project is written in Java.

# Tests
Unit tests for this project can be found in \src\test. The required tests from the specification document can be found at \src\test\SpecTests.java

# How to use?
You can greate a Checkout object using the following constructor:

`Checkout(String toolCode, int rentalDayCount, int discountPercent, String checkOutDate)`

You can also generate a Rental Agreement object by calling the following funtion on the Checkout object:

`generateRentalAgreement()`

To print the Rental Agreement object to the console call:

`printRentalAgreement()`
