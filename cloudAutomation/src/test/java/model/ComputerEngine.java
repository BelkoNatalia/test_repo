package model;

public class ComputerEngine {

    private String numberOfInstances;
    private String operatingSystem;
    private String machineClass;
    private String machineType;
    private String numberOfGpu;
    private String gpuType;
    private String localSsd;
    private String datacenterLocation;
    private String commitedUsach;
    private String cost;

    public ComputerEngine(String numberOfInstances, String operatingSystem, String machineClass, String machineType,
                          String numberOfGpu, String gpuType, String localSsd, String datacenterLocation,
                          String commitedUsach) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.machineClass = machineClass;
        this.machineType = machineType;
        this.numberOfGpu = numberOfGpu;
        this.gpuType = gpuType;
        this.localSsd = localSsd;
        this.datacenterLocation = datacenterLocation;
        this.commitedUsach = commitedUsach;

    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getNumberOfGpu() {
        return numberOfGpu;
    }

    public void setNumberOfGpu(String numberOfGpu) {
        this.numberOfGpu = numberOfGpu;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getLocalSsd() {
        return localSsd;
    }

    public void setLocalSsd(String localSsd) {
        this.localSsd = localSsd;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommitedUsach() {
        return commitedUsach;
    }

    public void setCommitedUsach(String commitedUsach) {
        this.commitedUsach = commitedUsach;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
