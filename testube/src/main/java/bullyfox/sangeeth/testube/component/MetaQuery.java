package bullyfox.sangeeth.testube.component;

/**
 * Created by Sangeeth Nandakumar on 22-05-2017.
 */

public class MetaQuery {
    String databaseName;
    String tableName;
    String schemaQuery;

    public MetaQuery(String databaseName, String tableName, String schemaQuery) {
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.schemaQuery = schemaQuery;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getSchemaQuery() {
        return schemaQuery;
    }
}
