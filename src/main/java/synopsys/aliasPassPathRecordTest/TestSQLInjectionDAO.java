package synopsys.aliasPassPathRecordTest;

import org.apache.ibatis.annotations.Param;

public interface TestSQLInjectionDAO {
    void sqlInjection(@Param(value = "aliasSource") String aliasSource);
}
