package ru.alfabattle.contest.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.alfabattle.contest.project.entity.QueueLog;

import java.util.List;

public interface QueueLogRepository extends JpaRepository<QueueLog, Long> {

    @Query(value = "SELECT * FROM queue_log l WHERE branches_id = :branchId AND EXTRACT(dow FROM data) = :dayOfWeek AND EXTRACT(hour FROM start_time_of_wait) = :hourOfDay", nativeQuery = true)
    List<QueueLog> findByBranchIdDayOfWeeAndHourOfDay(
            @Param("branchId") long branchId,
            @Param("dayOfWeek") int dayOfWeek,
            @Param("hourOfDay") int hourOfDay
    );
}
