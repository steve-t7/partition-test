package com.test.partition.service.impl;

import com.test.partition.service.IPartitionService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartitionServiceImpl implements IPartitionService {

    public List<List<Integer>> partition(List<Integer> liste, int taille) {
        if (liste != null && !liste.isEmpty()) {
            if (taille <= 0) {
                return List.of(liste);
            } else {
                List<List<Integer>> result = new ArrayList<>();
                List<Integer> currentList = new ArrayList<>();
                for (Integer number : liste) {
                    if (currentList.size() == taille) {
                        result.add(currentList);
                        currentList = new ArrayList<>();
                    }
                    currentList.add(number);
                }
                result.add(currentList);
                return result;
            }
        }
        return Collections.emptyList();
    }
}
