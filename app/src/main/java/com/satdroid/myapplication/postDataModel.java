package com.satdroid.myapplication;

public class postDataModel {

    private String node_id,battery_status,last_chunk_download_time;
    private long network_speed_,free_bytes,used_bandwidth;

    public postDataModel(String node_id,long network_speed_,String battery_status, long free_bytes , long used_bandwidth,String last_chunk_download_time) {
        this.node_id = node_id;
        this.battery_status = battery_status;
        this.last_chunk_download_time = last_chunk_download_time;
        this.network_speed_ = network_speed_;
        this.free_bytes = free_bytes;
        this.used_bandwidth = used_bandwidth;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getBattery_status() {
        return battery_status;
    }

    public void setBattery_status(String battery_status) {
        this.battery_status = battery_status;
    }

    public String getLast_chunk_download_time() {
        return last_chunk_download_time;
    }

    public void setLast_chunk_download_time(String last_chunk_download_time) {
        this.last_chunk_download_time = last_chunk_download_time;
    }

    public long getNetwork_speed_() {
        return network_speed_;
    }

    public void setNetwork_speed_(long network_speed_) {
        this.network_speed_ = network_speed_;
    }

    public long getFree_bytes() {
        return free_bytes;
    }

    public void setFree_bytes(long free_bytes) {
        this.free_bytes = free_bytes;
    }

    public long getUsed_bandwidth() {
        return used_bandwidth;
    }

    public void setUsed_bandwidth(long used_bandwidth) {
        this.used_bandwidth = used_bandwidth;
    }
}
