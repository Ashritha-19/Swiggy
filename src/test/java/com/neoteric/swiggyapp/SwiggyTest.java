package com.neoteric.swiggyapp;

import com.neoteric.swiggyapp.swiggymodel.Credentials;
import com.neoteric.swiggyapp.swiggymodel.GenerateOTP;
import com.neoteric.swiggyapp.swiggymodel.MenuItems;
import com.neoteric.swiggyapp.swiggymodel.Restaurant;
import com.neoteric.swiggyapp.swiggyservice.ItemService;
import com.neoteric.swiggyapp.swiggyservice.LoginService;
import com.neoteric.swiggyapp.swiggyservice.RestaurantService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SwiggyTest {

        @Test
        public void testLogin() {
            LoginService loginService = new LoginService();
            Credentials credentials = new Credentials();
            credentials.phnNumber = 900030833;

            GenerateOTP generatedOTP = loginService.login(credentials);

            Assertions.assertNotNull(generatedOTP);
            Assertions.assertEquals(1234, generatedOTP.generatedOTP);
        }

        @Test
        public void testGetLogingSuccessful() {
            LoginService loginService = new LoginService();
            Credentials credentials = new Credentials();
            credentials.phnNumber = 900030833;
            credentials.otp = new GenerateOTP();
            credentials.otp.generatedOTP = 1234;

            loginService.login(credentials);
            String result = loginService.getLoging(credentials);

            Assertions.assertEquals("Login Successful", result);
        }

        @Test
        public void testGetLogingInvalidOTP() {
            LoginService loginService = new LoginService();
            Credentials credentials = new Credentials();
            credentials.phnNumber = 900030833;
            credentials.otp = new GenerateOTP();
            credentials.otp.generatedOTP = 5678;

            loginService.login(credentials);
            String result = loginService.getLoging(credentials);

            Assertions.assertEquals("Invalid OTP", result);
        }

    @Test
    public void testGetItem() {
        ItemService itemService = new ItemService();
        MenuItems item1 = new MenuItems();
        item1.itemName = "CurdRice";
        MenuItems item2 = new MenuItems();
        item2.itemName = "Rasam";

        itemService.itemsList.add(item1);
        itemService.itemsList.add(item2);

        MenuItems result = itemService.getItem("CurdRice");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("CurdRice", result.itemName);
    }

    @Test
    public void testGetItemNotFound() {
        ItemService itemService = new ItemService();
        MenuItems item1 = new MenuItems();
        item1.itemName = "CurdRice";
        MenuItems item2 = new MenuItems();
        item2.itemName = "Rasam";

        itemService.itemsList.add(item1);
        itemService.itemsList.add(item2);

        MenuItems result = itemService.getItem("Biryani");

        Assertions.assertNull(result);
    }
    @Test
    public void testGetRestaurant() {
        RestaurantService restaurantService = new RestaurantService();
        Restaurant restaurant1 = new Restaurant();
        restaurant1.restaurantName = "Donkeyyz";
        Restaurant restaurant2 = new Restaurant();
        restaurant2.restaurantName = "Monkeyyyzzz";

        restaurantService.restaurantList.add(restaurant1);
        restaurantService.restaurantList.add(restaurant2);

        Restaurant result = restaurantService.getRestaurant("Donkeyyz");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Donkeyyz", result.restaurantName);
    }

    @Test
    public void testGetRestaurantNotFound() {
        RestaurantService restaurantService = new RestaurantService();
        Restaurant restaurant1 = new Restaurant();
        restaurant1.restaurantName = "Donkeyyz";
        Restaurant restaurant2 = new Restaurant();
        restaurant2.restaurantName = "Monkeyyyzzz";

        restaurantService.restaurantList.add(restaurant1);
        restaurantService.restaurantList.add(restaurant2);

        Restaurant result = restaurantService.getRestaurant("Funkeyzz");

        Assertions.assertNull(result);
    }
}
