package synopsys.aliasPassPathRecordTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCase1 {

    public String aliasSource;

    @Autowired
    private TestSQLInjectionDAO testSQLInjectionDAO;

    @RequestMapping
    public void testCase(@RequestParam String testParamIn) {
        aliasSource = testParamIn;
        imitateSqlInjection();
    }

    private void imitateSqlInjection() {
        testSQLInjectionDAO.sqlInjection(aliasSource);
    }
}
