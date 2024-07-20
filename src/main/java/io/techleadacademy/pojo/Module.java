package io.techleadacademy.pojo;

public class Module {
    private int module_id;
    private String module_name;
    private double module_order;
    private String video_link;

    public Module(int module_id, String module_name, double module_order, String video_link) {
        this.module_id = module_id;
        this.module_name = module_name;
        this.module_order = module_order;
        this.video_link = video_link;
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

    public double getModule_order() {
        return module_order;
    }

    public void setModule_order(double module_order) {
        this.module_order = module_order;
    }

    public String getVideo_link() {
        return video_link;
    }

    public void setVideo_link(String video_link) {
        this.video_link = video_link;
    }

    @Override
    public String toString() {
        return "Module{" +
                "module_id=" + module_id +
                ", module_name='" + module_name + '\'' +
                ", module_order=" + module_order +
                ", video_link='" + video_link + '\'' +
                '}';
    }
}
