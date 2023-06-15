package synopsys.aliasPassPathRecordTest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCase2 {


    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @RequestMapping
    public void testCase(@RequestParam String testParamIn) {
        A a =new A();
        G b = a.g;
        foo(a);
        sink(b.f);
    }

    private void sink(Object f) {
        jdbcTemplate.queryForMap("select * from xxx"+f.toString());
    }

    public void foo(A z){
        G x = z.g;
        Object w = sqlInjectionSource();
        x.f = w;
    }

    private Object sqlInjectionSource() {
        return jdbcTemplate.queryForMap("select * from xxx");
    }

}
