package dao;


import model.ActivityLog;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ActivityLogDAO {
    ActivityLog create(ActivityLog activityLog);
    List<ActivityLog> filter(ActivityLog.actionType actionType);
    List<ActivityLog> filter(int id); // change?
    List<ActivityLog> filter(Date date);
    List<ActivityLog> filter(Date startDate, Date endDate);
    void update(ActivityLog activityLog); // change?
    void delete(ActivityLog activityLog); // change?
}
