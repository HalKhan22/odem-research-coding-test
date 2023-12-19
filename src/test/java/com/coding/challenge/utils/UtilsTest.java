package com.coding.challenge.utils;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UtilsTest {

    private CalculateParameters calculateParameters = new CalculateParameters();

    @Test
    void calculateMaxTimeGap() {
        long[] timestampArr = {57124702l,57125641l,57127783l};
        int expectedMaxTimeGap = 2142;
        Assertions.assertEquals(expectedMaxTimeGap, calculateParameters.calculateMaxTimeGap(timestampArr));
    }

    @Test
    void calculateMaxTimeGapWhenOnlyOne() {
        long[] timestampArr = {57124702l};
        int expectedMaxTimeGap = 0;
        Assertions.assertEquals(expectedMaxTimeGap, calculateParameters.calculateMaxTimeGap(timestampArr));
    }

  @Test
  void caluclateVolumeTraded() {
        int[] quantities = {10,20,30};
        int expectedVolumeTraded  = 60;
      Assertions.assertEquals(expectedVolumeTraded, calculateParameters.calculateSum(quantities));
  }

  @Test
  void calculateMaxTradePrice() {
      int[] prices = {10,20,30};
      int expectedMaxTradePrice  = 30;
      Assertions.assertEquals(expectedMaxTradePrice, calculateParameters.calculateMaxValue(prices));
  }

  @Test
  void calculateWeightedAveragePrice() {
      int[] quantities = {20,5};
      int[] prices = {18,7};
      int expectedWeightedAveragePrice = 15;
      Assertions.assertEquals(expectedWeightedAveragePrice, calculateParameters.calculateWeightedAveragePrice(quantities,prices));
  }


}