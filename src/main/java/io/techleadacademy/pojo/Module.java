package io.techleadacademy.pojo;

public class Module {

    private int module_id;
    private String module_name;
    private int module_order;

    public Module(int module_id, String module_name, int module_order) {
        this.module_id = module_id;
        this.module_name = module_name;
        this.module_order = module_order;
    }

    public int getModule_id() {
        return module_id;
    }

    public void setModule_id(int module_id) {
        this.module_id = module_id;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public int getModule_order() {
        return module_order;
    }

    public void setModule_order(int module_order) {
        this.module_order = module_order;
    }

    @Override
    public String toString() {
        return "Module{" +
                "module_id=" + module_id +
                ", module_name='" + module_name + '\'' +
                ", module_order='" + module_order + '\'' +
                '}';
    }
}
