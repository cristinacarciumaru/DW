package common;

import lombok.AllArgsConstructor;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.sql.Timestamp;

@PrimaryKeyClass
@AllArgsConstructor
public class DataKey {
    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    private String id;

    @PrimaryKeyColumn(name = "system_time", ordinal = 0)
    private Timestamp system_time;

    @PrimaryKeyColumn(name = "values_int", ordinal = 1, ordering = Ordering.DESCENDING)
    private int values_int;
}
