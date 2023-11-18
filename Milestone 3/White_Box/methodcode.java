// Method to edit work availability
public String editWorkAvailability(int staffUID, DateTime oldAvailabilityDateTime, DateTime newTimeSlot) {      1
    // Assuming 'getUserAvailability' retrieves user's availability records
    Map<DateTime, Availability> availabilities = getUserAvailability(staffUID);                                 2
    // Check if the user has existing availability records
    if (availabilities != null && !availabilities.isEmpty()) {                                                  3
        // Decision point 1: Check if the selected availability DateTime exists for the user
        if (availabilities.containsKey(oldAvailabilityDateTime)) {                                              4
            Availability currentAvailability = availabilities.get(oldAvailabilityDateTime);                     5
            // Decision point 2: Check if the new time slot is different from the current one
            if (!currentAvailability.getTimeSlot().equals(newTimeSlot)) {                                       6
                // Proceed with the update
                currentAvailability.setTimeSlot(newTimeSlot);                                                   7
                // Assume 'updateAvailability' updates the record in the database
                updateAvailability(staffUID, oldAvailabilityDateTime, newTimeSlot);                             8
                return "Work availability updated successfully";                                                9
            } else {                                                                                            10
                // No changes made, exit function
                return "No changes to existing work availability";                                              11
            }
        } else {                                                                                                12
            // Invalid availability DateTime, return error
            return "Invalid work availability record selected";                                                 13
        }
    } else {                                                                                                    14
        // No existing records, return error
        return "No existing work availability records found";                                                   15
    }  
}                                                                                                               16