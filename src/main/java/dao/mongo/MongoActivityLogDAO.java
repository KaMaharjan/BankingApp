package dao.mongo;

import dao.ActivityLogDAO;
import model.ActivityLog;

import java.util.Date;
import java.util.List;

public class MongoActivityLogDAO implements ActivityLogDAO {
    @Override
    public ActivityLog create(ActivityLog activityLog) {
        return null;
    }

    @Override
    public List<ActivityLog> filter(ActivityLog.actionType actionType) {
        return List.of();
    }

    @Override
    public List<ActivityLog> filter(int id) {
        return List.of();
    }

    @Override
    public List<ActivityLog> filter(Date date) {
        return List.of();
    }

    @Override
    public List<ActivityLog> filter(Date startDate, Date endDate) {
        return List.of();
    }

    @Override
    public void update(ActivityLog activityLog) {

    }

    @Override
    public void delete(ActivityLog activityLog) {

    }
}
