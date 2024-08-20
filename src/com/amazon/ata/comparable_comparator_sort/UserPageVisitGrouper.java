package com.amazon.ata.comparable_comparator_sort;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides grouping functionality for UserPageVisits that is used by UserPageVisitAggregator.
 * The only grouping functionality that's currently available is based on UserPageVisit natural order.
 */
public class UserPageVisitGrouper {
    /**
     * Returns a sorted list of UserPageVisits based on their natural order. Original list is not modified.
     * @param userPageVisits List of UserPageVisits
     * @return sorted list of userPageVisits
     */
    public List<UserPageVisit> groupUserPageVisits(List<UserPageVisit> userPageVisits) {
        // PARTICIPANTS: add logic to implement groupUserPageVisits here
        List<UserPageVisit> userPageVisitsCopy = new ArrayList<>();
        userPageVisitsCopy.add(userPageVisits.get(0));
        for (int i = 1; i < userPageVisits.size(); i++) {
            int w = 0;
            for (int j = 0; j < userPageVisitsCopy.size(); j++) {
                if (userPageVisits.get(i).compareTo(userPageVisitsCopy.get(j)) < 0) {
                    userPageVisitsCopy.add(j, userPageVisits.get(i));
                    w = 1;
                    break;
                }
            }
            if (w == 0) {
                userPageVisitsCopy.add(userPageVisits.get(i));
            }
        }
        return userPageVisitsCopy;
    }
}
