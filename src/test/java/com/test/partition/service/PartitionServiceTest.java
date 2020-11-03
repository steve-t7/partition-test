package com.test.partition.service;


import com.test.partition.service.impl.PartitionServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartitionServiceTest {

    private IPartitionService partitionService;

    @Before
    public void initTest() {
        partitionService = new PartitionServiceImpl();
    }

    @Test
    public void emptyArrayLimitOf2() {
        // Given
        final List<Integer> liste = new ArrayList<>();
        final int taille = 2;

        // When
        final List<List<Integer>> partitions = partitionService.partition(liste, taille);

        // Then
        final int expectedResultSize = 0;
        assertEquals(expectedResultSize, partitions.size());

        final List<List<Integer>> expectedResult = Collections.emptyList();
        assertEquals(expectedResult, partitions);
    }

    @Test
    public void nullArrayLimitOf2() {
        // Given
        final List<Integer> liste = null;
        final int taille = 2;

        // When
        final List<List<Integer>> partitions = partitionService.partition(liste, taille);

        // Then
        final int expectedResultSize = 0;
        assertEquals(expectedResultSize, partitions.size());

        final List<List<Integer>> expectedResult = Collections.emptyList();
        assertEquals(expectedResult, partitions);
    }

    @Test
    public void arrayOf5ElementsLimitOf0() {
        // Given
        final List<Integer> liste = List.of(1, 2, 3, 4, 5);
        final int taille = 0;

        // When
        final List<List<Integer>> partitions = partitionService.partition(liste, taille);

        // Then
        final int expectedResultSize = 1;
        assertEquals(expectedResultSize, partitions.size());
        assertEquals(liste, partitions.get(0));
    }

    @Test
    public void arrayOf5ElementsNegativeLimit() {
        // Given
        final List<Integer> liste = List.of(1, 2, 3, 4, 5);
        final int taille = -10;

        // When
        final List<List<Integer>> partitions = partitionService.partition(liste, taille);

        // Then
        final int expectedResultSize = 1;
        assertEquals(expectedResultSize, partitions.size());
        assertEquals(liste, partitions.get(0));
    }

    @Test
    public void arrayOf5ElementsLimitOf2() {
        // Given
        final List<Integer> liste = List.of(1, 2, 3, 4, 5);
        final int taille = 2;

        // When
        final List<List<Integer>> partitions = partitionService.partition(liste, taille);

        // Then
        final int expectedResultSize = 3;
        assertEquals(expectedResultSize, partitions.size());

        final List<Integer> expectedFirstList = List.of(1, 2);
        final List<Integer> expectedSecondList = List.of(3, 4);
        final List<Integer> expectedThirdList = List.of(5);
        assertEquals(expectedFirstList, partitions.get(0));
        assertEquals(expectedSecondList, partitions.get(1));
        assertEquals(expectedThirdList, partitions.get(2));
    }

    @Test
    public void arrayOf5ElementsLimitOf3() {
        // Given
        final List<Integer> liste = List.of(1, 2, 3, 4, 5);
        final int taille = 3;

        // When
        final List<List<Integer>> partitions = partitionService.partition(liste, taille);

        // Then
        final int expectedResultSize = 2;
        assertEquals(expectedResultSize, partitions.size());

        final List<Integer> expectedFirstList = List.of(1, 2, 3);
        final List<Integer> expectedSecondList = List.of(4, 5);
        assertEquals(expectedFirstList, partitions.get(0));
        assertEquals(expectedSecondList, partitions.get(1));
    }

    @Test
    public void arrayOf5ElementsLimitOf1() {
        // Given
        final List<Integer> liste = List.of(1, 2, 3, 4, 5);
        final int taille = 1;

        // When
        final List<List<Integer>> partitions = partitionService.partition(liste, taille);

        // Then
        final int expectedResultSize = 5;
        assertEquals(expectedResultSize, partitions.size());

        final List<Integer> expectedFirstList = List.of(1);
        final List<Integer> expectedSecondList = List.of(2);
        final List<Integer> expectedThirdList = List.of(3);
        final List<Integer> expectedFourthList = List.of(4);
        final List<Integer> expectedFifthList = List.of(5);
        assertEquals(expectedFirstList, partitions.get(0));
        assertEquals(expectedSecondList, partitions.get(1));
        assertEquals(expectedThirdList, partitions.get(2));
        assertEquals(expectedFourthList, partitions.get(3));
        assertEquals(expectedFifthList, partitions.get(4));
    }
}
