package com.examples;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        String passenger="David aA";
        String passengerFRomSWF="Davida  Aa";
        String name ="Carey Limo";
        // String[] hotelNames = name.split(" ");

        String[] givenNames = passenger.split(" ");

        System.out.println("Comparison is "+  Arrays.stream(givenNames).anyMatch(passengerFRomSWF::equalsIgnoreCase));

        System.out.println("len:: "+ "REFUND TKT NO-0143568547813/SEGARAJASINGHE/PRAKASH ATHENAEUS BENJAMIN".length());

        System.out.println("Comparison is "+  Arrays.stream(givenNames).anyMatch(name1 -> Arrays.asList(passengerFRomSWF.toUpperCase().split(" ")).contains(name.toUpperCase()) ));
        System.out.println("Comparison is "+  Arrays.stream(givenNames).anyMatch(name1 -> Arrays.asList(passengerFRomSWF.toUpperCase().split(" ")).contains(name.toUpperCase()) ));
        System.out.println("result:: "+ name.toUpperCase().trim().contains("Carey".toUpperCase()));

        System.out.println("HOTEL_CANCEL_BOOKING".toLowerCase());
        //Arrays.stream(hotelNames).forEach(hotelName -> System.out.println(hotelName));

        /*
        HOTEL_MODIFIABILITY
HOTEL_HARD_MODIFY
HOTEL_SOFT_MODIFY
HOTEL_CHANGE_AVAILABILITY
HOTEL_DETAILS
HOTEL_POLICY
HOTEL_CANCEL_BOOKING
         */
    }


    public String setPassenger(String passenger){  return passenger;}
}