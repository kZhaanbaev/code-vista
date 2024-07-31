package io.techleadacademy.stepDefs.apiSteps;


import io.techleadacademy.core.TestContext;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class Temp {

    TestContext testContext = new TestContext();

    @Test
    public  void testNewModuleCreation() {
        Map<String, Object> moduleData = new HashMap<>();
        moduleData.put("moduleName", "Test Marianna");
        moduleData.put("videoLink", "test");
        moduleData.put("moduleOrder", 66.0);

        testContext.API().ApiUtils.createNewModule(moduleData);
        testContext.API().response.prettyPrint();

    }

    @Test
    public  void testModuleDeletion() {
        testContext.API().ApiUtils.deleteModule(56);
        testContext.API().response.prettyPrint();

    }

}
