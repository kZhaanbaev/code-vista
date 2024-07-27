package io.techleadacademy.pojo;

public class Module {
    private int moduleId;
    private String moduleName;
    private double moduleOrder;
    private String videoLink;
    private String createTime;
    private String updateTime;

    public Module(int module_id, String module_name, double module_order, String video_link) {
        this.moduleId = module_id;
        this.moduleName = module_name;
        this.moduleOrder = module_order;
        this.videoLink = video_link;
    }

    public Module(){}

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public double getModuleOrder() {
        return moduleOrder;
    }

    public void setModuleOrder(double moduleOrder) {
        this.moduleOrder = moduleOrder;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Module{" +
                "module_id=" + moduleId +
                ", module_name='" + moduleName + '\'' +
                ", module_order=" + moduleOrder +
                ", video_link='" + videoLink + '\'' +
                '}';
    }
}
